package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name= "Zalen")
public class Zaal {

    @Id
    @Column(name= "id",nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "Zaalnummer",nullable=false)
    private Integer zaalNummer;

    @Column(name= "aantalStoelen")
    private Long aantalStoelen;

    @Column(name="imaxZaal")
    private boolean imaxZaal;

    @Column(name="drieDZaal")
    private boolean drieDZaal;


    @OneToMany(mappedBy = "zalen", cascade = CascadeType.MERGE)
    @JsonManagedReference(value = "zalen")
    private Set<Voorstelling>voorstellingen = new HashSet<>();

    public Zaal(){
    }

    public Zaal(Long id) {
        this.id = id;
    }

    @JsonGetter(value= "id")
    public Long getZaalId() {
        return id;
    }

//    @JsonSetter(value = "id")
    public void setZaalId(Long id) {
        this.id = id;
    }

    public Integer getZaalNummer() {
        return zaalNummer;
    }

    public void setzaalNummer(Integer zaalNummer) {
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
