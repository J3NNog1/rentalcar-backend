package com.jenncodes.rentalcarspringbootbackend.repository;

import com.jenncodes.rentalcarspringbootbackend.model.RentalVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RentalVehicleRepository extends JpaRepository<RentalVehicle, Long> {
    //all crud methods called

}
