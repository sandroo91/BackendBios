package bios.springframework.spring5webapp.dao;

import bios.springframework.spring5webapp.model.Tijden;
import bios.springframework.spring5webapp.repositories.TijdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TijdenDAO {

    @Autowired
    TijdenRepository tijdenRepository;


    public Tijden save(Tijden tijden){
        return tijdenRepository.save(tijden);
    }

    public List<Tijden> findAll(){
        return (List<Tijden>) tijdenRepository.findAll();

    }
}
