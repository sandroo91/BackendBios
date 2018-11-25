package bios.springframework.spring5webapp.controllers;

import bios.springframework.spring5webapp.model.Zaal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import bios.springframework.spring5webapp.dao.ZaalDAO;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:8080",  "http://localhost:8081", "http://localhost:1433"})
@RestController
@RequestMapping("/Zaal")
public class ZaalController {

    @Autowired
    ZaalDAO zaalDAO;


    @PostMapping(value= "/save" , consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Zaal createZaal(@Valid @RequestBody Zaal zaal){
        return zaalDAO.save(zaal);
    }

    @GetMapping("/getAll")
    public List<Zaal> getAllZalen(){
        return zaalDAO.findAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Zaal>getZaalById(@PathVariable(value="id") Long id){
        Zaal zaal = zaalDAO.findById(id);

        if (zaal==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(zaal);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Zaal>updateZaal(@PathVariable(value="id")Long id,@Valid @RequestBody Zaal zaalDetails){
        Zaal zaal= zaalDAO.findById(id);

        if (zaal == null){
            return ResponseEntity.notFound().build();
        }
        zaal.setDrieDZaal(zaalDetails.getDrieDZaal());
        zaal.setAantalStoelen(zaalDetails.getAantalStoelen());
        zaal.setimaxZaal(zaalDetails.getimaxZaal());
        zaal.setzaalNummer(zaalDetails.getZaalNummer());

        Zaal updateZaal= zaalDAO.save(zaal);

        return ResponseEntity.ok().body(zaal);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Zaal> deleteZaal(@PathVariable(value="id")Long id){
        Zaal zaal = zaalDAO.findById(id);

        if (zaal == null){
            return ResponseEntity.notFound().build();
        }
        zaalDAO.delete(zaal);

        return ResponseEntity.ok().build();
    }

}
