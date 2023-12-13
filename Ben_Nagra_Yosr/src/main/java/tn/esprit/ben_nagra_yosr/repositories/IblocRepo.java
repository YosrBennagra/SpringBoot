package tn.esprit.ben_nagra_yosr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.ben_nagra_yosr.entites.Bloc;
import tn.esprit.ben_nagra_yosr.entites.Foyer;

import java.util.List;

public interface IblocRepo extends JpaRepository <Bloc,Long> {
    Bloc findByNomBloc(String nombloc);
    List <Bloc> findByFoyer(Foyer foyer);

    @Query ("SELECT b FROM Bloc b LEFT JOIN b.foyer")
    List<Bloc> findAllWithFoyer();

    Bloc getBlocByBlocId(long idBloc);

    Bloc getBlocByNomBloc(String nomBloc);
}
