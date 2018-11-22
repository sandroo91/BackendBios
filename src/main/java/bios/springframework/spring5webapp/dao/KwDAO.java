package bios.springframework.spring5webapp.dao;

import bios.springframework.spring5webapp.model.Kijkwijzer;
import bios.springframework.spring5webapp.repositories.KwRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class KwDAO {

    @Autowired
    KwRepository kwRepository;


    public Kijkwijzer save(Kijkwijzer kijkwijzer){
        return kwRepository.save(kijkwijzer);
    }

    public List<Kijkwijzer> findAll(){
        return kwRepository.findAll();
    }

    public Kijkwijzer findById(Long filmid){
        return kwRepository.findById(filmid).get();
    }

    public void delete(Kijkwijzer kijkwijzer){
        kwRepository.delete(kijkwijzer);
    }
}
