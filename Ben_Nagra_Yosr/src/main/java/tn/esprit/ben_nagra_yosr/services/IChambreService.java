package tn.esprit.ben_nagra_yosr.services;

import tn.esprit.ben_nagra_yosr.entites.Chambre;
import tn.esprit.ben_nagra_yosr.entites.TypeChambre;

import java.util.List;

public interface IChambreService {
    Chambre ajouterChambre(Chambre ch);
    Chambre updateChambre(Chambre ch);
    void supprimerChambre(long idChambre);
    Chambre getChambre(long idChambre);
    List<Chambre> getAllChambres();

    List<Chambre> getChambresParNomBloc( String nomBloc) ;
    long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) ;
    List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre( String nomFoyer,TypeChambre type) ;
    List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);

}
