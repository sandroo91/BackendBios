package bios.springframework.spring5webapp.controllers;

import bios.springframework.spring5webapp.repositories.StoelRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import bios.springframework.spring5webapp.model.Film;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StoelController {

    private StoelRepository stoelRepository;

    public StoelController(StoelRepository stoelRepository) {
        this.stoelRepository = stoelRepository;
    }


    @RequestMapping("/stoelen")
    public String getStoelNummer(Model model){

        model.addAttribute("films", stoelRepository.findAll());

        return "stoelen";
    }


}
