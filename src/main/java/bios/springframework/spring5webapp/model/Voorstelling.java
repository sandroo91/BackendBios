package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.HashSet;



@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
@Table(name = "Voorstelling")
public class Voorstelling {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="dag",nullable=false)
    private LocalDate dag;

    @Column(name="tijd",nullable=false)
    private LocalTime tijd;

//    @JsonBackReference(value="v_film")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "filmid")
    private Film film;

//    @JsonBackReference
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "zaalid")
    private Zaal zalen;

    public Voorstelling() {
    }

    public Voorstelling(LocalDate dag, LocalTime tijd) {
        this.dag = dag;
        this.tijd = tijd;
    }

    @JsonGetter(value = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


//    @JsonGetter(value = "titel")
    public Film getFilms() {
        return film;
    }

    @JsonProperty(value="film")
    public void setFilms(Film film) {
        this.film = film;
    }

//    @JsonGetter(value = "zaalNummer")
    public Zaal getZalen() {
        return zalen;
    }

    @JsonProperty(value="zalen")
    public void setZalen(Zaal zalen) {
        this.zalen = zalen;
    }

    public LocalDate getDag() {
        return dag;
    }

    public void setDag(LocalDate dag) {
        this.dag = dag;
    }

    public LocalTime getTijd() {
        return tijd;
    }

    public void setTijd(LocalTime tijd) {
        this.tijd = tijd;
    }

    //    public  double getKaartPrijs(Long id) {
//
//        if ((this.films.isIMAX()== true ) && (this.zalen.isIMAXZaal()) == true ){
//            prijs ++;
//        }
//        if ((this.films.isDDD()== true) && (this.zalen.isDrieDZaal() == true )){
//            prijs ++;
//        }
//        if (this.films.isExtralang() == true){
//            prijs ++;
//        }
//        return prijs;
//    }
}




