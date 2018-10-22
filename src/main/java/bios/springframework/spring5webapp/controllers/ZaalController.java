package bios.springframework.spring5webapp.controllers;

import bios.springframework.spring5webapp.repositories.ZaalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ZaalController {

    private ZaalRepository zaalRepository;

    public ZaalController(ZaalRepository zaalRepositoryRepository){
        this.zaalRepository = zaalRepositoryRepository;
    }

    @RequestMapping("/zalen")
    public String getZalen(Model model){

        model.addAttribute("zalen", zaalRepository.findAll());
        return "zalen";
    }
}
