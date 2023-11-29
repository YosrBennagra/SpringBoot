package tn.esprit.ben_nagra_yosr.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ben_nagra_yosr.entites.Universite;
import tn.esprit.ben_nagra_yosr.services.IUniversiteService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping ("universite")
@RestController
public class UniversiteRestController {
    private final IUniversiteService universiteService;

    @GetMapping ("/all")
    public List < Universite > getAllUniversite(){
        return universiteService.getAllUniversite();
    }

    @PostMapping ("/add")
    public Universite addUniversite(@RequestBody Universite u){
        return universiteService.ajouterUniversite(u);
    }

    @PostMapping("/update")
    public Universite updateUniversite(@RequestBody Universite u){
        return universiteService.updateUniversite(u);
    }

    @DeleteMapping ("/delete/{idUniversite}")
    public void deleteUniversite(@PathVariable Long idUniversite){
        universiteService.supprimerUniversite(idUniversite);
    }

    @PutMapping("affecteruniv/{idfoyer}/{nom}")
    public Universite AffecterFoyerAUniversite(@PathVariable long idfoyer, @PathVariable String nom )
    {
        return universiteService.affecterFoyerAUniversite(idfoyer,nom);
    }

    @PutMapping("deaffecteruniv/{idfoyer}/{idUniversite}")
    public Universite DeaffecterUnivAFoyer(@PathVariable long idfoyer, @PathVariable long idUniversite )
    {
        return universiteService.desaffecterFoyerAUniversite(idfoyer,idUniversite);
    }

}
