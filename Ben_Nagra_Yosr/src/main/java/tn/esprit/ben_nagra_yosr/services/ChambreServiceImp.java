package tn.esprit.ben_nagra_yosr.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ben_nagra_yosr.entites.Chambre;
import tn.esprit.ben_nagra_yosr.repositories.IChambreRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImp implements IChambreService {
    IChambreRepo chambreRepository;

    @Override
    public Chambre AjoutChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre UpdateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public void SupprimerChambre(long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public Chambre GetChambre(long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public List <Chambre> GetAllChambres() {
        return chambreRepository.findAll();
    }
}
