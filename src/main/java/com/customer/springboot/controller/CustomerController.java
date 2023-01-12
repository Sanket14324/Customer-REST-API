package com.customer.springboot.controller;

import com.customer.springboot.exception.ResourceNotFoundException;
import com.customer.springboot.model.Customer;
import com.customer.springboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }


    @GetMapping("{name}")
    public ResponseEntity<List<Customer>> getCustomerByName(@PathVariable String name){

        List<Customer> customerList = customerRepository.findAll().stream().filter(customer -> Objects.equals(customer.getName(), name))
                .collect(Collectors.toList());
        if(customerList.size() == 0){
            throw new ResourceNotFoundException("Employee not exist with name :"+name);
        }

        return ResponseEntity.ok(customerList);
    }

}
