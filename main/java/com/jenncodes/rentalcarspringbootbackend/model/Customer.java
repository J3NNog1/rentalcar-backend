package com.jenncodes.rentalcarspringbootbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private long id;

    @NotBlank(message = "First name is required")
    @Column(name= "first_name")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Column(name= "last_name")
    private String lastName;

    @Positive(message = "Please enter a valid phone number")
    @Column(name= "phone_number")
    private int phoneNumber;

    @Positive(message = "Please enter a valid drivers license number")
    @Column(name="drivers_license_number")
    private int driversLicenseNumber;


    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations;



}
