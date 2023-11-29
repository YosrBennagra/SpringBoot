package tn.esprit.ben_nagra_yosr.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ben_nagra_yosr.entites.Bloc;
import tn.esprit.ben_nagra_yosr.entites.Chambre;
import tn.esprit.ben_nagra_yosr.entites.Foyer;
import tn.esprit.ben_nagra_yosr.repositories.IChambreRepo;
import tn.esprit.ben_nagra_yosr.repositories.IFoyerRepo;
import tn.esprit.ben_nagra_yosr.repositories.IblocRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImp implements IBlocService {
    IblocRepo blocRepo ;
    IFoyerRepo foyerRepository;
    IChambreRepo chambreRepository;

    @Override
    public Bloc ajouterBloc(Bloc b) {
        return blocRepo.save(b);
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return blocRepo.save(b);
    }

    @Override
    public void supprimerBloc(long idBloc) {
        blocRepo.deleteById(idBloc);
    }

    @Override
    public Bloc getBloc(long idBloc) {
        return blocRepo.findById(idBloc).orElse(null);
    }

    @Override
    public List<Bloc> getAllBlocs() {
        return (List<Bloc>) blocRepo.findAll();
    }

    @Transactional
    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
        Bloc b = blocRepo.findByNomBloc(nomBloc);
        for(Long id : numChambre){
            Chambre c = chambreRepository.findById(id).orElse(null);
            c.setBlocchambre(b);
        }
        return b;
    }
    @Transactional
    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) {
        Bloc b = blocRepo.findByNomBloc(nomBloc);
        Foyer f = foyerRepository.findByNomFoyer(nomFoyer);
        b.setFoyer(f);
        return b;
    }
}
