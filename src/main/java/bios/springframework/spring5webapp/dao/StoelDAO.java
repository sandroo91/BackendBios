package bios.springframework.spring5webapp.dao;

import bios.springframework.spring5webapp.model.Stoel;
import bios.springframework.spring5webapp.repositories.StoelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StoelDAO {

    @Autowired
    StoelRepository stoelRepository;


    public Stoel save(Stoel stoel){
        return stoelRepository.save(stoel);
    }

    public List<Stoel> findAll(){
        return (List<Stoel>) stoelRepository.findAll();

    }
}
