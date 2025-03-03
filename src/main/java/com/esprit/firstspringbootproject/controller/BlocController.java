package com.esprit.firstspringbootproject.controller;

import com.esprit.firstspringbootproject.entities.Bloc;
import com.esprit.firstspringbootproject.services.IBlocService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloc")
@AllArgsConstructor
public class BlocController {
IBlocService blocService;
@PostMapping("addBloc")
public Bloc addBloc(@RequestBody Bloc b){return blocService.addBloc(b);}
    @GetMapping("/getAll")
    public List<Bloc> getAll(){
        return blocService.retrieveBlocs();
    }
    @PutMapping("/{id}")
    public Bloc updateBloc(@PathVariable Long id, @RequestBody Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    @GetMapping("/{id}")
    public Bloc retrieveBloc(@PathVariable Long id) {
        return blocService.retrieveBloc(id);
    }

    @DeleteMapping("/{id}")
    public void removeBloc(@PathVariable Long id) {
        blocService.removeBloc(id);
    }

}
