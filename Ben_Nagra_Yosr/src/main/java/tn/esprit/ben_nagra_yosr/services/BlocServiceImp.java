package tn.esprit.ben_nagra_yosr.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ben_nagra_yosr.entites.Bloc;
import tn.esprit.ben_nagra_yosr.repositories.IFoyerRepo;
import tn.esprit.ben_nagra_yosr.repositories.IblocRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImp implements IBlocService {
    IFoyerRepo foyerRepository;
    IblocRepo blocRepository;
    @Override
    public Bloc AjouterBloc(Bloc b) {
        return blocRepository.save(b) ;
    }

    @Override
    public Bloc UpdateBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public void SupprimerBloc(long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public Bloc GetBloc(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public List <Bloc> GetAllBlocs() {
        return blocRepository.findAll();
    }
}
