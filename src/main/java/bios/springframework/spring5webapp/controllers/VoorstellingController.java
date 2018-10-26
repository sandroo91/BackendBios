package bios.springframework.spring5webapp.controllers;

import bios.springframework.spring5webapp.repositories.VoorstellingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 5/18/17.
 */
@Controller
public class VoorstellingController {

    private VoorstellingRepository voorstellingRepository;

    public VoorstellingController(VoorstellingRepository voorstellingRepository) {
        this.voorstellingRepository = voorstellingRepository;
    }

    @RequestMapping("/voorstellingen")
    public String getBooks(Model model){

        model.addAttribute("voorstellingen", voorstellingRepository.findAll());

        return "voorstellingen";
    }
}