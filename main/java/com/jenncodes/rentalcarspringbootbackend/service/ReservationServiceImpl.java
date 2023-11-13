package com.jenncodes.rentalcarspringbootbackend.service;

import com.jenncodes.rentalcarspringbootbackend.exception.ResourceNotFoundException;
import com.jenncodes.rentalcarspringbootbackend.model.Reservation;
import com.jenncodes.rentalcarspringbootbackend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Optional<Reservation> getReservationById(long reservationId) {
        return reservationRepository.findById(reservationId);
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(long reservationId, Reservation updatedReservation) {
        Reservation existingReservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("The reservation with this id does not exist: " + reservationId));

        existingReservation.setCustomer(updatedReservation.getCustomer());
        existingReservation.setVehicle(updatedReservation.getVehicle());
        existingReservation.setReservationDate(updatedReservation.getReservationDate());
        existingReservation.setStartDate(updatedReservation.getStartDate());
        existingReservation.setEndDate(updatedReservation.getEndDate());

        return reservationRepository.save(existingReservation);
    }

    @Override
    public void deleteReservation(long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation does not exist with this id: " + reservationId));

        reservationRepository.delete(reservation);
    }
}
