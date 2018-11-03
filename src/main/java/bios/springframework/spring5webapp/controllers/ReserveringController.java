package bios.springframework.spring5webapp.controllers;

import bios.springframework.spring5webapp.model.Reservering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import bios.springframework.spring5webapp.dao.ReserveringDAO;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jt on 5/18/17.
 */
@CrossOrigin(origins = { "http://localhost:8080",  "http://localhost:8081" })
@RestController
@RequestMapping("/reserveringen")
public class ReserveringController {

    @Autowired
    ReserveringDAO reserveringDAO;


    @PostMapping(value= "/reserveringen" , consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Reservering createReservering(@Valid @RequestBody Reservering reservering){
        return reserveringDAO.save(reservering);
    }

    @GetMapping("/reserveringen")
    public List<Reservering> getAllReseerveringen(){
        return reserveringDAO.findAll();
    }

}
