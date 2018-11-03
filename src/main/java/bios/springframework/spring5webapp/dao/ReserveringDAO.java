package bios.springframework.spring5webapp.dao;

import bios.springframework.spring5webapp.model.Reservering;
import bios.springframework.spring5webapp.repositories.ReserveringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ReserveringDAO {

    @Autowired
    ReserveringRepository reserveringRepository;


    public Reservering save(Reservering reservering){
        return reserveringRepository.save(reservering);
    }

    public List<Reservering> findAll(){
        return (List<Reservering>) reserveringRepository.findAll();

    }
}
