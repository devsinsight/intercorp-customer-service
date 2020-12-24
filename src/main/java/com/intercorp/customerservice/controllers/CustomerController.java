package com.intercorp.customerservice.controllers;

import com.intercorp.customerservice.model.Customer;
import com.intercorp.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/customer/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @CrossOrigin
    @RequestMapping(value = "listaclientes", method = RequestMethod.GET)
    public List<Customer> get(){
        return customerService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "creacliente", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Customer create(@Valid @RequestBody Customer customer){
        customerService.save(customer);
        return customer;
    }

    @CrossOrigin
    @RequestMapping(value = "kpiclientes", method = RequestMethod.GET)
    public HashMap<String, Double> getKPI(){
        double sd = customerService.getClientsAgeStandardDeviation();
        double mean = customerService.getClientsAgeMean();

        HashMap<String, Double> map = new HashMap<String, Double>();
        map.put("DesviacionEstandarEdadClientes", sd);
        map.put("PromedioEdadClientes", mean);

        return map;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
