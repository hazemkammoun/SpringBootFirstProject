package com.esprit.firstspringbootproject.repository;

import com.esprit.firstspringbootproject.entities.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservationRepository extends CrudRepository<Reservation,String> {
}
