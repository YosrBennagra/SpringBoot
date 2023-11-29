package tn.esprit.ben_nagra_yosr.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.ben_nagra_yosr.entites.Universite;

public interface IUniversiteRepo extends CrudRepository < Universite,Long> {
    Universite findByNomUniversite(String nom);
}
