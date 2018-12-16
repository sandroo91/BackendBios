package bios.springframework.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name= "Auth")
public class Auth {

    @Id
    @Column(name= "id",nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "username",nullable=false)
    private String userName;

    @Column(name= "password",nullable=false)
    private String passWord;


    public Auth(){
    }

    public Auth(Long id) {
        this.id = id;
    }

    @JsonGetter(value= "id")
    public Long getAuthId() {
        return id;
    }

//    @JsonSetter(value = "id")
    public void setAuthId(Long id) {
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



}
