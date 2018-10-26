package bios.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by mk on 21/10/18.
 */
@Entity
@Table(name = "Voorstellingen")
public class Voorstelling {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film films;

    @ManyToOne
    @JoinColumn(name = "zaal_id")
    private Zaal zalen;

    @ManyToOne
    @JoinColumn(name = "tijden_id")
    private Tijden begintijden;

    public Voorstelling(){

    }

    public Voorstelling(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Film getFilms() {
        return films;
    }

    public void setFilms(Film films) {
        this.films = films;
    }

    public Zaal getZalen() {
        return zalen;
    }

    public void setZalen(Zaal zalen) {
        this.zalen = zalen;
    }

    public Tijden getBegintijden() {
        return begintijden;
    }

    public void setBegintijden(Tijden begintijden) {
        this.begintijden = begintijden;
    }

}



