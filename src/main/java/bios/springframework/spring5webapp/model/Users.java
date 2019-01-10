package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name= "Users")
public class Users {


    @Id
    @Column(name = "usersid")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name= "username",nullable=false)
    private String userName;

    @Column(name= "password",nullable=false)
    private String passWord;

    @Column(name= "Enabled", nullable=false)
    private Boolean enabled;

    @OneToMany(mappedBy = "users", cascade = CascadeType.MERGE)
    @JsonIgnoreProperties(value = "users")
    private Set<Authorities> authorities = new HashSet<>();

    public Users(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() { return userName;
    }

    public void setUserName(String userName) { this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authorities> authorities) {
        this.authorities = authorities;
    }
}
