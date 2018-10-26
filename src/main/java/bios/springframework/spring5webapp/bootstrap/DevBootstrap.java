package bios.springframework.spring5webapp.bootstrap;

import bios.springframework.spring5webapp.model.Zaal;
import bios.springframework.spring5webapp.model.Film;
import bios.springframework.spring5webapp.model.Tijden;
import bios.springframework.spring5webapp.model.Voorstelling;
import bios.springframework.spring5webapp.repositories.ZaalRepository;
import bios.springframework.spring5webapp.repositories.FilmRepository;
import bios.springframework.spring5webapp.repositories.TijdRepository;
import bios.springframework.spring5webapp.repositories.VoorstellingRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ZaalRepository zaalRepository;
    private FilmRepository filmRepository;
    private TijdRepository tijdRepository;
    private VoorstellingRepository voorstellingRepository;


    public DevBootstrap(ZaalRepository zaalRepository, FilmRepository filmRepository, TijdRepository tijdRepository, VoorstellingRepository voorstellingRepository) {
        this.zaalRepository = zaalRepository;
        this.filmRepository = filmRepository;
        this.tijdRepository = tijdRepository;
        this.voorstellingRepository = voorstellingRepository;

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){



        //Zaal 1
        Zaal zaal = new Zaal("Zaal 1");
        Film ddd = new Film("James Bond");
        Tijden tijd1 = new Tijden("10:00");
        Voorstelling voorstelling1 = new Voorstelling();
        voorstelling1.setFilms(ddd);
        voorstelling1.setZalen(zaal);
        voorstelling1.setBegintijden(tijd1);



        zaalRepository.save(zaal);
        filmRepository.save(ddd);
        tijdRepository.save(tijd1);
        voorstellingRepository.save(voorstelling1);

    }

}
