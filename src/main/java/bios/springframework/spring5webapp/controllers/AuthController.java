package bios.springframework.spring5webapp.controllers;

import bios.springframework.spring5webapp.dao.AuthDAO;
import bios.springframework.spring5webapp.model.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = { "*","http://localhost:8080",  "http://localhost:8081", "http://localhost:8082", "http://localhost:1433"})
@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    AuthDAO authDAO;

    @PostMapping(value= "/save" , consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Auth createAuth(@Valid @RequestBody Auth auth){
        return authDAO.save(auth);
    }

    @GetMapping("/getAuth")
    public List<Auth> getAllAuth(){
        return authDAO.findAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Auth>getAuthById(@PathVariable(value="id") Long id){
        Auth auth = authDAO.findById(id);

        if (auth==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(auth);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Auth>updateAuth(@PathVariable(value="id")Long id,@Valid @RequestBody Auth authDetails){
        Auth auth= authDAO.findById(id);

        if (auth == null){
            return ResponseEntity.notFound().build();
        }

        auth.setAuthId(authDetails.getAuthId());
        auth.setUserName(authDetails.getUserName());
        auth.setPassWord(authDetails.getPassWord());

        Auth updateAuth= authDAO.save(auth);

        return ResponseEntity.ok().body(auth);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Auth> deleteAuth(@PathVariable(value="id")Long id){
        Auth auth = authDAO.findById(id);

        if (auth == null){
            return ResponseEntity.notFound().build();
        }
        authDAO.delete(auth);

        return ResponseEntity.ok().build();
    }

}
