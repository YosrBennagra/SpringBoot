package tn.esprit.ben_nagra_yosr.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ben_nagra_yosr.entites.Foyer;
import tn.esprit.ben_nagra_yosr.entites.Universite;
import tn.esprit.ben_nagra_yosr.repositories.IFoyerRepo;
import tn.esprit.ben_nagra_yosr.repositories.IUniversiteRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImp implements IUniversiteService{
    IUniversiteRepo universiteRepo;
    IFoyerRepo foyerRepository;
    @Override
    public Universite ajouterUniversite(Universite u) {
        return universiteRepo.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepo.save(u);
    }

    @Override
    public void supprimerUniversite(long idUniversite) {
        universiteRepo.deleteById(idUniversite);
    }

    @Override
    public Universite getUniversite(long idUniversite) {
        return universiteRepo.findById(idUniversite).orElse(null);
    }

    @Override
    public List<Universite> getAllUniversite() {
        return (List<Universite>) universiteRepo.findAll();
    }

    @Override
    public Universite findbyNomuniv(String nom) {
        return universiteRepo.findByNomUniversite(nom);
    }
    @Override
    @Transactional
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer f = foyerRepository.findById(idFoyer).orElse(null);
        Universite uni = universiteRepo.findByNomUniversite(nomUniversite);
        if (f != null && uni != null) {
            uni.setFoyer(f);
            f.setUniversite(uni);
            return uni;
        }
        return null;
    }

    @Override
    @Transactional
    public Universite desaffecterFoyerAUniversite(long idFoyer, long idUniversite) {
        Foyer f = foyerRepository.findById(idFoyer).orElse(null);
        Universite u = universiteRepo.findById(idUniversite).orElse(null);
        if (f != null && u != null) {
            u.setFoyer(null);
            return u;
        }

        return null;
    }



}
