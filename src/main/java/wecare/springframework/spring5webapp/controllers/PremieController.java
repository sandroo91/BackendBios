package wecare.springframework.spring5webapp.controllers;

import wecare.springframework.spring5webapp.model.Premie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wecare.springframework.spring5webapp.dao.PremieDAO;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"*", "http://localhost:8080", "http://localhost:8081", "http://localhost:8082", "http://localhost:8083", "http://localhost:1433"})
@RestController
@RequestMapping("/premie")
public class PremieController {

    @Autowired
    PremieDAO premieDAO;


    @PostMapping(value= "/save" , consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Premie createPremie(@Valid @RequestBody Premie premie){
        return premieDAO.save(premie);
    }

    @GetMapping("/apiDekking")
    public List<Premie> getAllPremies(){
        return premieDAO.findAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Premie> getPremieById(@PathVariable(value ="id")Long id){

        Premie premie = premieDAO.findById(id);

        if (premie == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(premie);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Premie> updatePremie(@PathVariable(value="id")Long id, @Valid @RequestBody Premie premieDetails){

        Premie premie = premieDAO.findById(id);

        if (premie == null){
            return ResponseEntity.notFound().build();
        }

        premie.setPremieId(premieDetails.getpremieId());
        premie.setDekking(premieDetails.getDekking());
        premie.setPremie(premieDetails.getPremie());

       Premie UpdatePremie = premieDAO.save(premie);

        return ResponseEntity.ok().body(premie);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Premie> deleteFilm(@PathVariable(value="id")Long id){
        Premie premie = premieDAO.findById(id);

        if (premie == null){
            return ResponseEntity.notFound().build();
        }
        premieDAO.delete(premie);

        return ResponseEntity.ok().build();
    }



}
