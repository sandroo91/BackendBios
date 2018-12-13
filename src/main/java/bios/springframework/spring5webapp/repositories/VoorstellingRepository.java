package bios.springframework.spring5webapp.repositories;

import bios.springframework.spring5webapp.model.Voorstelling;
import bios.springframework.spring5webapp.model.Film;
import bios.springframework.spring5webapp.model.Zaal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Repository
public interface VoorstellingRepository extends JpaRepository<Voorstelling,Long> {

    @Query(value = "select v.id as id, v.dag as dag, v.tijd as tijd, f.titel as titel, z.zaalNummer as zaalNummer from Voorstelling v\n" +
            "inner join Film f on v.film = f.id \n" +
            "inner join Zaal z on v.zalen = z.id ")
    List<Voorstelling> getInfoFilmZaal();
}

