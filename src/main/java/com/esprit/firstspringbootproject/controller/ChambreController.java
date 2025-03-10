package com.esprit.firstspringbootproject.controller;

import com.esprit.firstspringbootproject.entities.Chambre;
import com.esprit.firstspringbootproject.services.IChambreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chambre")
@AllArgsConstructor
public class ChambreController {
    IChambreService chambreService;

    @PostMapping("/add")
    public Chambre addChambre(@RequestBody Chambre c) {
        return chambreService.addChambre(c);
    }

    @GetMapping("/getAll")
    public List<Chambre> getAll() {
        return chambreService.retrieveAllChambres();
    }

    @PutMapping("/{id}")
    public Chambre updateChambre(@PathVariable Long id, @RequestBody Chambre c) {
        return chambreService.updateChambre(c);
    }

    @GetMapping("/{id}")
    public Chambre retrieveChambre(@PathVariable Long id) {
        return chambreService.retrieveChambre(id);
    }
}
