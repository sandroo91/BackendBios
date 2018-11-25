package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name= "Zalen")
public class Zaal {

    @Id
    @Column(name= "id",nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name= "Zaalnummer",nullable=false)
    private String zaalNummer;

    @Column(name= "aantalStoelen")
    private Long aantalStoelen;

    @Column(name="imaxZaal")
    private boolean imaxZaal;

    @Column(name="drieDZaal")
    private boolean drieDZaal;

//    @JsonManagedReference
    @OneToMany(mappedBy = "zalen", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Voorstelling>voorstellingen = new HashSet<>();

    public Zaal(){
    }


    public Zaal(String zaalNummer) {
        this.zaalNummer = zaalNummer;
    }

    
    @JsonGetter(value= "id")
    public Long getId() {
        return id;
    }

    @JsonSetter(value = "id")
    public void setId(Long id) {
        this.id = id;
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

    @JsonIgnore
    public Set<Voorstelling> getVoorstellingen() {
        return voorstellingen;
    }

    @JsonIgnore
    public void setVoorstellingen(Set<Voorstelling> voorstellingen) {
        this.voorstellingen = voorstellingen;
    }
}
