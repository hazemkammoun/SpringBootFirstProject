package com.esprit.firstspringbootproject.repository;

import com.esprit.firstspringbootproject.entities.Chambre;
import com.esprit.firstspringbootproject.entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChambreRepository extends JpaRepository<Chambre, Long> {

    @Query("SELECT c FROM Chambre c WHERE c.typeC = :type AND c.bloc.universite.nomUniversite = :nomUniversite AND c.idChambre NOT IN (SELECT r.chambre.idChambre FROM Reservation r WHERE YEAR(r.anneeUniversitaire) = :annee)")
    List<Chambre> findChambresNonReservees(String nomUniversite, TypeChambre type, int annee);

    @Query("SELECT c FROM Chambre c WHERE c.bloc.id = :idBloc AND c.typeC = :type")
    List<Chambre> findChambresParBlocEtTypeJPQL(long idBloc, TypeChambre type);

    List<Chambre> findByBlocIdAndType(long idBloc, TypeChambre type);
}
