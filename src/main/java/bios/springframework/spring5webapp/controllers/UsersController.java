package bios.springframework.spring5webapp.controllers;

import bios.springframework.spring5webapp.dao.UsersDAO;
import bios.springframework.spring5webapp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = { "*","http://localhost:8080",  "http://localhost:8081", "http://localhost:8082", "http://localhost:1433"})
@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    UsersDAO usersDAO;

    @PostMapping(value= "/save" , consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Users createAuth(@Valid @RequestBody Users users){
        return usersDAO.save(users);
    }

    @GetMapping("/getAuth")
    public List<Users> getAllAuth(){
        return usersDAO.findAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Users>getAuthById(@PathVariable(value="id") Long id){
        Users users = usersDAO.findById(id);

        if (users==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(users);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Users>updateAuth(@PathVariable(value="id")Long id, @Valid @RequestBody Users usersDetails){
        Users users= usersDAO.findById(id);

        if (users == null){
            return ResponseEntity.notFound().build();
        }

        //users.setId(usersDetails.getId());
        users.setUserName(usersDetails.getUserName());
        users.setPassword(usersDetails.getPassword());
        users.setEnabled(usersDetails.isEnabled());

        Users updateAuth= usersDAO.save(users);

        return ResponseEntity.ok().body(users);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Users> deleteAuth(@PathVariable(value="id")Long id){
        Users users = usersDAO.findById(id);

        if (users == null){
            return ResponseEntity.notFound().build();
        }
        usersDAO.delete(users);

        return ResponseEntity.ok().build();
    }

}
