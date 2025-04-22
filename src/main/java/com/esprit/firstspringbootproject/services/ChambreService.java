package com.esprit.firstspringbootproject.services;

import com.esprit.firstspringbootproject.entities.Chambre;
import com.esprit.firstspringbootproject.entities.Reservation;
import com.esprit.firstspringbootproject.entities.TypeChambre;
import com.esprit.firstspringbootproject.repository.IChambreRepository;
import com.esprit.firstspringbootproject.repository.IReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChambreService implements IChambreService {
    IChambreRepository chambreRepository;
    IReservationRepository reservationRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        // Check if the Chambre exists in the database
        Optional<Chambre> existingChambreOptional = chambreRepository.findById(c.getIdChambre());

        if (existingChambreOptional.isPresent()) {
            Chambre existingChambre = existingChambreOptional.get();

            // Update the fields of the existing Chambre with the new values
            existingChambre.setNumeroChambre(c.getNumeroChambre());
            existingChambre.setTypeC(c.getTypeC());
            existingChambre.setBloc(c.getBloc());

            // Save the updated Chambre back to the database
            return chambreRepository.save(existingChambre);
        } else {
            // Handle the case where the Chambre does not exist
            throw new EntityNotFoundException("Chambre with ID " + c.getIdChambre() + " not found.");
        }
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        return chambreRepository.findChambresNonReservees(nomUniversite,type);
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite) {
        return reservationRepository.findReservationsByAnneeUniversitaireAndNomUniversite(anneeUniversitaire, nomUniversite);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepository.findByBlocIdBlocAndTypeC(idBloc, typeC);
    }
    @Override
    public List<Chambre> getChambresParBlocEtTypeKeywords(long idBloc, TypeChambre typeC) {
        return chambreRepository.findByBlocIdBlocAndTypeC(idBloc, typeC);
    }
}
