package com.jenncodes.reservationvehicle.controller;

import com.jenncodes.rentalcarspringbootbackend.exception.ResourceNotFoundException;
import com.jenncodes.rentalcarspringbootbackend.model.Reservation;
import com.jenncodes.rentalcarspringbootbackend.repository.ReservationVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/reservation/vehicles")
public class ReservationVehicleController {
    @Autowired
    private ReservationVehicleRepository reservationvehiclerepository;

    @GetMapping
    public List<Reservation> getReservations() {
        return reservationvehiclerepository.findAll();
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationvehiclerepository.save(reservation)
    }

    @GetMapping("{id}")
    public ResponseEntity<Reservation> getReservationsById(@PathVariable long id) {
        Reservation reservation = reservationvehiclerepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation with this id does not exist:" + id));
        return ResponseEntity.ok(reservation);
    }

    @PutMapping("{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable long id, @RequestBody Reservation reservationVehicleDetails) {
        Reservation updateReservationVehicle = reservationvehiclerepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The reservation with this id does not existL:" + id));
        updateReservationVehicle.setcustomer(reservationVehicleDetails.getcustomer());
        updateReservationVehicle.setvehicle(reservationVehicleDetails.getvehicle());
        updateReservationVehicle.setreservationDate(reservationVehicleDetails.getreservationDate());
        updateReservationVehicle.setstartDate(reservationVehicleDetails.getstartDate());
        updateReservationVehicle.setendDate(reservationVehicleDetails.getendDate());

        reservationvehiclerepository.save(updateReservationVehicle);
        return ResponseEntity.ok(updateReservationVehicle);
    }
}