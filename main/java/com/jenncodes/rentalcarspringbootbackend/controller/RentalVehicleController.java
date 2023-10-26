package com.jenncodes.rentalcarspringbootbackend.controller;


import com.jenncodes.rentalcarspringbootbackend.exception.ResourceNotFoundException;
import com.jenncodes.rentalcarspringbootbackend.model.RentalVehicle;
import com.jenncodes.rentalcarspringbootbackend.repository.RentalVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental/vehicles")
public class RentalVehicleController {
    @Autowired
    private RentalVehicleRepository rentalVehicleRepository;

    @GetMapping
    public List<RentalVehicle> getAllRentalVehicles(){
        return rentalVehicleRepository.findAll();
    }

    //create post mapping for rental vehicle
    @PostMapping
    public RentalVehicle createRentalVehicle(@RequestBody RentalVehicle rentalVehicle){
        return rentalVehicleRepository.save(rentalVehicle);
    }

    @GetMapping("{id}")
    public ResponseEntity<RentalVehicle> getRentalVehicleById(@PathVariable long id){
        RentalVehicle rentalVehicle = rentalVehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle with this id does not exist:" + id));
        return ResponseEntity.ok(rentalVehicle);
    }


}
