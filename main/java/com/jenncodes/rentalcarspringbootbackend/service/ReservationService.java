package com.jenncodes.rentalcarspringbootbackend.service;

import com.jenncodes.rentalcarspringbootbackend.model.Reservation;

import java.util.Optional;

public interface ReservationService {

    Optional<Reservation> getReservationById(long reservationId);

    Reservation createReservation(Reservation reservation);

    Reservation updateReservation(long reservationId, Reservation updatedReservation);

    void deleteReservation(long reservationId);
}
