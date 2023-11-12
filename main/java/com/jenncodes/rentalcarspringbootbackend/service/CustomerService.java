package com.jenncodes.rentalcarspringbootbackend.service;

import com.jenncodes.rentalcarspringbootbackend.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Optional<Customer> getCustomerById(long customerId);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(long customerId, Customer updatedCustomer);

    void deleteCustomer(long customerId);
}
