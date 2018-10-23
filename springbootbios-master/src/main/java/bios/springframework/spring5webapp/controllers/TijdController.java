package bios.springframework.spring5webapp.controllers;

import bios.springframework.spring5webapp.repositories.TijdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TijdController {

    private TijdRepository tijdRepository;

    public TijdController(TijdRepository tijdRepository) {
        this.tijdRepository = tijdRepository;
    }

    @RequestMapping("/tijden")
    public String getBooks(Model model){

        model.addAttribute("tijden", tijdRepository.findAll());

        return "tijden";
    }
}