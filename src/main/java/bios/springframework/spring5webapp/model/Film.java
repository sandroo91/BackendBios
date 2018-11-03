package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by mk on 21/10/18.
 */
@Entity
@Table(name= "Films")
public class Film {

    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Film(){

    }

    @Column(name= "titel")
    private String title;

    @Column(name= "samenvatting")
    private String samenvatting;

    @Column(name= "poster")
    private String poster;

    @Column(name = "leeftijdscategorie")
    private String leeftijdscategorie;

    @Column(name = "extralang")
    private boolean extralang;

    @Column(name="IMAX")
    private boolean IMAX;

    @Column(name="DDD")
    private boolean DDD;

    public Film(String title, String samenvatting/*, String poster, String leeftijdscategorie, boolean extralang, boolean IMAX, boolean DDD*/) {
        this.title = title;
        this.samenvatting = samenvatting;
        /*this.poster = poster;
        this.leeftijdscategorie = leeftijdscategorie;
        this.extralang = extralang;
        this.IMAX = IMAX;
        this.DDD = DDD; */

    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLeeftijdscategorie() { return  leeftijdscategorie; }

    public void setLeeftijdscategorie(String leeftijdscategorie) {
        this.leeftijdscategorie = leeftijdscategorie;
    }

    public boolean isExtralang(){
        return extralang;
    }

    public void setExtralang(boolean extralang) {
        this.extralang = extralang;
    }

    public boolean isIMAX() {
        return IMAX;
    }

    public void setIMAX(boolean IMAX) {
        this.IMAX = IMAX;
    }

    public boolean isDDD(){
        return DDD;
    }

    public void setDDD(boolean DDD){
        this.DDD = DDD;
    }




}




