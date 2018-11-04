package bios.springframework.spring5webapp.controllers;

import bios.springframework.spring5webapp.repositories.DagRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import bios.springframework.spring5webapp.model.Dag;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DagController {

    private DagRepository dagRepository;

    public DagController(DagRepository dagRepository) {
        this.dagRepository = dagRepository;
    }


    @RequestMapping("/dagen")
    public String getDagen(Model model){

        model.addAttribute("dagen", dagRepository.findAll());

        return "dagen";
    }


}
