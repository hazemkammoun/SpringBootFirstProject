package com.esprit.firstspringbootproject.services;

import com.esprit.firstspringbootproject.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversities();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (long idUniversite);
    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
   public Universite desaffecterFoyerAUniversite(long idUniversite);
}
