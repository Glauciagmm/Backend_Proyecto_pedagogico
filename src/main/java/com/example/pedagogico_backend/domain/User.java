package com.example.pedagogico_backend.domain;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity @Data
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    @Size(max = 20)
    private String username;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String city;


    /*@ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assistant")
    private List<Advertisement> advertisements;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Contract> contract;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User(Long id, String name, String surname, String username, String email, String password, String city) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.city = city;
    }

    public User(Long id, String name, String username, String email, String city) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.city = city;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Long id) {
        this.id = id;
    }

    public User() {
    }
}
