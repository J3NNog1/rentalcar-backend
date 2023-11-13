package com.jenncodes.rentalcarspringbootbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

    @NotBlank(message = "Vehicle type is required")
    @Column(name= "vehicle_type")
    private String vehicleType;

    @NotBlank(message = "Year is required")
    @Pattern(regexp = "\\d{4}", message = "Year must be a four-digit number")
    @Column(name= "year")
    private String year;

    @NotBlank(message = "Make is required")
    @Column(name = "make")
    private String make;

    @NotBlank(message = "Model is required")
    @Column(name = "model")
    private String model;

    @NotBlank(message = "Color is required")
    @Column(name= "color")
    private String color;

    @NotBlank(message = "Mileage is required")
    @Pattern(regexp = "\\d+", message = "Mileage must be a number")
    @Column(name= "mileage")
    private String mileage;

}
