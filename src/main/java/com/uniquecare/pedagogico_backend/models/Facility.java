package com.uniquecare.pedagogico_backend.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int pricePerHour;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "facility")
    //@JsonIgnoreProperties("facility")
    private Set <Contract> contract;

    public Facility() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Contract> getContract() {
        return contract;
    }

    public void setContract(Set<Contract> contract) {
        this.contract = contract;
    }

    public Facility(Long id, String title, String description, int pricePerHour, User user, Set<Contract> contract) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pricePerHour = pricePerHour;
        this.user = user;
        this.contract = contract;
    }

    public Facility(Long id, String title, String description, int pricePerHour) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pricePerHour = pricePerHour;
    }

    public Facility(Long id, User user, Set<Contract> contract) {
        this.id = id;
        this.user = user;
        this.contract = contract;
    }

    public Facility(Long id, Set<Contract> contract) {
        this.id = id;
        this.contract = contract;
    }


    public void add(Facility facility) {
        this.contract = contract;
    }

    public void remove(Facility facility) {
        this.contract = contract;
    }
}
