package com.jenncodes.rentalcarspringbootbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "rental-vehicle")
public class RentalVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name= "vehicle_type")
    private String vehicleType;
    @Column(name= "year")
    private String year;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name= "color")
    private String color;
    @Column(name= "mileage")
    private String mileage;

}
