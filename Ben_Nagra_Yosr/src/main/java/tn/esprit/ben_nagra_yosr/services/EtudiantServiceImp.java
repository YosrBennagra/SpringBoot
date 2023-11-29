package tn.esprit.ben_nagra_yosr.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ben_nagra_yosr.entites.Etudiant;
import tn.esprit.ben_nagra_yosr.repositories.IEtudiantRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImp implements IEtudiantService{
    IEtudiantRepo etudiantRepo;

    @Override
    public Etudiant ajouterEtudiant(Etudiant et) {
        return etudiantRepo.save(et);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant et) {
        return etudiantRepo.save(et);
    }

    @Override
    public void supprimerEtudiant(long idEtudiant) {
        etudiantRepo.deleteById(idEtudiant);
    }

    @Override
    public Etudiant getEtudiant(long idEtudiant) {
        return etudiantRepo.findById(idEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return (List<Etudiant>) etudiantRepo.findAll();
    }
}
