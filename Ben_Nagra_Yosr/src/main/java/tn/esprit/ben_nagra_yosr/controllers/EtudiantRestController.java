package tn.esprit.ben_nagra_yosr.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ben_nagra_yosr.entites.Bloc;
import tn.esprit.ben_nagra_yosr.entites.Etudiant;
import tn.esprit.ben_nagra_yosr.services.IEtudiantService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping ("etudiant")
@RestController
public class EtudiantRestController {
    private final IEtudiantService etudiantService;
    @GetMapping("/all")
    public List< Etudiant > getAllEtudiant(){
        return etudiantService.getAllEtudiants();
    }

    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant e){
        return etudiantService.ajouterEtudiant(e);
    }

    @PostMapping("/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant e){
        return etudiantService.updateEtudiant(e);
    }

    @DeleteMapping ("/delete/{idEtudiant}")
    public void deleteEtudiant(@PathVariable Long idEtudiant){
        etudiantService.supprimerEtudiant(idEtudiant);
    }

}
