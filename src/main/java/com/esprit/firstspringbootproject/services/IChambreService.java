package com.esprit.firstspringbootproject.services;

import com.esprit.firstspringbootproject.entities.Chambre;
import com.esprit.firstspringbootproject.entities.Reservation;
import com.esprit.firstspringbootproject.entities.TypeChambre;

import java.util.Date;
import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre c);
    Chambre updateChambre(Chambre c);
    Chambre retrieveChambre(long idChambre);
    List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type);
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite);
    List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre type);
    List<Chambre> getChambresParBlocEtTypeKeywords(long idBloc, TypeChambre type);
}
