package com.jenncodes.rentalcarspringbootbackend.controller;

import com.jenncodes.rentalcarspringbootbackend.exception.ResourceNotFoundException;
import com.jenncodes.rentalcarspringbootbackend.model.Reservation;
import com.jenncodes.rentalcarspringbootbackend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/reservation/vehicles")
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    @PostMapping
    public Reservation createReservation(@Validated @RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @GetMapping("{id}")
    public ResponseEntity<Reservation> getReservationsById(@PathVariable long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation with this id does not exist:" + id));
        return ResponseEntity.ok(reservation);
    }

    @PutMapping("{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable long id, @RequestBody Reservation reservationVehicleDetails) {
        Reservation updateReservationVehicle = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The reservation with this id does not existL:" + id));
        updateReservationVehicle.setCustomer(reservationVehicleDetails.getCustomer());
        updateReservationVehicle.setVehicle(reservationVehicleDetails.getVehicle());
        updateReservationVehicle.setReservationDate(reservationVehicleDetails.getReservationDate());
        updateReservationVehicle.setStartDate(reservationVehicleDetails.getStartDate());
        updateReservationVehicle.setEndDate(reservationVehicleDetails.getEndDate());

        reservationRepository.save(updateReservationVehicle);
        return ResponseEntity.ok(updateReservationVehicle);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteReservation(@PathVariable long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("reservation does not exist with this id:" + id));
        reservationRepository.delete(reservation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}