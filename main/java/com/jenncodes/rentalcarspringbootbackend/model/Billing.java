package com.jenncodes.rentalcarspringbootbackend.model;
//angelina created billing model class!

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "billing")
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name= "billing_id")
    private String id;
    @Column(name= "payment_type")
    private String paymentType;
    @Column(name= "late_fee")
    private double lateFee;
    @Column(name= "booking_id")
    private String bookingId;
    @Column(name= "total_amount")
    private double totalAmount;
    @Column(name= "bill_status")
    private String billStatus;
    @Column(name= "bill_date")
    private String billDate;


}
