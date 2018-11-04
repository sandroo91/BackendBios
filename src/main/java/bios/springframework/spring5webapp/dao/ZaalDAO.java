package bios.springframework.spring5webapp.dao;

import bios.springframework.spring5webapp.model.Zaal;
import bios.springframework.spring5webapp.repositories.ZaalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ZaalDAO {

    @Autowired
    ZaalRepository zaalRepository;


    public Zaal save(Zaal zaal){
        return zaalRepository.save(zaal);
    }

    public List<Zaal> findAll(){
        return (List<Zaal>) zaalRepository.findAll();

    }
}
