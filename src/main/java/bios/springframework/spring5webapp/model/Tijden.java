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
@Table(name= "Tijden")
public class Tijden {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "begintijden")
    private String begintijd;

    public Tijden(){

    }

    public Tijden(String begintijd) {
        this.begintijd = begintijd;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonGetter(value = "Tijd")
    public String getBegintijd() {
        return begintijd;
    }

    public void setBegintijd(String begintijd) {
        this.begintijd = begintijd;
    }
}



