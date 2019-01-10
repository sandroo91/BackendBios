package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Collection;
import javax.persistence.Entity;


@Entity
@Table(name= "Users")
public class User {

    @Id
    @Column(name= "username")
    private String userName;

    @Column(name= "Password", nullable=false)
    private String password;

//    @Column(name= "Enabled", nullable=false)
//    private boolean enabled;

    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
    @JsonIgnoreProperties(value = "user")
    private Collection<Authority> authorities;

    public User(){
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(){
        this.userName = userName;
    }

    public String getPassword(){
        return password;
    }

    public Collection<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<Authority> authorities) {
        this.authorities = authorities;
    }

    @JsonIgnore
    public void addAuthority(Authority authority){
        authority.setUser(this);
        this.authorities.add(authority);
    }

    @JsonIgnore
    public void removeAuthority(Authority authority){
        authority.setUser(null);
        this.authorities.remove(authority);
    }


}





