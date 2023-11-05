package tn.esprit.ben_nagra_yosr.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ben_nagra_yosr.entites.Reservation;
import tn.esprit.ben_nagra_yosr.repositories.IReservationRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImp implements IReservationService{
    IReservationRepo resrvationRepository;
    @Override
    public Reservation AjouterReservation(Reservation r) {
        return resrvationRepository.save(r);
    }

    @Override
    public Reservation UpdateReservation(Reservation r) {
        return resrvationRepository.save(r);
    }

    @Override
    public void SupprimerReservation(long idReservation) {
        resrvationRepository.deleteById( idReservation);
    }

    @Override
    public Reservation GetReservation(long idReservation) {
        return resrvationRepository.findById( idReservation).orElse(null);
    }

    @Override
    public List <Reservation> GetAllReservation() {
        return resrvationRepository.findAll();
    }
}
