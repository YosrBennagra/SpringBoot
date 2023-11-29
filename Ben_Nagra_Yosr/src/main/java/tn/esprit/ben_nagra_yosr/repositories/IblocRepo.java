package tn.esprit.ben_nagra_yosr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ben_nagra_yosr.entites.Bloc;
import tn.esprit.ben_nagra_yosr.entites.Foyer;

import java.util.List;

public interface IblocRepo extends JpaRepository <Bloc,Long> {
    Bloc findByNomBloc(String nombloc);
    List <Bloc> findByFoyer(Foyer foyer);
}
