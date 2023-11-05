package tn.esprit.ben_nagra_yosr.services;

import tn.esprit.ben_nagra_yosr.entites.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite AjouterUniversite(Universite u);
    Universite UpdateUniversite(Universite u);
    void SupprimerUniversite(long idUniversite);
    Universite GetUniversite(long idUniversite);
    List <Universite> GetAllUuniversite();
}
