package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by mk on 21/10/18.
 */
@Entity
@Table(name = "Reserveringen")
public class Reservering {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "voorstelling_id")
    private Voorstelling voorstellingen;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "stoel_id")
    private Stoel stoelen;

    @Column(name= "email")
    private String emailAdres;

    public Reservering(){

    }

    public Reservering(Long id) {
        this.id = id;
    }

    @JsonGetter(value = "Reservering")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonGetter(value = "Voorstelling")
    public Voorstelling getVoorstellingen() {
        return voorstellingen;
    }

    public void setVoorstellingen(Voorstelling voorstellingen) {
        this.voorstellingen = voorstellingen;
    }

    @JsonGetter(value = "Stoel")
    public Stoel getStoelen() {
        return stoelen;
    }

    public void setStoelen(Stoel stoelen) {
        this.stoelen = stoelen;
    }

    @JsonGetter(value = "emailAdres")
    public String getEmailAdres(){
        return emailAdres;
    }

    public void setEmailAdres(String emailAdres){
        this.emailAdres = emailAdres;
    }

}




