package tn.esprit.ben_nagra_yosr.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ben_nagra_yosr.entites.Foyer;
import tn.esprit.ben_nagra_yosr.services.IFoyerService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("foyer")
@RestController
@CrossOrigin(origins = "*")
public class FoyerRestController {
    private final IFoyerService foyerServices;

    @GetMapping("/all")
    public List<Foyer> getAllFoyer(){
        return foyerServices.getAllFoyer();
    }

    @PostMapping("/add")
    public Foyer addFoyer(@RequestBody Foyer f){
        return foyerServices.ajouterFoyer(f);
    }

    @PostMapping("/update")
    public Foyer updateFoyer(@RequestBody Foyer f){
        return foyerServices.updateFoyer(f);
    }

    @DeleteMapping ("/delete/{idFoyer}")
    public void deleteFoyer(@PathVariable Long idFoyer){
        foyerServices.supprimerFoyer(idFoyer);
    }

    @PutMapping("update")
    public Foyer ModifierFoyer( @RequestBody Foyer f) {
        return foyerServices.updateFoyer(f);
    }

    @GetMapping("getfoyer/{id}")
    public Foyer getfoyerByid(@PathVariable long id){
        return foyerServices.getFoyer(id);
    }

    @PostMapping ("/ajouterFoyerEtAffecterAUniversite/{idUniv}")
    public void ajouterFoyerEtAffecterAUniversiteApi(@RequestBody Foyer f,@PathVariable Long idUniv){
        foyerServices.ajouterFoyerEtAffecterAUniversite(f,idUniv);
    }
}
