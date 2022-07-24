package com.uniquecare.pedagogico_backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
@Data
@Table(name = "facilities",uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})


public class Facilit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int pricePerHour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(  name = "category_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Category category;

//    @ManyToOne
//    @JoinColumn(name="category_id", nullable=false)
//    private Category category;




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

 /*
    public Category getCategories() {
        return category;
    }

  public void addCategory(Category category) {
        this.category.add(category);
        category.getFacilities().add(this);
    }*/

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public Facilit(Long id, String title, String description, int pricePerHour, User user,   Set<Contract> contract) {
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
