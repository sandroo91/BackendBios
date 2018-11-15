package bios.springframework.spring5webapp.controllers;

import bios.springframework.spring5webapp.model.Stoel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import bios.springframework.spring5webapp.dao.StoelDAO;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:8080",  "http://localhost:8081", "http://localhost:1433"})
@RestController
@RequestMapping("/stoel")
public class StoelController {

    @Autowired
    StoelDAO stoelDAO;


    @PostMapping(value= "/save" , consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Stoel createStoel(@Valid @RequestBody Stoel stoel){
        return stoelDAO.save(stoel);
    }

    @GetMapping("/getAll")
    public List<Stoel> getAllstoelen(){
        return stoelDAO.findAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Stoel>getStoelById(@PathVariable(value="id") Long id){
        Stoel stoel = stoelDAO.findById(id);

        if (stoel==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(stoel);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Stoel>updateStoel(@PathVariable(value="id")Long id,@Valid @RequestBody Stoel stoelDetails){
        Stoel stoel = stoelDAO.findById(id);

        if (stoel == null){
            return ResponseEntity.notFound().build();
        }

        stoel.setstoelNummer(stoel.getstoelNummer());

        Stoel updateStoel= stoelDAO.save(stoel);

        return ResponseEntity.ok().body(stoel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Stoel> deleteStoel(@PathVariable(value="id")Long id){
        Stoel stoel = stoelDAO.findById(id);

        if (stoel == null){
            return ResponseEntity.notFound().build();
        }
        stoelDAO.delete(stoel);

        return ResponseEntity.ok().build();
    }

}
