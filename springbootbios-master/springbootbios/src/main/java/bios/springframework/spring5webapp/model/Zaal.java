package bios.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mk on 21/10/18.
 */
@Entity
public class Zaal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String zaalNummer;


    @ManyToMany(mappedBy = "zalen")
    private Set<Film> films = new HashSet<>();

    public Zaal() {
    }

    public Zaal(String zaalNummer) {
        this.zaalNummer = zaalNummer;
    }

    public Zaal(String zaalNummmer,  Set<Film> films) {
        this.zaalNummer = zaalNummmer;
        this.films = films;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getzaalNummer() {
        return zaalNummer;
    }

    public void setzaalNummer(String zaalNummer) {
        this.zaalNummer = zaalNummer;
    }


    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zaal zaal = (Zaal) o;

        return id != null ? id.equals(zaal.id) : zaal.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Zaal{" +
                "id=" + id +
                ", zaalNummer='" + zaalNummer + '\'' +
                ", films=" + films +
                '}';
    }
}
      