package bios.springframework.spring5webapp.controllers;

import bios.springframework.spring5webapp.model.Voorstelling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import bios.springframework.spring5webapp.dao.VoorstellingDAO;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jt on 5/18/17.
 */
@CrossOrigin(origins = { "http://localhost:8080",  "http://localhost:8081" })
@RestController
@RequestMapping("/voorstelling")
public class VoorstellingController {

    @Autowired
    VoorstellingDAO voorstellingDAO;


    @PostMapping(value= "/filmstijdenzalen" , consumes = {MediaType.APPLICATION_JSON_VALUE})
        public Voorstelling createVoorstelling(@Valid @RequestBody Voorstelling voorstelling){
        return voorstellingDAO.save(voorstelling);
    }

    @GetMapping("/filmstijdenzalen")
        public List<Voorstelling> getAllVoorstellingen(){
        return voorstellingDAO.findAll();
    }

}
