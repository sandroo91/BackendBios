package bios.springframework.spring5webapp.controllers;

import bios.springframework.spring5webapp.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import bios.springframework.spring5webapp.dao.FilmDAO;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:8080",  "http://localhost:8081", "http://localhost:1433"})
@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    FilmDAO filmDAO;


    @PostMapping(value= "/save" , consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Film createVoorstelling(@Valid @RequestBody Film film){
        return filmDAO.save(film);
    }

    @GetMapping("/getAll")
    public List<Film> getAllFilms(){
        return filmDAO.findAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable(value ="id")Long id){

        Film film = filmDAO.findById(id);

        if (film == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(film);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable(value="id")Long id, @Valid @RequestBody Film filmDetails){

        Film film = filmDAO.findById(id);

        if (film == null){
            return ResponseEntity.notFound().build();
        }
        film.setAfloopDatum(filmDetails.getAfloopDatum());
        film.setDatumBeschikbaar(filmDetails.getDatumBeschikbaar());
        film.setTitel(filmDetails.getTitel());
        film.setSamenvatting(filmDetails.getSamenvatting());
        film.setPrijs(filmDetails.getPrijs());
        film.setimax(filmDetails.getimax());
        film.setPoster(filmDetails.getPoster());
        film.setExtralang(filmDetails.getExtralang());
        film.setDDD(filmDetails.getDDD());
        film.setKijkwijzers(filmDetails.getKijkwijzers());

        Film UpdateFilm = filmDAO.save(film);

        return ResponseEntity.ok().body(film);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Film> deleteFilm(@PathVariable(value="id")Long id){
        Film film = filmDAO.findById(id);

        if (film == null){
            return ResponseEntity.notFound().build();
        }
        filmDAO.delete(film);

        return ResponseEntity.ok().build();
    }



}
