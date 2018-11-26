package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name= "Zalen")
public class Zaal {

    @Id
    @Column(name= "zaalid",nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long zaalid;

    @Column(name= "Zaalnummer", unique = true,nullable=false)
    private String zaalNummer;

    @Column(name= "aantalStoelen",nullable=false)
    private Long aantalStoelen;

    @Column(name="imaxZaal",nullable=false)
    private boolean imaxZaal;

    @Column(name="drieDZaal",nullable=false)
    private boolean drieDZaal;

    @JsonIgnore
    @OneToMany(mappedBy = "zalen", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Voorstelling.class)
    private Set<Voorstelling> voorstellingen = new HashSet<>();

    public Zaal() {
    }

    public Zaal(Long zaalid) {
        this.zaalid = zaalid;
    }

    @JsonGetter(value= "zaalid")
    public Long getId() {
        return zaalid;
    }

    public void setId(Long id) {
        this.zaalid = id;
    }

    public String getZaalNummer() {
        return zaalNummer;
    }

    public void setzaalNummer(String zaalNummer) {
        this.zaalNummer = zaalNummer;
    }

    public Long getAantalStoelen(){
        return aantalStoelen;
    }

    public void setAantalStoelen(Long aantalStoelen){
        this.aantalStoelen = aantalStoelen;
    }

    public boolean getimaxZaal() {
        return imaxZaal;
    }

    public void setimaxZaal(boolean MAX) {
        this.imaxZaal = MAX;
    }

    public boolean getDrieDZaal() {
        return drieDZaal;
    }

    public void setDrieDZaal(boolean drieDZaal) {
        this.drieDZaal = drieDZaal;
    }

    public Set<Voorstelling> getVoorstellingen() {
        return voorstellingen;
    }

    public void setVoorstellingen(Set<Voorstelling> voorstellingen) {
        this.voorstellingen = voorstellingen;
    }

    public void addVoorstelling(Voorstelling voorstelling){
        voorstelling.setZalen(this);
        this.voorstellingen.add(voorstelling);
    }

    public void removeVoorstelling(Voorstelling voorstelling){
        voorstelling.setZalen(null);
        this.voorstellingen.remove(voorstelling);
    }
}
