package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.*;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;


@Entity
@Table(name= "Film")
public class Film {

    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "titel", unique = true,nullable=false)
    private String titel;

    @Column(name= "samenvatting")
    private String samenvatting;

    @Column(name= "poster")
    private String poster;

    @Column(name="prijs")
    private double prijs;

    @Column(name = "extralang",nullable=false)
    private boolean extralang;

    @Column(name="imax",nullable=false)
    private boolean imax;

    @Column(name="DDD",nullable=false)
    private boolean DDD;

    @Column(name="datumBeschikbaar",nullable=false)
    private LocalDate datumBeschikbaar;

    @Column(name="afloopDatum",nullable=false)
    private LocalDate afloopDatum;

    @JsonIgnore
    @ManyToMany(cascade=CascadeType.ALL, targetEntity= Kijkwijzer.class)
    @JoinTable(name="kwregel",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns={ @JoinColumn(name = "kwid") } )
    Set<Kijkwijzer>kijkwijzers= new HashSet<>();


    @OneToMany(mappedBy = "film", cascade = CascadeType.MERGE)
    @JsonManagedReference(value = "film")
    private Set<Voorstelling> voorstellingen = new HashSet<>();

    public Film() {
    }

    public Film(Long id) {
        this.id = id;
    }

    public Film(String titel) {
        this.titel = titel;
    }



    @JsonGetter(value="id")
    public Long getFilmId() {
        return id;
    }

//    @JsonSetter(value="id")
    public void setFilmId(Long id) {
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

    public Set<Voorstelling> getVoorstellingen() {
        return voorstellingen;
    }

    public void setVoorstellingen(Set<Voorstelling> voorstellingen) {
        this.voorstellingen = voorstellingen;
    }

    @JsonIgnore
    public void addVoorstelling(Voorstelling voorstelling){
        voorstelling.setFilms(this);
        this.voorstellingen.add(voorstelling);
    }

    @JsonIgnore
    public void removeVoorstelling(Voorstelling voorstelling){
        voorstelling.setFilms(null);
        this.voorstellingen.remove(voorstelling);
    }
}
