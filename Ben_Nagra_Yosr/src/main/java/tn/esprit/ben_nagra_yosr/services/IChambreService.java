package tn.esprit.ben_nagra_yosr.services;

import tn.esprit.ben_nagra_yosr.entites.Chambre;

import java.util.List;

public interface IChambreService {
    Chambre AjoutChambre(Chambre c);
    Chambre UpdateChambre(Chambre c);
    void SupprimerChambre(long idChambre);
    Chambre GetChambre(long idChambre);
    List <Chambre> GetAllChambres();
}
