package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "filmid")
    private Film films;


    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "zaalid")
    private Zaal zalen;

    @JsonIgnore
    @OneToMany(mappedBy = "voorstellingen", cascade = CascadeType.ALL,orphanRemoval = true, targetEntity = Reservering.class)
    private Set<Reservering> reserveringen = new HashSet<>();

    public Voorstelling() {
    }

    public Voorstelling(Long id) {
        this.id = id;
    }

    @JsonGetter(value = "id")
    public Long getId() {
        return id;
    }

    @JsonProperty
    public void setId(Long id) {
        this.id = id;
    }

    public Film getFilms() {
        return films;
    }

    public void setFilms(Film film) {
        this.films = film;
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

    public void addReservering(Reservering reservering){
        reservering.setVoorstellingen(this);
        this.reserveringen.add(reservering);
    }

    public void removeReservering(Reservering reservering){
        reservering.setVoorstellingen(null);
        this.reserveringen.remove(reservering);
    }

//        public  double getKaartPrijs(Long id) {
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




