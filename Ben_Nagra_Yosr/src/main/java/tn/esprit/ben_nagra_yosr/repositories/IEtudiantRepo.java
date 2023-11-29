package tn.esprit.ben_nagra_yosr.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.ben_nagra_yosr.entites.Etudiant;

public interface IEtudiantRepo extends CrudRepository < Etudiant,Long> {
    Etudiant findEtudiantByCin(long cin);
}
