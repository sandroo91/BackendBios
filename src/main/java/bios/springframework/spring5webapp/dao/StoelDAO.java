package bios.springframework.spring5webapp.dao;

import bios.springframework.spring5webapp.model.Stoel;
import bios.springframework.spring5webapp.repositories.StoelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StoelDAO {

    @Autowired
    StoelRepository stoelRepository;


    public Stoel save(Stoel stoel){
        return stoelRepository.save(stoel);
    }

    public List<Stoel> findAll(){
        return stoelRepository.findAll();
    }

    public Stoel findById(Long stoelid){
       return stoelRepository.findById(stoelid).get();
    }

    public void delete(Stoel stoel){
        stoelRepository.delete(stoel);
    }
}
