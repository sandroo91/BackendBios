package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by mk on 21/10/18.
 */
@Entity
@Table(name= "Film")
public class Film {

    @Id
    @Column(name= "filmid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long filmid;

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

    @ManyToMany(cascade=CascadeType.ALL, targetEntity= Kijkwijzer.class)
    @JoinTable(name="kijkwijzerregel",
            joinColumns = {@JoinColumn(name = "filmid")},
                    inverseJoinColumns={ @JoinColumn(name = "kwid") } )
    Set<Kijkwijzer>kijkwijzers= new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private Set<Voorstelling>voorstellingen = new HashSet<>();

    public Film() {

    }

    @JsonGetter(value="filmid")
    public Long getId() {
        return filmid;
    }

    public void setId(Long id) {
        this.filmid = id;
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




