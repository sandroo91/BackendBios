package bios.springframework.spring5webapp.controllers;

import bios.springframework.spring5webapp.repositories.FilmRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import bios.springframework.spring5webapp.model.Film;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FilmController {

    private FilmRepository filmRepository;

    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }


    @RequestMapping("/films")
    public String getFilmTitel(Model model){

        model.addAttribute("films", filmRepository.findAll());

        return "films";
    }


}
