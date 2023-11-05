package tn.esprit.ben_nagra_yosr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ben_nagra_yosr.entites.Reservation;

public interface IReservationRepo extends JpaRepository < Reservation,Long> {
}
