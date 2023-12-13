package tn.esprit.ben_nagra_yosr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.ben_nagra_yosr.entites.Etudiant;
import tn.esprit.ben_nagra_yosr.entites.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationRepo extends CrudRepository < Reservation,Long> {
    List <Reservation> findByAnneeUniversitaireBetween(Date debutAnnee, Date finAnnee);
    List<Reservation> findByEtudiants(Etudiant etudiant);




    @Query("SELECT r FROM Reservation r , Chambre c, Etudiant e  WHERE c.idChambre = :idChambre AND :etudiant MEMBER OF r.etudiants AND r MEMBER OF c.reservations")
    Reservation findReservationByCinAndChambreId(@Param ("etudiant") Etudiant etudiant, @Param("idChambre") Long idChambre);









}
