package com.esprit.firstspringbootproject.repository;

import com.esprit.firstspringbootproject.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUniversiteRepository extends JpaRepository<Universite,Long> {
    public Universite findByNomUniversite (String nomUniversite);
}
