package tn.esprit.ben_nagra_yosr.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ben_nagra_yosr.entites.Foyer;
import tn.esprit.ben_nagra_yosr.services.IFoyerService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping ("foyer")
@RestController
@Tag(name = "Foyer")
public class FoyerRestController {
    private final IFoyerService foyerServices;

    @GetMapping ("/all")
    @Operation (summary = "Get all foyers")
    public List < Foyer > getAllFoyer(){
        return foyerServices.GetAllfoyer();
    }
    @PostMapping ("/add")
    @Operation(summary = "Add a new foyer")
    public Foyer addFoyer(@RequestBody Foyer f){
        return foyerServices.Ajouterfoyer(f);
    }

// Existing code

@DeleteMapping("/delete/{id}")
@Operation(summary = "Delete a foyer by id")
public void deleteFoyer(@PathVariable("id") Long id){

  foyerServices.SupprimeFoyer(id);

}
    @PutMapping("update")
    @Operation(summary = "Update a foyer")
    public Foyer ModifierFoyer( @RequestBody Foyer f) {
        return foyerServices.Updatefoyer(f);
    }

    @GetMapping("getfoyer/{id}")
    @Operation(summary = "Get a foyer by id")
    public Foyer getfoyerByid(@PathVariable long id){
        return foyerServices.Getfoyer(id);
    }
}
