package com.jenncodes.rentalcarspringbootbackend.repository;

import com.jenncodes.rentalcarspringbootbackend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ReservationVehicleRepository extends JpaRepository<Reservation, Long> {

}