package com.esprit.firstspringbootproject.services;

import com.esprit.firstspringbootproject.entities.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservation();
    Reservation updateReservation (Reservation res);
    Reservation retrieveReservation (String idReservation);
}
