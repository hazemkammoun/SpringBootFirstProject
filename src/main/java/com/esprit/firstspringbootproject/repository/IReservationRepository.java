package com.esprit.firstspringbootproject.repository;

import com.esprit.firstspringbootproject.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, String> {

    List<Reservation> findByAnneeUniversitaireAndChambre_Bloc_Universite_NomUniversite(Date anneeUniversitaire, String nomUniversite);
}
