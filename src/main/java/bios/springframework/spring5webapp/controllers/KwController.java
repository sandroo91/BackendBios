package bios.springframework.spring5webapp.controllers;

import bios.springframework.spring5webapp.model.Kijkwijzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import bios.springframework.spring5webapp.dao.KwDAO;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:8082",   "http://localhost:8081", "http://localhost:1433"})
@RestController
@RequestMapping("/kijkwijzer")
public class KwController {

    @Autowired
    KwDAO kwDAO;


    @PostMapping(value= "/save" , consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Kijkwijzer createKijkwijzert(@Valid @RequestBody Kijkwijzer kijkwijzer){
        return kwDAO.save(kijkwijzer);
    }

    @GetMapping("/getAll")
    public List<Kijkwijzer> getAllKijkwijzers(){
        return kwDAO.findAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Kijkwijzer> getKwById(@PathVariable(value ="id")Long id){

        Kijkwijzer kijkwijzer = kwDAO.findById(id);

        if (kijkwijzer == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(kijkwijzer);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Kijkwijzer> updateKw(@PathVariable(value="id")Long id, @Valid @RequestBody Kijkwijzer KwDetails){

        Kijkwijzer kijkwijzer = kwDAO.findById(id);

        if (kijkwijzer == null){
            return ResponseEntity.notFound().build();
        }
        kijkwijzer.setKwid(KwDetails.getKwid());
        kijkwijzer.setSymbool(KwDetails.getSymbool());
        kijkwijzer.setTekst(KwDetails.getTekst());

        Kijkwijzer UpdateKw = kwDAO.save(kijkwijzer);

        return ResponseEntity.ok().body(kijkwijzer);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Kijkwijzer> deleteKw(@PathVariable(value="id")Long id){
        Kijkwijzer kijkwijzer = kwDAO.findById(id);

        if (kijkwijzer == null){
            return ResponseEntity.notFound().build();
        }
        kwDAO.delete(kijkwijzer);

        return ResponseEntity.ok().build();
    }



}
