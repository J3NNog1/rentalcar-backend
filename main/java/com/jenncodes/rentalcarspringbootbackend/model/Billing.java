package com.jenncodes.rentalcarspringbootbackend.model;
//angelina created billing model class!

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name= "id")
    private Long id;

    @NotBlank(message = "Payment type is required")
    @Column(name= "payment_type")
    private String paymentType;

    @Positive(message = "Amount must be greater than 0")
//    @Min(value = 1, message = "Year must be greater than or equal to 1")
//    @Max(value = 1000000, message = "Year must be less than or equal to 1000000")
    @Column(name= "late_fee")
    private double lateFee;

    @Positive(message = "Total amount must be positive")
//    @Min(value = 1, message = "Year must be greater than or equal to 1")
//    @Max(value = 1000000, message = "Year must be less than or equal to 1000000")
    @Column(name= "total_amount")
    private double totalAmount;

    @NotBlank(message = "Bill status is required")
    @Column(name= "bill_status")
    private String billStatus;

    @NotNull(message = "Bill date is required")
    @Column(name= "bill_date")
    private String billDate;


}
