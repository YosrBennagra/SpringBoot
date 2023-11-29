package tn.esprit.ben_nagra_yosr.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ben_nagra_yosr.entites.Chambre;
import tn.esprit.ben_nagra_yosr.entites.Etudiant;
import tn.esprit.ben_nagra_yosr.entites.Reservation;
import tn.esprit.ben_nagra_yosr.entites.TypeChambre;
import tn.esprit.ben_nagra_yosr.repositories.IChambreRepo;
import tn.esprit.ben_nagra_yosr.repositories.IEtudiantRepo;
import tn.esprit.ben_nagra_yosr.repositories.IReservationRepo;
import tn.esprit.ben_nagra_yosr.repositories.IblocRepo;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImp implements IReservationService{
    IReservationRepo reservationRepo;
    IChambreRepo chambreRepository;
    IEtudiantRepo etudiantRepository;
    IblocRepo iblocRepository;

    @Override
    public Reservation ajouterReservation(Reservation r) {
        return reservationRepo.save(r);
    }

    @Override
    public Reservation updateReservation(Reservation r) {
        return reservationRepo.save(r);
    }

    @Override
    public void supprimerReservation(Long idReservation) {
        reservationRepo.deleteById(idReservation);
    }

    @Override
    public Reservation getReservation(Long idReservation) {
        return reservationRepo.findById(idReservation).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return (List<Reservation>) reservationRepo.findAll();
    }
    @Override
    public long getReservationParAnneeUniversitaire(Date debutAnnee, Date finAnnee) {
        List<Reservation> reservation =  reservationRepo.findByAnneeUniversitaireBetween(debutAnnee, finAnnee);
        return reservation.size();
    }



    @Override
    @Transactional
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(Reservation res, Long numChambre, Long cin) {

        Reservation resrvation = reservationRepo.findById(res.getIdReservation()).orElse(null);
        resrvation.setChamber(chambreRepository.findById(numChambre).orElse(null));
        resrvation.getEtudiants().add(etudiantRepository.findEtudiantByCin(cin));
        return resrvation;

    }


    @Override
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        Chambre ch = chambreRepository.findById(idChambre).orElse(null);
        Etudiant et = etudiantRepository.findEtudiantByCin(cinEtudiant);
        Reservation r = new Reservation();
        r.setNumReservation(ch.getNumeroChambre()+"-"+ch.getBlocchambre().getNomBloc()+"-"+cinEtudiant);
        r.setDebutanneeUniversitaire(LocalDate.parse(LocalDate.now().getYear() + "-09-01"));
        r.setFinanneeUniversitaire(LocalDate.parse((LocalDate.now().getYear() + 1) + "-06-01"));
        r.setEstValide(true);
        int c=ch.getReservations().size();
        if(r.getEtudiants()==null){
            r.setEtudiants(new HashSet <> ());
        }
        if(ch.getReservations()==null){
            ch.setReservations(new HashSet<>());
        }
        if(ch.getTypeC()== TypeChambre.Simple && c<1 ){
            r=reservationRepo.save(r);
            ch.getReservations().add(r);
            r.getEtudiants().add(et);

            chambreRepository.save(ch);
            return r;

        }

        if(ch.getTypeC()==TypeChambre.Double && c<2 ){
            r=reservationRepo.save(r);
            ch.getReservations().add(r);
            r.getEtudiants().add(et);

            chambreRepository.save(ch);
            return r;


        }
        if(ch.getTypeC()==TypeChambre.Triple && c<3 ){
            r=reservationRepo.save(r);
            ch.getReservations().add(r);
            r.getEtudiants().add(et);

            chambreRepository.save(ch);
            return r;

        }

        return null;
    }
    @Transactional
    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant e =etudiantRepository.findEtudiantByCin(cinEtudiant);
        List<Reservation> r = reservationRepo.findByEtudiants(e);
        for(Reservation re:r) {
            Chambre ch = chambreRepository.findChambreByReservations(re);
            ch.getReservations().remove(re);
            re.getEtudiants().remove(e);
            re.setEstValide(false);
            reservationRepo.save(re);
        }


        return null;
    }

}
