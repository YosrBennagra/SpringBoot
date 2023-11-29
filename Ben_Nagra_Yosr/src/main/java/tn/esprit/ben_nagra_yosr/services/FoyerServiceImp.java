package tn.esprit.ben_nagra_yosr.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ben_nagra_yosr.entites.Bloc;
import tn.esprit.ben_nagra_yosr.entites.Foyer;
import tn.esprit.ben_nagra_yosr.entites.Universite;
import tn.esprit.ben_nagra_yosr.repositories.IFoyerRepo;
import tn.esprit.ben_nagra_yosr.repositories.IUniversiteRepo;
import tn.esprit.ben_nagra_yosr.repositories.IblocRepo;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FoyerServiceImp implements IFoyerService{
    // @Autowired
    final  IFoyerRepo foyerRepository;
    final IblocRepo blocRepository;
    final IBlocService blocService;
    final IUniversiteRepo universiteRepository;


    //public FoyerServicesImpl(IFoyerRepository foyerRepository) {
    //   this.foyerRepository = foyerRepository;
    //}

    @Override
    public Foyer ajouterFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void supprimerFoyer(Long idFoyer)
    {
        foyerRepository.deleteById(idFoyer);

    }

    @Override
    public Foyer getFoyer(Long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public List<Foyer> getAllFoyer()
    {

        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    @Transactional
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        this.ajouterFoyer(foyer);

        // Ensure blocs set is not null before iterating
        Set <Bloc> blocs = foyer.getBlocs();
        if (blocs != null) {
            // Ajouter bloc et affecter au foyer
            for (Bloc b : blocs) {
                this.blocService.ajouterBloc(b);
                b.setFoyer(foyer);
            }
        }

        Universite u = universiteRepository.findById(idUniversite).orElse(null);
        if (u != null) {
            u.setFoyer(foyer);
        }

        return foyer;
    }

}
