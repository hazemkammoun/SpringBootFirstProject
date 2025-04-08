package com.esprit.firstspringbootproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation implements Serializable {
    @Id
    private String idReservation;

    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;

    private boolean estValide;

    @ManyToMany(mappedBy = "reservations")
    private List<Etudiant> etudiants = new ArrayList<>();

    @ManyToOne
    private Chambre chambre;

    public void addEtudiant(Etudiant etudiant) {
        this.etudiants.add(etudiant);
      etudiant.getReservations().add(this);
    }
}
