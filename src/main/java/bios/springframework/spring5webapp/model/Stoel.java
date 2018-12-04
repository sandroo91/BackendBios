package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "Stoel")
public class Stoel {

    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name= "StoelNummer", unique = true,nullable=false)
    private Long stoelNummer;

    public Stoel(){

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public Long getstoelNummer() {
        return stoelNummer;
    }

    public void setstoelNummer(Long stoelNummer) {
        this.stoelNummer = stoelNummer;
    }

}




