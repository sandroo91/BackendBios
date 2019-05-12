package wecare.springframework.spring5webapp.model;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity
@Table(name= "Premie")
public class Premie {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "dekkingverzekering", unique = true,nullable=false)
    private String dekking;

    @Column(name= "premie", length = 3000)
    private Integer premie;


    public Premie() {
    }

    public Premie(Long id) {
        this.id = id;
    }

    public Premie(String dekking) {
        this.dekking = dekking;
    }



    @JsonGetter(value="id")
    public Long getpremieId() {
        return id;
    }

    //    @JsonSetter(value="id")
    public void setPremieId(Long id) {
        this.id = id;
    }


    public String getDekking() {
        return dekking;
    }

    public void setDekking(String dekking) {
        this.dekking = dekking;
    }

    public Integer getPremie() {
        return premie;
    }

    public void setPremie(Integer premie){
        this.premie = premie;
    }

}

