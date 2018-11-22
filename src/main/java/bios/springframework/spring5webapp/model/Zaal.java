package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name= "Zalen")
public class Zaal {

    @Id
    @Column(name= "zaalid",nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long zaalid;

    @Column(name= "Zaalnummer", unique = true,nullable=false)
    private int zaalNummer;

    @Column(name= "aantalStoelen",nullable=false)
    private Long aantalStoelen;

    @Column(name="imaxZaal",nullable=false)
    private boolean imaxZaal;

    @Column(name="drieDZaal",nullable=false)
    private boolean drieDZaal;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private Set<Voorstelling>voorstellingen = new HashSet<>();


    public Zaal(){

    }


    @JsonGetter(value= "zaalid")
    public Long getId() {
        return zaalid;
    }

    @JsonIgnore
    public void setId(Long id) {
        this.zaalid = id;
    }

    public int getZaalNummer() {
        return zaalNummer;
    }

    public void setzaalNummer(int zaalNummer) {
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
}
