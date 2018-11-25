package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by mk on 21/10/18.
 */
@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="filmid")
@Table(name= "Film")
public class Film {

    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name= "titel",nullable=false)
    private String titel;

    @Column(name= "samenvatting")
    private String samenvatting;

    @Column(name= "poster")
    private String poster;

    @Column(name="prijs")
    private double prijs;

    @Column(name = "extralang")
    private boolean extralang;

    @Column(name="imax")
    private boolean imax;

    @Column(name="DDD")
    private boolean DDD;

    @Column(name="datumBeschikbaar")
    private LocalDate datumBeschikbaar;

    @Column(name="afloopDatum")
    private LocalDate afloopDatum;

//    @JsonManagedReference(value="f_kw")
    @ManyToMany(cascade=CascadeType.ALL, targetEntity= Kijkwijzer.class)
    @JoinTable(name="kwregel",
            joinColumns = {@JoinColumn(name = "filmid")},
            inverseJoinColumns={ @JoinColumn(name = "kwid") } )
    Set<Kijkwijzer>kijkwijzers= new HashSet<>();

//    @JsonManagedReference(value="f_vrst")
    @OneToMany(mappedBy = "film", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Voorstelling>voorstellingen = new HashSet<>();

    public Film() {
    }


    public Film(String titel) {
        this.titel = titel;
    }

    @JsonGetter(value="id")
    public Long getId() {
        return id;
    }

    @JsonSetter(value = "id")
    public void setId(Long id) {
        this.id = id;
    }


    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getSamenvatting() {
        return samenvatting;
    }

    public void setSamenvatting(String samenvatting) {
        this.samenvatting = samenvatting;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster){
        this.poster = poster;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public LocalDate getDatumBeschikbaar() {
        return datumBeschikbaar;
    }

    public void setDatumBeschikbaar(LocalDate datumBeschikbaar) {
        this.datumBeschikbaar = datumBeschikbaar;
    }

    public LocalDate getAfloopDatum() {
        return afloopDatum;
    }

    public void setAfloopDatum(LocalDate afloopDatum) {
        this.afloopDatum = afloopDatum;
    }

    public boolean getExtralang(){
        return extralang;
    }

    public void setExtralang(boolean extralang) {
        this.extralang = extralang;
    }

    public boolean getimax() {
        return imax;
    }

    public void setimax(boolean IMAX) {
        this.imax = IMAX;
    }

    public boolean getDDD(){
        return DDD;
    }

    public void setDDD(boolean DDD){
        this.DDD = DDD;
    }

    public Set<Kijkwijzer> getKijkwijzers() {
        return kijkwijzers;
    }

    public void setKijkwijzers(Set<Kijkwijzer> kijkwijzers) {
        this.kijkwijzers = kijkwijzers;
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
