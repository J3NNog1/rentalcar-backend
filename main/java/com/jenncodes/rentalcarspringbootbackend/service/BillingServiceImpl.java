package com.jenncodes.rentalcarspringbootbackend.service;


import com.jenncodes.rentalcarspringbootbackend.exception.ResourceNotFoundException;
import com.jenncodes.rentalcarspringbootbackend.model.Billing;
import com.jenncodes.rentalcarspringbootbackend.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BillingServiceImpl implements BillingService {

    private final BillingRepository billingRepository;

    @Autowired
    public BillingServiceImpl(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    @Override
    public List<Billing> getAllBillings() {
        return billingRepository.findAll();
    }

    @Override
    public Billing createBilling(Billing billing) {
        return billingRepository.save(billing);
    }

    @Override
    public Optional<Billing> getBillingById(long id) {
        return billingRepository.findById(id);
    }

    @Override
    public Billing updateBilling(long id, Billing billingDetails) {
        Billing updateBilling = billingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Billing with id does not exist: " + id));

        updateBilling.setPaymentType(billingDetails.getPaymentType());
        updateBilling.setLateFee(billingDetails.getLateFee());
        updateBilling.setBillStatus(billingDetails.getBillStatus());
        updateBilling.setTotalAmount(billingDetails.getTotalAmount());
        updateBilling.setBillDate(billingDetails.getBillDate());

        return billingRepository.save(updateBilling);
    }

    @Override
    public void deleteBilling(long id) {
        Billing billing = billingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Billing with id does not exist: " + id));

        billingRepository.delete(billing);
    }
}
