package bios.springframework.spring5webapp.dao;

import bios.springframework.spring5webapp.model.Dag;
import bios.springframework.spring5webapp.repositories.DagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DagDAO {

    @Autowired
    DagRepository dagRepository;


    public Dag save(Dag dag){
        return dagRepository.save(dag);
    }

    public List<Dag> findAll(){
        return (List<Dag>) dagRepository.findAll();

    }
}
