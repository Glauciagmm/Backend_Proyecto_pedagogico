package com.uniquecare.pedagogico_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Facilit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int pricePerHour;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "facilit_categories",
            joinColumns = @JoinColumn(name = "facilit_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Role> roles = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "facilit")
    //@JsonIgnoreProperties("facilit")
    private Set <Contract> contract;

    public Facilit() {

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

    public Facilit(Long id, String title, String description, int pricePerHour, User user, Set<Contract> contract) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pricePerHour = pricePerHour;
        this.user = user;
        this.contract = contract;
    }

    public Facilit(Long id, String title, String description, int pricePerHour) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pricePerHour = pricePerHour;
    }

    public Facilit(Long id, User user, Set<Contract> contract) {
        this.id = id;
        this.user = user;
        this.contract = contract;
    }

    public Facilit(Long id, Set<Contract> contract) {
        this.id = id;
        this.contract = contract;
    }


    public void add(Facilit facilit) {
        this.contract = contract;
    }

    public void remove(Facilit facilit) {
        this.contract = contract;
    }
}
