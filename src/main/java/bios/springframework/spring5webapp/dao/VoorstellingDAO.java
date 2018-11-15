package bios.springframework.spring5webapp.dao;

import bios.springframework.spring5webapp.model.Voorstelling;
import bios.springframework.spring5webapp.repositories.VoorstellingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class VoorstellingDAO {

    @Autowired
    VoorstellingRepository voorstellingRepository;


    public Voorstelling save(Voorstelling voorstelling){
        return voorstellingRepository.save(voorstelling);
    }

    public List<Voorstelling> findAll(){
        return voorstellingRepository.findAll();
    }

    public Voorstelling  findById(Long voorstellingid){
        return voorstellingRepository.findById(voorstellingid).get();
    }

    public void delete(Voorstelling voorstelling){
        voorstellingRepository.delete(voorstelling);
    }


 }
