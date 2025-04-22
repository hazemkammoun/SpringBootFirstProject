package com.esprit.firstspringbootproject.services;

import com.esprit.firstspringbootproject.entities.Etudiant;
import com.esprit.firstspringbootproject.repository.IEtudiantRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService{
    IEtudiantRepository etudiantRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return (List<Etudiant>) etudiantRepository.findAll();
    }


    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return (List<Etudiant>) etudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        // Check if the Etudiant exists in the database
        Optional<Etudiant> existingEtudiantOptional = etudiantRepository.findById(e.getIdEtudiant());

        if (existingEtudiantOptional.isPresent()) {
            Etudiant existingEtudiant = existingEtudiantOptional.get();

            // Update the fields of the existing Etudiant with the new values
            existingEtudiant.setNomEt(e.getNomEt());
            existingEtudiant.setPrenomEt(e.getPrenomEt());
            existingEtudiant.setCin(e.getCin());
            existingEtudiant.setEcole(e.getEcole());
            existingEtudiant.setDateNaissance(e.getDateNaissance());
            existingEtudiant.setReservations(e.getReservations());

            // Save the updated Etudiant back to the database
            return etudiantRepository.save(existingEtudiant);
        } else {
            // Handle the case where the Etudiant does not exist
            throw new EntityNotFoundException("Etudiant with ID " + e.getIdEtudiant() + " not found.");
        }
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
    etudiantRepository.deleteById(idEtudiant);
    }
}
