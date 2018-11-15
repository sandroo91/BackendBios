package bios.springframework.spring5webapp.dao;

import bios.springframework.spring5webapp.model.Reservering;
import bios.springframework.spring5webapp.repositories.ReserveringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.PersistenceUnit;


import java.util.List;
import java.util.Optional;

@Service
public class ReserveringDAO {

    @Autowired
    ReserveringRepository reserveringRepository;


    public Reservering save(Reservering reservering){
        return reserveringRepository.save(reservering);
    }

    public List<Reservering> findAll(){
        return reserveringRepository.findAll();
    }

    public Reservering findById(Long reserveringid){
        return reserveringRepository.findById(reserveringid).get();
    }

    public void delete(Reservering reservering){
        reserveringRepository.delete(reservering);
    }

}
