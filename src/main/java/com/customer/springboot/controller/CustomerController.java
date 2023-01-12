package com.customer.springboot.controller;

import com.customer.springboot.model.Customer;
import com.customer.springboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


//    public ResponseEntity<Customer> getCustomerByName(Long id){
//
//        Customer customer = customerRepository.find
//
//
//    }

}
