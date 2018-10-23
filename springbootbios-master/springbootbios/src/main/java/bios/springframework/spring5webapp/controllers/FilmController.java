package bios.springframework.spring5webapp.controllers;

import bios.springframework.spring5webapp.repositories.FilmRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 5/18/17.
 */
@Controller
public class FilmController {

    private FilmRepository filmRepository;

    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @RequestMapping("/films")
    public String getBooks(Model model){

        model.addAttribute("films", filmRepository.findAll());

        return "films";
    }
}
