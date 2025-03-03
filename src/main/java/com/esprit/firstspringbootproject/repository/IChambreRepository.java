package com.esprit.firstspringbootproject.repository;

import com.esprit.firstspringbootproject.entities.Chambre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChambreRepository extends CrudRepository<Chambre,Long> {
}
