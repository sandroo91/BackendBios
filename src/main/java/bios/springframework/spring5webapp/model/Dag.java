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
@Table(name= "Dagen")
public class Dag {

    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Dag(){

    }

    @Column(name= "dag")
    private String dag;

    public Dag(String dag) {
        this.dag = dag;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDag() {
        return dag;
    }

    public void setDag(String dag) {
        this.dag = dag;
    }

}




