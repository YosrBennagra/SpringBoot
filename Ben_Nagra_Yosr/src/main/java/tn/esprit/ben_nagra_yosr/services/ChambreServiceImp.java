package tn.esprit.ben_nagra_yosr.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ben_nagra_yosr.entites.Bloc;
import tn.esprit.ben_nagra_yosr.entites.Chambre;
import tn.esprit.ben_nagra_yosr.entites.Foyer;
import tn.esprit.ben_nagra_yosr.entites.TypeChambre;
import tn.esprit.ben_nagra_yosr.repositories.IChambreRepo;
import tn.esprit.ben_nagra_yosr.repositories.IFoyerRepo;
import tn.esprit.ben_nagra_yosr.repositories.IblocRepo;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImp implements IChambreService {
    IChambreRepo chambreRepo;
    IblocRepo blocRepository;
    IFoyerRepo foyerRepository;

    @Override
    public Chambre ajouterChambre(Chambre ch) {
        return chambreRepo.save(ch);
    }

    @Override
    public Chambre updateChambre(Chambre ch) {
        return chambreRepo.save(ch);
    }

    @Override
    public void supprimerChambre(long idChambre) {
        chambreRepo.deleteById(idChambre);
    }

    @Override
    public Chambre getChambre(long idChambre) {
        return chambreRepo.findById(idChambre).orElse(null);
    }

    @Override
    public List<Chambre> getAllChambres() {
        return (List<Chambre>) chambreRepo.findAll();
    }

    @Override
    public List<Chambre> getChambresParNomBloc(String nomBloc) {
        Bloc b = blocRepository.findByNomBloc(nomBloc);
        List<Chambre> chambres = new ArrayList <> ();
        for(Chambre c : b.getChambres()){
            chambres.add(c);

        }
        return chambres;
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {
        Bloc b = blocRepository.findById(idBloc).orElse(null);
        int nbrchambre = 0;
        for(Chambre c : b.getChambres()){
            if (c.getTypeC()==type) {
                nbrchambre++;
            }
        }
        return  nbrchambre;
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(String nomFoyer, TypeChambre type) {

        Foyer foyer = foyerRepository.findByNomFoyer(nomFoyer);
        List<Chambre> chambre = new ArrayList<>();
        List<Bloc> blocs = blocRepository.findByFoyer(foyer);
        for (Bloc b : blocs) {

            chambre.addAll(chambreRepo.findByTypeCAndBlocchambreAndReservations(type,b,null));
        }




        return chambre;
    }
    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC)
    {
        Bloc b = blocRepository.findById(idBloc).orElse(null);

        return  chambreRepo.findByBlocchambreAndTypeC(b,typeC);
    }
}
