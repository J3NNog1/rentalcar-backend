package com.jenncodes.rentalcarspringbootbackend.repository;

import com.jenncodes.rentalcarspringbootbackend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}