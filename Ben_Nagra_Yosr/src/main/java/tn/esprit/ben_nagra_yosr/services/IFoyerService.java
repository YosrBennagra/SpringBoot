package tn.esprit.ben_nagra_yosr.services;

import tn.esprit.ben_nagra_yosr.entites.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer Ajouterfoyer(Foyer f);
    Foyer Updatefoyer(Foyer f);
    void SupprimeFoyer(long idfoyer);
    Foyer Getfoyer(long idfoyer);

    List <Foyer> GetAllfoyer();

}
