package tn.esprit.ben_nagra_yosr.services;

import tn.esprit.ben_nagra_yosr.entites.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer ajouterFoyer(Foyer foyer);
    Foyer updateFoyer(Foyer foyer);
    void supprimerFoyer(Long idFoyer);
    Foyer getFoyer(Long idFoyer);
    List<Foyer> getAllFoyer();

    Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;

}
