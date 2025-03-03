package com.esprit.firstspringbootproject.repository;

import com.esprit.firstspringbootproject.entities.Universite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUniversiteRepository extends CrudRepository<Universite,Long> {
}
