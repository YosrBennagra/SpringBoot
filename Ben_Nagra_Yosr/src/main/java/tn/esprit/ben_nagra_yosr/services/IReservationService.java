package tn.esprit.ben_nagra_yosr.services;

import tn.esprit.ben_nagra_yosr.entites.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation AjouterReservation(Reservation r);
    Reservation UpdateReservation(Reservation r);
    void SupprimerReservation(long idReservation);
    Reservation GetReservation(long idReservation);
    List <Reservation> GetAllReservation();
}
