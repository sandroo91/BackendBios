package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

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

    @Column(name="symbool", length = 3000)
    private String symbool;

    @JsonIgnore
    @ManyToMany(mappedBy="kijkwijzers")
    private Set<Film> filmen = new HashSet<Film>();

    public Kijkwijzer() {
    }

    public Kijkwijzer(Long Id) {
        this.Id = Id;
    }
    @JsonGetter(value="kwid")
    public Long getKwid() {
        return Id;
    }

    @JsonSetter(value="kwid")
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
        return filmen;
    }

    public void setFilms(Set<Film> films) {
        this.filmen = films;
    }

    @JsonIgnore
    public void addFilm(Film film){
        film.getKijkwijzers().add(this);
        this.filmen.add(film);
    }

    @JsonIgnore
    public void removeFilm(Film film){
        film.setKijkwijzers(null);
        this.filmen.remove(film);
    }
}
