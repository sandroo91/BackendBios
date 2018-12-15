package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Voorstelling")
public class Voorstelling {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="dag",nullable=false)
    private LocalDate dag;

    @Column(name="tijd",nullable=false)
    private LocalTime tijd;

    @ManyToOne
    @JoinColumn(name = "filmid")
    @JsonBackReference(value = "film")
    private Film film;


    @ManyToOne
    @JoinColumn(name = "zaalid")
    @JsonBackReference(value = "zalen")
    private Zaal zalen;

    @OneToMany(mappedBy = "voorstelling", cascade = CascadeType.ALL, targetEntity = Reservering.class)
    @JsonManagedReference(value = "reservering")
    private Set<Reservering> reserveringen = new HashSet<>();


    public Voorstelling() {

    }

    @JsonGetter(value = "id")
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    @JsonGetter(value = "film")
    public Film getFilms() {
        return film;
    }

    @JsonSetter(value="film")
    public void setFilms(Film film) {
        this.film = film;
    }

    @JsonGetter(value = "zalen")
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
        reservering.setVoorstelling(this);
        this.reserveringen.add(reservering);
    }

    public void removeReservering(Reservering reservering){
        reservering.setVoorstelling(null);
        this.reserveringen.remove(reservering);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voorstelling )) return false;
        return id != null && id.equals(((Voorstelling) o).id);
    }
    @Override
    public int hashCode() {
        return 31;
    }

    public String toString() {
        return "Voorstelling [id=" + id + ", dag=" + dag + ", tijd=" + tijd
                + ", film=" + film + ", zaal=" + zalen + "]";
    }
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





