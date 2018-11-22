package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "Kijkwijzer")
public class Kijkwijzer {

    @Id
    @Column(name = "kwid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long kwid;

    @Column(name="tekst")
    private String tekst;

    @Column(name="symbool")
    private String symbool;

    @ManyToMany(cascade = CascadeType.ALL, targetEntity= Film.class)
    private Set<Film> filmSet = new HashSet<>();

    public Kijkwijzer() {
    }

    public Long getKwid() {
        return kwid;
    }

    public void setKwid(Long kwid) {
        this.kwid = kwid;
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

    public Set<Film> getFilmSet() {
        return filmSet;
    }

    public void setFilmSet(Set<Film> filmSet) {
        this.filmSet = filmSet;
    }
}
