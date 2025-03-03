package com.esprit.firstspringbootproject.controller;
import com.esprit.firstspringbootproject.entities.Etudiant;
import com.esprit.firstspringbootproject.services.IEtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/etudiant")
@AllArgsConstructor
public class EtudiantController {
    IEtudiantService etudiantService;
        @PostMapping("addEtudiant")
        public Etudiant addEtudiant(@RequestBody List<Etudiant> e){return (Etudiant) etudiantService.addEtudiants(e);}
        @GetMapping("/getAll")
    public List<Etudiant> getAll(){
        return etudiantService.retrieveAllEtudiants();
    }
    @PutMapping("/{id}")
    public Etudiant updateEtudiant(@PathVariable Long id, @RequestBody Etudiant e) {
        return etudiantService.updateEtudiant(e);
    }
    @GetMapping("/{id}")
    public Etudiant retrieveEtudiant(@PathVariable Long id) {
        return etudiantService.retrieveEtudiant(id);
    }
    @DeleteMapping("/{id}")
    public void removeBloc(@PathVariable Long id) {
        etudiantService.removeEtudiant(id);
    }

}
