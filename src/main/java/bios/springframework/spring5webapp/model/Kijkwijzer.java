package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.Entity;
import javax.persistence.*;


@Entity
@Table(name= "Kijkwijzer")
public class Kijkwijzer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="tekst")
    private String tekst;

    @Column(name="symbool", length = 3000)
    private String symbool;

    public Kijkwijzer() {
    }

    @JsonGetter(value="kwid")
    public Long getKwid() {
        return Id;
    }

    @JsonSetter(value="kwid")
    public void setKwid(Long kwid) {
        this.Id = kwid;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String getSymbool() {
        return symbool;
    }

    public void setSymbool(String symbool) {
        this.symbool = symbool;
    }

}
