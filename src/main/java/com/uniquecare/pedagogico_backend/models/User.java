package com.uniquecare.pedagogico_backend.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @NotBlank
    @Size(max = 20)
    private String username;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @NotBlank
    @Size(max = 120)
    private String password;
    private String city;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")//Generate the service
    //@JsonIgnoreProperties("user")
    private List<Facilit> facilit;

    @OneToMany
    (cascade = CascadeType.ALL, mappedBy = "user")//Client
    //@JsonIgnoreProperties("user")
    private List<Contract> contract;

    public User() {
    }


    public List<Facilit> getFacilit() {
        return facilit;
    }

    public void setFacilit(List<Facilit> facilit) {
        this.facilit = facilit;
    }

    public void setContract(List<Contract> contract) {
        this.contract = contract;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


    public User(Long id) {
        this.id = id;
    }


/*    public List <Contract> getContract() {
        return contract;
    }


    public void add(User user) {
        this.contract = contract;
    }

    public void remove(User user) {
        this.contract = contract;
    }*/


}