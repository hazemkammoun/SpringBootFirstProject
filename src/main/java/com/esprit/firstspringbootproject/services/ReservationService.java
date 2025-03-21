package com.esprit.firstspringbootproject.services;

import com.esprit.firstspringbootproject.entities.Chambre;
import com.esprit.firstspringbootproject.entities.Etudiant;
import com.esprit.firstspringbootproject.entities.Reservation;
import com.esprit.firstspringbootproject.repository.IBlocRepository;
import com.esprit.firstspringbootproject.repository.IChambreRepository;
import com.esprit.firstspringbootproject.repository.IEtudiantRepository;
import com.esprit.firstspringbootproject.repository.IReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService{
    IReservationRepository reservationRepository;
    IEtudiantRepository etudiantRepository;
    IBlocRepository blocRepository;
    IChambreRepository chambreRepository;
    @Override
    public List<Reservation> retrieveAllReservation() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }
    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite) {
        return reservationRepository.findReservationsByAnneeUniversitaireAndNomUniversite(anneeUniversitaire, nomUniversite);

    }

    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        Chambre chambre = chambreRepository.findById(idBloc)
                .orElseThrow(() -> new IllegalArgumentException("Invalid room ID"));

        Etudiant etudiant = etudiantRepository.findById(cinEtudiant)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));

        int maxCapacity = 0;
        switch (chambre.getTypeC()) {
            case SIMPLE:
                maxCapacity = 1;
                break;
            case DOUBLE:
                maxCapacity = 2;
                break;
            case TRIPLE:
                maxCapacity = 3;
                break;
        }

        long currentReservations = reservationRepository.countByChambreAndEstValide(chambre, true);

        if (currentReservations >= maxCapacity) {
            throw new IllegalStateException("Room is already at full capacity");
        }

        String numReservation = chambre.getNumeroChambre() + "-" + chambre.getBloc().getNomBloc() + "-" + LocalDate.now().getYear();

        Date anneeUniversitaireDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

        Reservation reservation = new Reservation();
        reservation.setIdReservation(numReservation);
        reservation.setAnneeUniversitaire(anneeUniversitaireDate);
        reservation.setEstvalide(true);
        reservation.setChambre(chambre);
        reservation.addEtudiant(etudiant);
        return reservationRepository.save(reservation);
    }

}
