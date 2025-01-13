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
import com.see_why.api.spring_boot_demo.CustomerRepository;
import com.see_why.api.spring_boot_demo.NewCustomerRequest;
import com.see_why.api.spring_boot_demo.WelcomeMessage;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
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
        return customerRepository.findAll();
    }

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setAge(request.age());
        customer.setEmail(request.email());
        customer.setName(request.name());
        customerRepository.save(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        Customer customer = customerRepository.findById(id)
            .orElseThrow();
        customerRepository.delete(customer);
    }

    @PutMapping("{customerId}")
    public Customer updateCustomer(
            @PathVariable("customerId") Integer id,
            @RequestBody NewCustomerRequest request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);
        return customer;
    }
} 