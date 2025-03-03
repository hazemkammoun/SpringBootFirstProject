package com.esprit.firstspringbootproject.repository;

import com.esprit.firstspringbootproject.entities.Bloc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlocRepository extends CrudRepository<Bloc,Long> {
}
