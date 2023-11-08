package com.jenncodes.rentalcarspringbootbackend.repository;

import com.jenncodes.rentalcarspringbootbackend.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BillingRepository extends JpaRepository<Billing, Long> {
    //all crud methods called
}
