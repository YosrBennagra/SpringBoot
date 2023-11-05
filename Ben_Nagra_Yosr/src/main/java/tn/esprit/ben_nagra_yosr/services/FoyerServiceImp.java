package tn.esprit.ben_nagra_yosr.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ben_nagra_yosr.entites.Foyer;
import tn.esprit.ben_nagra_yosr.repositories.IFoyerRepo;
import tn.esprit.ben_nagra_yosr.repositories.IUniversiteRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoyerServiceImp implements IFoyerService{
    final IFoyerRepo foyerRepository;
    // injection par constructeur
    final IUniversiteRepo universiteRepository;

    @Override
    public Foyer Ajouterfoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer Updatefoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public void SupprimeFoyer(long idfoyer) {
        foyerRepository.deleteById(idfoyer);

    }

    @Override
    public Foyer Getfoyer(long idfoyer) {
        return foyerRepository.findById(idfoyer).orElse(null);

    }

    @Override
    public List <Foyer> GetAllfoyer() {
        return foyerRepository.findAll();
    }
}
