package com.intercorp.customerservice.configuration;

import com.intercorp.customerservice.service.CustomerService;
import com.intercorp.customerservice.service.CustomerServiceImpl;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class CustomerServiceConfiguration {

    @Primary
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource()
    {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public CustomerService customerService(){
        return new CustomerServiceImpl();
    }

    @Bean
    public StandardDeviation standardDeviation(){
        return new StandardDeviation();
    }

    @Bean
    public Mean mean(){
        return new Mean();
    }

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.intercorp.customerservice.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider(InMemorySwaggerResourcesProvider defaultResourcesProvider) {
        return () -> {
            SwaggerResource wsResource = new SwaggerResource();
            wsResource.setName("default");
            wsResource.setSwaggerVersion("2.0");
            wsResource.setLocation("/swagger.json");

            List<SwaggerResource> resources = new ArrayList<>();
            resources.add(wsResource);
            return resources;
        };
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Customer Service API",
                "Este servicio provee una serie de metodos relacionados a sus Clientes",
                "1.0",
                "http://someweburl.com/terms",
                new Contact("José Luis Olivares Rojas", "https://github.com/devsinsight", "olivares.rojas.jose@gmail.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}