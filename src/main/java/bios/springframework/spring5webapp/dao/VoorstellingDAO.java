package bios.springframework.spring5webapp.dao;

import bios.springframework.spring5webapp.model.Voorstelling;
import bios.springframework.spring5webapp.model.Film;
import bios.springframework.spring5webapp.model.Zaal;
import bios.springframework.spring5webapp.repositories.VoorstellingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;


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

    public List<Voorstelling> findFilmZaal() {
        return voorstellingRepository.getInfoFilmZaal();
    }
 }
