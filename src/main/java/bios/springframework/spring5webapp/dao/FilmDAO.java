package bios.springframework.spring5webapp.dao;

import bios.springframework.spring5webapp.model.Film;
import bios.springframework.spring5webapp.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class FilmDAO {

    @Autowired
    FilmRepository filmRepository;


    public Film save(Film film){
        return filmRepository.save(film);
    }

    public List<Film> findAll(){
        return filmRepository.findAll();
    }

    public Film findById(Long filmid){
        return filmRepository.findById(filmid).get();
    }

    public void delete(Film film){
        filmRepository.delete(film);
    }
}
