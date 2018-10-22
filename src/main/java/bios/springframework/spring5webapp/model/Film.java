package bios.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mk on 21/10/18.
 */
@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @ManyToMany
    @JoinTable(name = "zaal_film", joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "zaal_id"))
    private Set<Zaal> zalen = new HashSet<>();

    public Film() {
    }

    public Film(String title) {
        this.title = title;
    }

    public Film(String title, Set<Zaal> zalen) {
        this.title = title;
        this.zalen = zalen;
    }


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


    public Set<Zaal> getZalen() {
        return zalen;
    }

    public void setZalen(Set<Zaal> zalen) {
        this.zalen = zalen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        return id != null ? id.equals(film.id) : film.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", zalen=" + zalen +
                '}';
    }
}



