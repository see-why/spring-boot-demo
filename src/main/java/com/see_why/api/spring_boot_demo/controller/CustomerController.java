package com.see_why.api.spring_boot_demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.see_why.api.spring_boot_demo.Customer;
import com.see_why.api.spring_boot_demo.NewCustomerRequest;
import com.see_why.api.spring_boot_demo.WelcomeMessage;
import com.see_why.api.spring_boot_demo.service.CustomerService;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public WelcomeMessage welcome() {
        return new WelcomeMessage(
            "Welcome to SpringBoot",
            List.of("C#", "Python", "Ruby")
        );
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request) {
        customerService.addCustomer(request);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerService.deleteCustomer(id);
    }

    @PutMapping("{customerId}")
    public Customer updateCustomer(
            @PathVariable("customerId") Integer id,
            @RequestBody NewCustomerRequest request) {
        return customerService.updateCustomer(id, request);
    }
} 