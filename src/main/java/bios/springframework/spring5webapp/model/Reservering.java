package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Reservering")
public class Reservering {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long Id;

    @Version
    private int version;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "rid")
    @JsonIgnoreProperties(value = "reserveringen")
    private Voorstelling voorstelling;

    @Column(name= "email",nullable=false)
    private String emailAdres;

    @Column(name = "aantalKaartjes", nullable=false)
    private int aantalKaartjes;


    public Reservering() {
    }

    public Reservering(Long Id){
        this.Id=Id;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Voorstelling getVoorstelling() {
        return voorstelling;
    }

    public void setVoorstelling(Voorstelling voorstelling) {
        this.voorstelling = voorstelling;
    }

    public String getEmailAdres(){
        return emailAdres;
    }

    public void setEmailAdres(String emailAdres){
        this.emailAdres = emailAdres;
    }

    public int getAantalKaartjes() {
        return aantalKaartjes;
    }

    public void setAantalKaartjes(int aantalKaartjes) {
        this.aantalKaartjes = aantalKaartjes;
    }
}




