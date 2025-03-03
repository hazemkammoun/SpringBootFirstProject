package com.esprit.firstspringbootproject.services;

import com.esprit.firstspringbootproject.entities.Etudiant;
import com.esprit.firstspringbootproject.repository.IEtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
      //  return etudiantRepository.saveAll(etudiants);
        List<Etudiant> savedEtudiants = new ArrayList<>();
        for (Etudiant etudiant : etudiants) {
            savedEtudiants.add(etudiantRepository.save(etudiant));
        }
        return savedEtudiants;
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
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
