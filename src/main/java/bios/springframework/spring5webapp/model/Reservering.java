package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference(value = "reservering")
    @JoinColumn(name = "rid")
    private Voorstelling voorstelling;

    @Column(name= "email",nullable=false)
    private String emailAdres;


    public Reservering() {
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

}




