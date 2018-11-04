package bios.springframework.spring5webapp.dao;

import bios.springframework.spring5webapp.model.Film;
import bios.springframework.spring5webapp.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FilmDAO {

    @Autowired
    FilmRepository filmRepository;


    public Film save(Film film){
        return filmRepository.save(film);
    }

    public List<Film> findAll(){
        return (List<Film>) filmRepository.findAll();

    }
}
