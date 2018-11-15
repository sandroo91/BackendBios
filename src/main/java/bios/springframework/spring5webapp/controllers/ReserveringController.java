package bios.springframework.spring5webapp.controllers;

import bios.springframework.spring5webapp.model.Reservering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import bios.springframework.spring5webapp.dao.ReserveringDAO;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:8080",  "http://localhost:8081", "http://localhost:1433"})
@RestController
@RequestMapping("/reservering")
public class ReserveringController {

    @Autowired
    ReserveringDAO reserveringDAO;


    @PostMapping(value= "/save" , consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Reservering createReservering(@Valid @RequestBody Reservering reservering){
        return reserveringDAO.save(reservering);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Reservering>getReserveringById(@PathVariable(value="id") Long id){
        Reservering reservering = reserveringDAO.findById(id);

        if (reservering==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(reservering);
    }

    @GetMapping("/getAll")
    public List<Reservering> getAllReserveringen(){
        return reserveringDAO.findAll();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Reservering>updateReservering(@PathVariable(value="id")Long id,@Valid @RequestBody Reservering reserveringDetails){
        Reservering reservering = reserveringDAO.findById(id);

        if (reservering == null){
            return ResponseEntity.notFound().build();
        }
        reservering.setEmailAdres(reserveringDetails.getEmailAdres());
        reservering.setStoelen(reserveringDetails.getStoelen());
        reservering.setVoorstellingen(reserveringDetails.getVoorstellingen());

        Reservering updateReservering= reserveringDAO.save(reservering);

        return ResponseEntity.ok().body(reservering);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Reservering> deleteReservering(@PathVariable(value="id")Long id){
        Reservering reservering = reserveringDAO.findById(id);

        if (reservering == null){
            return ResponseEntity.notFound().build();
        }
        reserveringDAO.delete(reservering);

        return ResponseEntity.ok().build();
    }

}
