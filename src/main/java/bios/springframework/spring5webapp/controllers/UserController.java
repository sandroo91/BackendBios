package bios.springframework.spring5webapp.controllers;

import bios.springframework.spring5webapp.dao.UserDAO;
import bios.springframework.spring5webapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"*", "http://localhost:8080",  "http://localhost:8081", "http://localhost:8082", "http://localhost:1433"})
@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    UserDAO userDAO;

//    @PostMapping(value= "/save" , consumes = {MediaType.APPLICATION_JSON_VALUE})
//    public User createUser(@Valid @RequestBody User user){
//        return UserDAO.save(user);
//    }

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userDAO.findAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<User>getUserById(@PathVariable(value="id") Long id){
        User user = userDAO.findById(id);

        if (user==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Zaal>updateZaal(@PathVariable(value="id")Long id,@Valid @RequestBody Zaal zaalDetails){
//        Zaal zaal= zaalDAO.findById(id);
//
//        if (zaal == null){
//            return ResponseEntity.notFound().build();
//        }
//
//        zaal.setZaalId(zaalDetails.getZaalId());
//        zaal.setDrieDZaal(zaalDetails.getDrieDZaal());
//        zaal.setAantalStoelen(zaalDetails.getAantalStoelen());
//        zaal.setimaxZaal(zaalDetails.getimaxZaal());
//        zaal.setzaalNummer(zaalDetails.getZaalNummer());
//
//        Zaal updateZaal= zaalDAO.save(zaal);
//
//        return ResponseEntity.ok().body(zaal);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Zaal> deleteZaal(@PathVariable(value="id")Long id){
//        Zaal zaal = zaalDAO.findById(id);
//
//        if (zaal == null){
//            return ResponseEntity.notFound().build();
//        }
//        zaalDAO.delete(zaal);
//
//        return ResponseEntity.ok().build();
//    }

}
