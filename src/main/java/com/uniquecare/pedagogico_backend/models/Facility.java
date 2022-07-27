package com.uniquecare.pedagogico_backend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.uniquecare.pedagogico_backend.security.services.UserDetailsImpl;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;


@Entity
@Data
@Table(name = "facilities",uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})


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
    private Category category;


//    @ManyToOne
//    @JoinColumn(name="category_id", nullable=false)
//    private Category category;


 @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;
    private UserDetailsImpl userDetails;






    @OneToMany(mappedBy = "facility")
    //@JsonIgnoreProperties("facility")
    private Set <Contract> contract;

    public Facility(long l) {

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser(User user) {
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

    public Facility(Long id, String title, String description, int pricePerHour, Category category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pricePerHour = pricePerHour;
        this.category = category;
    }

    public void add(Facility facility) {
        this.contract = contract;
    }

    public void remove(Facility facility) {
        this.contract = contract;
    }


    public void getUser(UserDetailsImpl loggedInUser) {
    }
}
