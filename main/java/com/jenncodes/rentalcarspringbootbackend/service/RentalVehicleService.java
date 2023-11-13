package com.jenncodes.rentalcarspringbootbackend.service;

import com.jenncodes.rentalcarspringbootbackend.model.RentalVehicle;

import java.util.List;
import java.util.Optional;

public interface RentalVehicleService {
    List<RentalVehicle> getAllRentalVehicles();
    Optional<RentalVehicle> getRentalVehicleById(long rentalVehicleId);
    RentalVehicle createRentalVehicle(RentalVehicle rentalVehicle);
    RentalVehicle updateRentalVehicle(long rentalVehicleId, RentalVehicle updatedRentalVehicle);
    void deleteRentalVehicle(long rentalVehicleId);
}
