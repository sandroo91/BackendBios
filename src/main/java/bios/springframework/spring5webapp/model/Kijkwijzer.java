package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name= "Kijkwijzer")
public class Kijkwijzer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="tekst")
    private String tekst;

    @Column(name="symbool", length = 5000)
    private String symbool;


    @ManyToMany(mappedBy="kijkwijzers")
    @JsonIgnoreProperties(value = "kijkwijzers")
    private Set<Film> films = new HashSet<Film>();

    public Kijkwijzer() {
    }

    public Kijkwijzer(Long Id) {
        this.Id = Id;
    }


    @JsonGetter(value="id")
    public Long getKwid() {
        return Id;
    }

    @JsonSetter(value="id")
    public void setKwid(Long kwid) {
        this.Id = kwid;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String getSymbool() {
        return symbool;
    }

    public void setSymbool(String symbool) {
        this.symbool = symbool;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    @JsonIgnore
    public void addFilm(Film film){
        film.getKijkwijzers().add(this);
        this.films.add(film);
    }

    @JsonIgnore
    public void removeFilm(Film film){
        film.setKijkwijzers(null);
        this.films.remove(film);
    }
}
