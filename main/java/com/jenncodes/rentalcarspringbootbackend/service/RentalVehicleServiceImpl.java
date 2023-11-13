package com.jenncodes.rentalcarspringbootbackend.service;

import com.jenncodes.rentalcarspringbootbackend.exception.ResourceNotFoundException;
import com.jenncodes.rentalcarspringbootbackend.model.RentalVehicle;
import com.jenncodes.rentalcarspringbootbackend.repository.RentalVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalVehicleServiceImpl implements RentalVehicleService {

    private final RentalVehicleRepository rentalVehicleRepository;

    @Autowired
    public RentalVehicleServiceImpl(RentalVehicleRepository rentalVehicleRepository) {
        this.rentalVehicleRepository = rentalVehicleRepository;
    }

    @Override
    public List<RentalVehicle> getAllRentalVehicles() {
        return rentalVehicleRepository.findAll();
    }

    @Override
    public RentalVehicle createRentalVehicle(RentalVehicle rentalVehicle) {
        return rentalVehicleRepository.save(rentalVehicle);
    }

    @Override
    public Optional<RentalVehicle> getRentalVehicleById(long id) {
        return rentalVehicleRepository.findById(id);
    }

    @Override
    public RentalVehicle updateRentalVehicle(long id, RentalVehicle rentalVehicleDetails) {
        RentalVehicle updateRentalVehicle = rentalVehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle with id does not exist: " + id));

        updateRentalVehicle.setVehicleType(rentalVehicleDetails.getVehicleType());
        updateRentalVehicle.setYear(rentalVehicleDetails.getYear());
        updateRentalVehicle.setMake(rentalVehicleDetails.getMake());
        updateRentalVehicle.setModel(rentalVehicleDetails.getModel());
        updateRentalVehicle.setMileage(rentalVehicleDetails.getMileage());
        updateRentalVehicle.setColor(rentalVehicleDetails.getColor());

        return rentalVehicleRepository.save(updateRentalVehicle);
    }

    @Override
    public void deleteRentalVehicle(long id) {
        RentalVehicle rentalVehicle = rentalVehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rental vehicle with id does not exist: " + id));

        rentalVehicleRepository.delete(rentalVehicle);
    }
}
