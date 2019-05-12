package wecare.springframework.spring5webapp.dao;

import wecare.springframework.spring5webapp.model.Premie;
import wecare.springframework.spring5webapp.repositories.PremieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PremieDAO {

    @Autowired
    PremieRepository premieRepository;

    /*save een premie*/
    public Premie save(Premie premie){
        return premieRepository.save(premie);
    }

    /*vind alle premies*/
    public List<Premie> findAll(){
        return premieRepository.findAll();
    }

    /*haal een premie op bij id*/
    public Premie findById(Long premieid){
        return premieRepository.findById(premieid).get();
    }

    /*delete een film (object)*/
    public void delete(Premie premie){
        premieRepository.delete(premie);
    }
}
