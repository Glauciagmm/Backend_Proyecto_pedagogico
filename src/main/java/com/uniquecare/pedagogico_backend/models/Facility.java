package com.uniquecare.pedagogico_backend.models;

import com.fasterxml.jackson.annotation.*;
import com.uniquecare.pedagogico_backend.security.services.UserDetailsImpl;
import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "facility",uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})

public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int pricePerHour;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(  name = "category_id", referencedColumnName = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonIgnore
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "assistant_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"facility", "roles"})
    private User assistant;


    @OneToMany(mappedBy = "facility")
    @JsonIgnore
    private Set<Contract> contract = new HashSet<>();

    public Facility() {}

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getAssistant() {
        return assistant;
    }

    public void setAssistant(User assistant) {
        this.assistant = assistant;
    }

    public Set<Contract> getContract() {
        return contract;
    }

    public void setContract(Set<Contract> contract) {
        this.contract = contract;
    }

    public Facility(String title, String description, int pricePerHour, User assistant) {
        this.title = title;
        this.description = description;
        this.pricePerHour = pricePerHour;
        this.assistant = assistant;
    }

    public void remove(Facility facility) {
        this.contract = contract;
    }


    public void getUser(UserDetailsImpl loggedInUser) {
    }

    public void add(Facility contract) {

    }
}
