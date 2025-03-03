package com.esprit.firstspringbootproject.repository;

import com.esprit.firstspringbootproject.entities.Foyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoyerRepository extends CrudRepository<Foyer,Long> {
}
