package bios.springframework.spring5webapp.bootstrap;


import bios.springframework.spring5webapp.model.Zaal;
import bios.springframework.spring5webapp.model.Film;
import bios.springframework.spring5webapp.model.Tijden;
import bios.springframework.spring5webapp.model.Dag;
import bios.springframework.spring5webapp.model.Voorstelling;
import bios.springframework.spring5webapp.model.Stoel;
import bios.springframework.spring5webapp.model.Reservering;
import bios.springframework.spring5webapp.repositories.ZaalRepository;
import bios.springframework.spring5webapp.repositories.FilmRepository;
import bios.springframework.spring5webapp.repositories.TijdRepository;
import bios.springframework.spring5webapp.repositories.DagRepository;
import bios.springframework.spring5webapp.repositories.VoorstellingRepository;
import bios.springframework.spring5webapp.repositories.StoelRepository;
import bios.springframework.spring5webapp.repositories.ReserveringRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ZaalRepository zaalRepository;
    private FilmRepository filmRepository;
    private TijdRepository tijdRepository;
    private DagRepository dagRepository;
    private VoorstellingRepository voorstellingRepository;
    private StoelRepository stoelRepository;
    private ReserveringRepository reserveringRepository;


    public DevBootstrap(ZaalRepository zaalRepository, FilmRepository filmRepository, TijdRepository tijdRepository,DagRepository dagRepository, VoorstellingRepository voorstellingRepository, StoelRepository stoelRepository, ReserveringRepository reserveringRepository) {
        this.zaalRepository = zaalRepository;
        this.filmRepository = filmRepository;
        this.tijdRepository = tijdRepository;
        this.dagRepository = dagRepository;
        this.voorstellingRepository = voorstellingRepository;
        this.stoelRepository = stoelRepository;
        this.reserveringRepository = reserveringRepository;

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

    }

}
