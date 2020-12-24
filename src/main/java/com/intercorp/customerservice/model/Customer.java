package com.intercorp.customerservice.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import javax.validation.constraints.*;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacio.")
    @Column(name = "firstName")
    private String firstName;

    @NotBlank(message = "El apellido no puede estar vacio.")
    @Column(name="lastName")
    private String lastName;

    @Min(value = 0,message = "La edad minima es 0")
    @Max(value = 100, message = "La edad máxima es 100 años.")
    @Column(name = "age")
    private Integer age;

    @NotNull(message = "La fecha de nacimiento no puede estar vacia.")
    @Column(name = "birthdate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthdate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate probableDeathDate;

    public Customer(){
    }

    public Customer(String firstName, String lastName, Integer age, LocalDate birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthdate = birthdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public LocalDate getProbableDeathDate() {
        return probableDeathDate;
    }

    public void setProbableDeathDate(LocalDate probableDeathDate) {
        this.probableDeathDate = probableDeathDate;
    }

    public void createProbableDeathAge(){
        int min = getAge();
        int max = 100 - min;
        int dAge = (int) (Math.random() * (max - min + 1) + min);
        LocalDate probableDeathDate = getBirthdate().plusYears(dAge);
        this.probableDeathDate = probableDeathDate;
    }
}
