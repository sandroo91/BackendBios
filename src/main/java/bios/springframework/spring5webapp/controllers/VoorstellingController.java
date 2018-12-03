package bios.springframework.spring5webapp.controllers;

import bios.springframework.spring5webapp.dao.FilmDAO;
import bios.springframework.spring5webapp.dao.ZaalDAO;
import bios.springframework.spring5webapp.model.Film;
import bios.springframework.spring5webapp.model.Voorstelling;
import bios.springframework.spring5webapp.model.Zaal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import bios.springframework.spring5webapp.dao.VoorstellingDAO;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:8080",  "http://localhost:8082", "http://localhost:8083", "http://localhost:1433"})
@RestController
@RequestMapping("/voorstelling")
public class VoorstellingController {

    @Autowired
    VoorstellingDAO voorstellingDAO;

    @Autowired
    FilmDAO filmDAO;

    @Autowired
    ZaalDAO zaalDAO;

    @PostMapping(value= "/save" , consumes = {MediaType.APPLICATION_JSON_VALUE})
        public Voorstelling createVoorstelling(@Valid @RequestBody Voorstelling voorstelling){

//            Film f = filmDAO.findById(voorstelling.getFilms().getFilmid());
//            Zaal z = zaalDAO.findById(voorstelling.getZalen().getId());
//
//            f.addVoorstelling(voorstelling);    // dubbel werk ? film zit al in voorstelling toch ?
//            z.addVoorstelling(voorstelling);    // maargoed, voor de zekerheid toegevoegd aan de hashmaps
                                                // zodat de relatie bekend is
        return voorstellingDAO.save(voorstelling);
    }

    @GetMapping("/getAll")
        public List<Voorstelling> getAllVoorstellingen(){
        return voorstellingDAO.findAll();
    }

    @GetMapping("/getById/{id}")
        public ResponseEntity<Voorstelling>getVoorstellingById(@PathVariable(value="id") Long id){
        Voorstelling voorstelling = voorstellingDAO.findById(id);

        if (voorstelling==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(voorstelling);
    }

    @PutMapping(value="/update/{id}")
        public ResponseEntity<Voorstelling>updateVoorstelling(@PathVariable(value="id")Long id,@Valid @RequestBody Voorstelling voorstellingDetails){
            Voorstelling voorstelling = voorstellingDAO.findById(id);

            if (voorstelling == null){
                return ResponseEntity.notFound().build();
            }

            voorstelling.setId(voorstellingDetails.getId());
            voorstelling.setDag(voorstellingDetails.getDag());
            voorstelling.setFilms(voorstellingDetails.getFilms());
            voorstelling.setTijd(voorstellingDetails.getTijd());
            voorstelling.setZalen(voorstellingDetails.getZalen());

            Voorstelling updateVoorstelling= voorstellingDAO.save(voorstelling);

            return ResponseEntity.ok().body(voorstelling);
    }

    @DeleteMapping("/delete/{id}")
        public ResponseEntity<Voorstelling> deleteVoorstelling(@PathVariable(value="id")Long id){
            Voorstelling voorstelling = voorstellingDAO.findById(id);

        if (voorstelling == null){
            return ResponseEntity.notFound().build();
        }
        voorstellingDAO.delete(voorstelling);

        return ResponseEntity.ok().build();
    }

}
