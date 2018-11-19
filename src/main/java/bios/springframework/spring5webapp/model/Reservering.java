package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Reservering")
public class Reservering {

    @Id
    @Column(name = "reserveringid")
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long reserveringNummer;

    @Version
    private int version;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "reserveringid", referencedColumnName = "id", insertable = false, updatable = false)
    private Voorstelling voorstellingen;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "stoelid")
    private Stoel stoelen;

    @Column(name= "email",nullable=false)
    private String emailAdres;

    @Autowired
    public Reservering() {
    }

    public Long getId() {
        return reserveringNummer;
    }

    @JsonIgnore
    public void setId(Long id) {
        this.reserveringNummer = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Voorstelling getVoorstellingen() {
        return voorstellingen;
    }

    public void setVoorstellingen(Voorstelling voorstellingen) {
        this.voorstellingen = voorstellingen;
    }

    public Stoel getStoelen() {
        return stoelen;
    }

    public void setStoelen(Stoel stoelen) {
        this.stoelen = stoelen;
    }

    public String getEmailAdres(){
        return emailAdres;
    }

    public void setEmailAdres(String emailAdres){
        this.emailAdres = emailAdres;
    }

}




