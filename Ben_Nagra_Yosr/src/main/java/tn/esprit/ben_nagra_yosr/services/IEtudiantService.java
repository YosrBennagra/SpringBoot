package tn.esprit.ben_nagra_yosr.services;

import tn.esprit.ben_nagra_yosr.entites.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant ajouterEtudiant(Etudiant et);
    Etudiant updateEtudiant(Etudiant et);
    void supprimerEtudiant(long idEtudiant);
    Etudiant getEtudiant(long idEtudiant);
    List<Etudiant> getAllEtudiants();

}
