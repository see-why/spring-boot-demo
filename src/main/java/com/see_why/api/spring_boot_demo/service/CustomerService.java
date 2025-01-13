package com.see_why.api.spring_boot_demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.see_why.api.spring_boot_demo.Customer;
import com.see_why.api.spring_boot_demo.CustomerRepository;
import com.see_why.api.spring_boot_demo.NewCustomerRequest;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void addCustomer(NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setAge(request.age());
        customer.setEmail(request.email());
        customer.setName(request.name());
        customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow();
        customerRepository.delete(customer);
    }

    public Customer updateCustomer(Integer id, NewCustomerRequest request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);
        return customer;
    }
} 