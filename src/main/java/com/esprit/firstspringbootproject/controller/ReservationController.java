package com.esprit.firstspringbootproject.controller;

import com.esprit.firstspringbootproject.entities.Foyer;
import com.esprit.firstspringbootproject.entities.Reservation;
import com.esprit.firstspringbootproject.services.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reservation")
@AllArgsConstructor
public class ReservationController {
    IReservationService reservationService;
    @GetMapping("/getAll")
    public List<Reservation> getAll(){
        return reservationService.retrieveAllReservation();
    }
    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable String id, @RequestBody Reservation r) {
        return reservationService.updateReservation(r);
    }

    @GetMapping("/{id}")
    public Reservation retrieveReservation(@PathVariable String id) {
        return reservationService.retrieveReservation(id);
    }
    @GetMapping("/par-annee-universitaire-et-universite")
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(
            @RequestParam Date anneeUniversitaire,
            @RequestParam String nomUniversite) {
        return reservationService.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversitaire, nomUniversite);
    }

    @PostMapping("/ajouter/{idBloc}/{cinEtudiant}")
    public ResponseEntity<Reservation> ajouterReservation(
            @PathVariable long idBloc, @PathVariable long cinEtudiant) {
        Reservation reservation = reservationService.ajouterReservation(idBloc, cinEtudiant);
        return ResponseEntity.ok(reservation);
    }
}
