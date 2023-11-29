package tn.esprit.ben_nagra_yosr.services;

import tn.esprit.ben_nagra_yosr.entites.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {
    Reservation ajouterReservation(Reservation r);
    Reservation updateReservation(Reservation r);
    void supprimerReservation(Long idReservation);
    Reservation getReservation(Long idReservation);
    List<Reservation> getAllReservations();
    Reservation ajouterReservationEtAssignerAChambreEtAEtudiant (Reservation res, Long
            numChambre, Long cin) ;
    long getReservationParAnneeUniversitaire(Date debutAnnee, Date finAnnee ) ;

    Reservation ajouterReservation (long idChambre, long cinEtudiant) ;
    Reservation annulerReservation(long cinEtudiant);
}
