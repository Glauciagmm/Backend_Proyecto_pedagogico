package com.uniquecare.pedagogico_backend.models;

import com.fasterxml.jackson.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
    @JsonIgnore
    private String password;
    private String city;
    private String phone;
    private String photo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    /*
        Relation User <-> Facility
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assistant")//Generate the service
    // @JsonIgnoreProperties("user")
    @JsonIgnore
    private List<Facility> facility;

    @OneToMany(mappedBy = "client")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIgnoreProperties("client")
    private Set<Contract> contract = new HashSet<>();



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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Facility> getFacility() {
        return facility;
    }

    public void setFacility(List<Facility> facility) {
        this.facility = facility;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Set<Contract> getContract() {
        return contract;
    }

    public void setContract(Set<Contract> contract) {
        this.contract = contract;
    }

    public User() {}

    public User(String name, String surname, String username, String email, String city, String phone, String photo, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.city = city;
        this.phone = phone;
        this.photo = photo;
        this.password = password;
        this.roles = roles;
    }

    public User(Long id, String name, String surname, String username, String email, String password, String city, String phone, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.city = city;
        this.phone = phone;
        this.roles = roles;
    }

    public User(Long id, List<Facility> facility) {
        this.id = id;
        this.facility = facility;
    }

    public User(Long id, String name, String surname, String username, String email, String city, String phone, String photo) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.city = city;
        this.phone = phone;
        this.photo = photo;
    }

    void addRole(Role role) {
        this.roles.add(role);
    }

    public boolean sendRequest(Facility facility) {
        return contract.contains(facility);
    }


    /*public void addContract(Facility facility) {
        return facility.add(contract);
    }*/
}