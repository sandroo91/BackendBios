package bios.springframework.spring5webapp.model;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.persistence.Entity;


@Entity
@Table(name= "Authorities")
public class Authority {

    @ManyToOne
    @JoinColumn(name = "username")
    @JsonIgnoreProperties(value = "authorities")
    private User user;

    @Id
    @Column(name= "authority")
    private String authority;


    public Authority(){
    }

    public String getAuthority(){
        return authority;
    }

    public void setAuthority() { this.authority = authority;}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}






