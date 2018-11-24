package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.HashSet;



@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
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

    @JsonBackReference(value="v_film")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "filmid", foreignKey = @ForeignKey(name= "filmid_FK"), insertable = false, updatable = false)
    private Film film;

    @JsonBackReference(value="v_zaal")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "zaalid",  foreignKey =@ForeignKey(name= "zaalid_FK"), insertable = false, updatable = false)
    private Zaal zalen;

    public Voorstelling() {
    }

    @JsonGetter(value = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Film getFilms() {
        return film;
    }

    public void setFilms(Film film) {
        this.film = film;
    }

    public Zaal getZalen() {
        return zalen;
    }

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




