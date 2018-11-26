package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.*;


@Entity
@Table(name= "Kijkwijzer")
public class Kijkwijzer {

    @Id
    @Column(name = "kwid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long kwid;

    @Column(name="tekst")
    private String tekst;

    @Column(name="symbool")
    private String symbool;

    public Kijkwijzer() {
    }

    @JsonGetter(value="kwid")
    public Long getKwid() {
        return kwid;
    }

    @JsonProperty
    public void setKwid(Long kwid) {
        this.kwid = kwid;
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
