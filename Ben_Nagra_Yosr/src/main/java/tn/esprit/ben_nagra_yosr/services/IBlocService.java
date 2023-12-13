package tn.esprit.ben_nagra_yosr.services;

import tn.esprit.ben_nagra_yosr.entites.Bloc;

import java.util.List;

public interface IBlocService {
    public Bloc ajouterBloc(Bloc b);
    public Bloc updateBloc(Bloc b);
    void supprimerBloc(long idBloc);
    public Bloc getBloc(long idBloc);
    List<Bloc> getAllBlocs();


    Bloc getBlocById (long idBloc);

    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc);
    public Bloc affecterBlocAFoyer( String nomBloc, String nomFoyer);
    public Bloc getBlocByNom(String nomBloc);

}
