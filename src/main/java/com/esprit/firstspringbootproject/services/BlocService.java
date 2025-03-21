package com.esprit.firstspringbootproject.services;

import com.esprit.firstspringbootproject.entities.Bloc;
import com.esprit.firstspringbootproject.entities.Chambre;
import com.esprit.firstspringbootproject.repository.IBlocRepository;
import com.esprit.firstspringbootproject.repository.IChambreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService{
    IBlocRepository blocRepository;
    IChambreRepository chambreRepository;

    @Override
    public List<Bloc> retrieveBlocs() {
        return (List<Bloc>) blocRepository.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
        public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
            Bloc bloc = blocRepository.findById(idBloc).orElseThrow(() -> new RuntimeException("Bloc non trouvé !"));
            List<Chambre> chambres = chambreRepository.findAllById(numChambre);
            if (chambres.isEmpty()) {
                throw new RuntimeException("Aucune chambre trouvée avec les IDs fournis !");
            }
            for (Chambre chambre : chambres) {
                chambre.setBloc(bloc);
            }
            chambreRepository.saveAll(chambres);
            return bloc;
        }
    }


