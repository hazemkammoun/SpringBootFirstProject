package com.esprit.firstspringbootproject.controller;

import com.esprit.firstspringbootproject.entities.Etudiant;
import com.esprit.firstspringbootproject.entities.Universite;
import com.esprit.firstspringbootproject.services.IUniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universite")
@AllArgsConstructor
public class UniversiteController {
    IUniversiteService universiteService;
    @PostMapping("addUniversite")
    public Universite addUniversite(@RequestBody Universite u){return universiteService.addUniversite(u);}
    @GetMapping("/getAll")
    public List<Universite> getAll(){
        return universiteService.retrieveAllUniversities();
    }
    @PutMapping("/{id}")
    public Universite updateUniversite(@PathVariable Long id, @RequestBody Universite u) {
        return universiteService.updateUniversite(u);
    }
    @GetMapping("/{id}")
    public Universite retrieveUniversity(@PathVariable Long id) {
        return universiteService.retrieveUniversite(id);
    }
    @PutMapping("/affecter-foyer/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(@PathVariable long idFoyer, @PathVariable String nomUniversite) {
        return universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }
    @PostMapping("/desaffecter/{idUniversite}")
    public ResponseEntity<Universite> desaffecterFoyerAUniversite(@PathVariable long idUniversite) {
        Universite universite = universiteService.desaffecterFoyerAUniversite(idUniversite);
        return ResponseEntity.ok(universite);
    }
}
