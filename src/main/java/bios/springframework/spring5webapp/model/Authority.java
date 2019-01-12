package bios.springframework.spring5webapp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.persistence.Entity;


@Entity
@Table(name= "Authorities")
public class Authority {

    @Id
    @Column(name= "authority")
    private String authority;

    @ManyToOne
    @JoinColumn(name = "username")
    @JsonIgnoreProperties(value = "authorities")
    private Users user;

    public Authority(){
    }

    public String getAuthority(){
        return authority;
    }

    public void setAuthority() { this.authority = authority;}

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

}

