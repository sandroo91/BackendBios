package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;



@Entity
@Table(name = "Voorstelling")
public class Voorstelling {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="dag",nullable=false)
    private LocalDate dag;

    @Column(name="tijd",nullable=false)
    private LocalTime tijd;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "film", foreignKey = @ForeignKey(name= "filmid"), insertable = false, updatable = false)
    private Film film;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "zalen",  foreignKey =@ForeignKey(name= "zaalid"), insertable = false, updatable = false)
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




