package com.jenncodes.rentalcarspringbootbackend.controller;



import com.jenncodes.rentalcarspringbootbackend.exception.ResourceNotFoundException;
import com.jenncodes.rentalcarspringbootbackend.model.Customer;
import com.jenncodes.rentalcarspringbootbackend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    //create post mapping for rental vehicle
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("customer with this id does not exist:" + id));
        return ResponseEntity.ok(customer);
    }
    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody Customer customerDetails) {
        Customer updateCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The customer with this id does not exist:" + id));
        updateCustomer.setFirstName(customerDetails.getFirstName());
        updateCustomer.setLastName(customerDetails.getLastName());
        updateCustomer.setPhoneNumber(customerDetails.getPhoneNumber());
        updateCustomer.setDriversLicenseNumber(customerDetails.getDriversLicenseNumber());

        customerRepository.save(updateCustomer);
        return  ResponseEntity.ok(updateCustomer);
    }

}
