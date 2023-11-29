package tn.esprit.ben_nagra_yosr.services;

import tn.esprit.ben_nagra_yosr.entites.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc ajouterBloc(Bloc b);
    Bloc updateBloc(Bloc b);
    void supprimerBloc(long idBloc);
    Bloc getBloc(long idBloc);
    List<Bloc> getAllBlocs();

    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc);
    public Bloc affecterBlocAFoyer( String nomBloc, String nomFoyer);
}
