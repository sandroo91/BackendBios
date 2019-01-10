package bios.springframework.spring5webapp.dao;

import bios.springframework.spring5webapp.model.Authority;
import bios.springframework.spring5webapp.repositories.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityDAO {

    @Autowired
    AuthorityRepository authorityRepository;


    public Authority save(Authority rol){ return authorityRepository.save(rol); }

    public List<Authority> findAll(){
        return authorityRepository.findAll();
    }

    public Authority findById(Long rolid){
        return authorityRepository.findById(rolid).get();
    }

    public void delete(Authority authority){
        authorityRepository.delete(authority);
    }
}
