package tn.esprit.ben_nagra_yosr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.ben_nagra_yosr.entites.Bloc;
import tn.esprit.ben_nagra_yosr.entites.Chambre;
import tn.esprit.ben_nagra_yosr.entites.Reservation;
import tn.esprit.ben_nagra_yosr.entites.TypeChambre;

import java.util.List;

public interface IChambreRepo extends CrudRepository < Chambre,Long> {

    List <Chambre> findByTypeCAndBlocchambreAndReservations(TypeChambre type, Bloc bloc, Reservation reservation);
    Chambre findChambreByReservations(Reservation reservation);
    List<Chambre> findByBlocchambreAndTypeC(Bloc bloc, TypeChambre type);
    @Query ("SELECT c FROM Chambre c WHERE c.blocchambre = :bloc AND c.typeC = :type")
    List<Chambre> findByBlocAndTypeChambre(@Param ("bloc") Bloc bloc, @Param("type") TypeChambre type);

    @Query("select c from Chambre c where c.blocchambre IS NULL")
    List<Chambre>findChambreNonAffecter();
}
