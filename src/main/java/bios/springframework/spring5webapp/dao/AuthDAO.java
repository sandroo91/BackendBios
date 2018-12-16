package bios.springframework.spring5webapp.dao;

import bios.springframework.spring5webapp.model.Auth;
import bios.springframework.spring5webapp.model.Zaal;
import bios.springframework.spring5webapp.repositories.AuthRepository;
import bios.springframework.spring5webapp.repositories.ZaalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthDAO {

    @Autowired
    AuthRepository authRepository;


    public Auth save(Auth auth){
        return authRepository.save(auth);
    }

    public List<Auth> findAll(){
        return authRepository.findAll();
    }

    public Auth findById(Long authid){
        return authRepository.findById(authid).get();
    }

    public void delete(Auth auth){
        authRepository.delete(auth);
    }
}
