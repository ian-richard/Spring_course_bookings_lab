package com.example.demo.controllers;

import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

   @Autowired
   CustomerRepository customerRepository;

   @GetMapping(value="/customers")
    public ResponseEntity getAllCustomersAndFilters(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "age") Integer age,
            @RequestParam(required = false, name = "courseName") String courseName){

       if (courseName != null){
           return new ResponseEntity(customerRepository.findCustomerByBookingsCourseName(courseName), HttpStatus.OK);
       }
       if (town != null && courseName != null){
           return new ResponseEntity(customerRepository.findAllCustomersByBookingsCourseTownAndBookingsCourseName(town, courseName), HttpStatus.OK);
       }
       return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
   }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomers(@PathVariable Long id) {
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }



}
