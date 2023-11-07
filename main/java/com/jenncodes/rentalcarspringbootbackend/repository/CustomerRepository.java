package com.jenncodes.rentalcarspringbootbackend.repository;

import com.jenncodes.rentalcarspringbootbackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
