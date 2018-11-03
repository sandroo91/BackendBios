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
@Table(name= "Stoelen")
public class Stoel {

    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Stoel(){

    }

    @Column(name= "StoelNummer")
    private Long stoelNummer;

    public Stoel(Long stoelNummer) {
        this.stoelNummer = stoelNummer;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getstoelNummer() {
        return stoelNummer;
    }

    public void setstoelNummer(Long stoelNummer) {
        this.stoelNummer = stoelNummer;
    }

}




