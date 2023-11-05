package tn.esprit.ben_nagra_yosr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ben_nagra_yosr.entites.Etudiant;

public interface IEtudiantRepo extends JpaRepository < Etudiant,Long> {
}
