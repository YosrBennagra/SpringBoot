package tn.esprit.ben_nagra_yosr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ben_nagra_yosr.entites.Foyer;

public interface IFoyerRepo extends JpaRepository < Foyer,Long> {
    Foyer findByNomFoyer(String nomFoyer);
}
