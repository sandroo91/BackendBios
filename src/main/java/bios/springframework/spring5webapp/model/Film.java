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
    private String title;

    @Column(name= "samenvatting")
    private String samenvatting;

    @Column(name= "poster")
    private String poster;

    @Column(name = "kijkwijzer",nullable=false)
    private String kijkwijzer;

    @Column(name="prijs",nullable=false)
    private double prijs;

    @Column(name = "extralang",nullable=false)
    private int extralang;

    @Column(name="IMAX",nullable=false)
    private int IMAX;

    @Column(name="DDD",nullable=false)
    private int DDD;

    @Column(name="datumBeschikbaar",nullable=false)
    private LocalDate datumBeschikbaar;

    @Column(name="afloopDatum",nullable=false)
    private LocalDate afloopDatum;
    public Film() {

    }

    @JsonIgnore
    public Long getId() {
        return filmid;
    }

    public void setId(Long id) {
        this.filmid = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getKijkwijzer() { return  kijkwijzer; }

    public void setKijkwijzer(String kijkwijzer) {
        this.kijkwijzer = kijkwijzer;
    }

    public int getExtralang(){
        return extralang;
    }

    public void setExtralang(int extralang) {
        this.extralang = extralang;
    }

    public int getIMAX() {
        return IMAX;
    }

    public void setIMAX(int IMAX) {
        this.IMAX = IMAX;
    }

    public int isDDD(){
        return DDD;
    }

    public void setDDD(int DDD){
        this.DDD = DDD;
    }




}




