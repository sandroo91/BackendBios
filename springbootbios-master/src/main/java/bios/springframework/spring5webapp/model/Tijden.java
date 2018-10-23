package bios.springframework.spring5webapp.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by mk on 21/10/18.
 */
@Entity
public class Tijden {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String begintijd;


    @ManyToMany(mappedBy = "tijden")
    private Set<Film> films = new HashSet<>();

    public Tijden() {
    }

    public Tijden(String begintijd) {
        this.begintijd = begintijd;
    }

    public Tijden(String begintijd,  Set<Film> films) {
        this.begintijd = begintijd;
        this.films = films;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBegintijd() {
        return begintijd;
    }

    public void setBegintijd(String begintijd) {
        this.begintijd = begintijd;
    }


    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tijden tijd = (Tijden) o;

        return id != null ? id.equals(tijd.id) : tijd.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Tijden{" +
                "id=" + id +
                ", begintijd='" + begintijd + '\'' +
                ", films=" + films +
                '}';
    }
}



