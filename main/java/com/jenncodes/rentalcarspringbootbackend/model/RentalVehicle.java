package com.jenncodes.rentalcarspringbootbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
    @Min(value = 1900, message = "Year must be greater than or equal to 1900")
    @Max(value = 9999, message = "Year must be less than or equal to 9999")
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
    @Min(value = 1, message = "Mileage must be greater than or equal to 1")
    @Max(value = 1000000, message = "Mileage must be less than or equal to 1000000")    @Column(name= "mileage")
    private String mileage;

}
