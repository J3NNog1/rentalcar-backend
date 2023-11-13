package com.jenncodes.rentalcarspringbootbackend.controller;

import com.jenncodes.rentalcarspringbootbackend.exception.ResourceNotFoundException;
import com.jenncodes.rentalcarspringbootbackend.model.Billing;
import com.jenncodes.rentalcarspringbootbackend.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")   //http://localhost:8080/billing
public class BillingController {
    @Autowired
    private BillingRepository billingRepository;

    @GetMapping
    public List<Billing> getAllBillings(){
        return billingRepository.findAll();
    }

    //create post mapping for billing
    @PostMapping
    public Billing createBilling(@Validated @RequestBody Billing billing){
        return billingRepository.save(billing);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Billing> getBillingById(@PathVariable long id){
        Billing billing = billingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("billing with this id does not exist:" + id));
        return ResponseEntity.ok(billing);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Billing> updateBilling(@PathVariable long id, @RequestBody Billing billingDetails) {
        Billing updateBilling = billingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The billing with this id does not exist:" + id));
        updateBilling.setPaymentType(billingDetails.getPaymentType());
        updateBilling.setLateFee(billingDetails.getLateFee());
        updateBilling.setBillStatus(billingDetails.getBillStatus());
        updateBilling.setTotalAmount(billingDetails.getTotalAmount());
        updateBilling.setBillDate(billingDetails.getBillDate());

        billingRepository.save(updateBilling);
        return  ResponseEntity.ok(updateBilling);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBilling(@PathVariable long id) {
        Billing billing = billingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("billing does not exist with this id:" + id));
        billingRepository.delete(billing);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
