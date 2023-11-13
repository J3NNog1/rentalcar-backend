package com.jenncodes.rentalcarspringbootbackend.service;

import com.jenncodes.rentalcarspringbootbackend.model.Billing;

import java.util.List;
import java.util.Optional;

public interface BillingService {
    List<Billing> getAllBillings();
    Optional<Billing> getBillingById(long billingId);
    Billing createBilling(Billing billing);
    Billing updateBilling(long billingId,Billing updatedBilling);
    void deleteBilling(long billingId);
}
