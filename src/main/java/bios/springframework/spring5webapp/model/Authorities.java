package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "Authorities")
public class Authorities {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name= "username",nullable=false, insertable = false, updatable = false)
    private String userName;

    @Column(name= "authority",nullable=false)
    private String authority;

    @ManyToOne
    @JoinColumn(name = "usersid")
    @JsonIgnoreProperties(value = "authorities")
    private Users users;

    public Authorities(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
