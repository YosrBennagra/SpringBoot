package tn.esprit.ben_nagra_yosr.services;

import tn.esprit.ben_nagra_yosr.entites.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite ajouterUniversite(Universite u);
    Universite updateUniversite(Universite u);
    void supprimerUniversite(long idUniversite);
    Universite getUniversite(long idUniversite);
    List<Universite> getAllUniversite();

    Universite findbyNomuniv(String nom);
    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);

    Universite desaffecterFoyerAUniversite (long idFoyer, long idUniversite) ;
}
