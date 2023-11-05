package tn.esprit.ben_nagra_yosr.services;

import tn.esprit.ben_nagra_yosr.entites.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc AjouterBloc(Bloc b);
    Bloc UpdateBloc(Bloc b);

    void SupprimerBloc (long idBloc) ;

    Bloc GetBloc(long idBloc);
    List <Bloc> GetAllBlocs();
}
