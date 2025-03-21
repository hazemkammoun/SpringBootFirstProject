package com.esprit.firstspringbootproject.repository;

import com.esprit.firstspringbootproject.entities.Chambre;
import com.esprit.firstspringbootproject.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, String> {

    @Query("SELECT r FROM Reservation r " +
            "JOIN r.chambre c JOIN c.bloc b JOIN b.foyer f JOIN f.universite u " +
            "WHERE u.nomUniversite = :nomUniversite " +
            "AND FUNCTION('YEAR', r.anneeUniversitaire) = FUNCTION('YEAR', :anneeUniversitaire)")
    List<Reservation> findReservationsByAnneeUniversitaireAndNomUniversite(Date anneeUniversitaire, String nomUniversite);

    long countByChambreAndEstValide(Chambre chambre, boolean b);
}
