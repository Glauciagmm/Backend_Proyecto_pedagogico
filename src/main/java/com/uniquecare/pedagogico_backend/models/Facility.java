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

  @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "facility_categories",
            joinColumns = { @JoinColumn(name = "facility_id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id") })
  @JsonIgnoreProperties({"categories"})
  private Set<Category> categories = new HashSet<>();
  public Facility(){

  }
@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "assistant_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"facility", "roles"})
    private User assistant;


    @OneToMany(mappedBy = "facility")
    @JsonIgnore
    private Set<Contract> contract = new HashSet<>();

    public Facility(String title, String description, int pricePerHour, User assistant, Set<Category> categories, User facilityAssistant) {

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





    public User getAssistant() {
        return assistant;
    }

    public User setAssistant(User assistant) {
        return  this.assistant = assistant;

    }

    public Set<Contract> getContract() {
        return contract;
    }

    public void setContract(Set<Contract> contract) {
        this.contract = contract;
    }

    public Facility(String title, String description, int pricePerHour, User assistant,Set<Category> categories) {
        this.title = title;
        this.description = description;
        this.pricePerHour = pricePerHour;
        this.categories= categories;
        this.assistant = assistant;

    }
    public void addCategory(Category category) {
        this.categories.add(category);
        category.getFacilities().add(this);
    }

    public void removeCategory(long categoryId) {
        Category category = this.categories.stream().filter(t -> t.getId() == categoryId).findFirst().orElse(null);
        if (category != null) {
            this.categories.remove(category);
            category.getFacilities().remove(this);
        }
    }


    public Facility(String title, String description, int pricePerHour, User assistant) {
        this.title = title;
        this.description = description;
        this.pricePerHour = pricePerHour;
        this.assistant = assistant;
    }

    public Facility(Long id) {
        this.id = id;
    }

     public void remove(Facility facility) {
        this.contract = contract;
    }


    public void getUser(UserDetailsImpl loggedInUser) {
    }

    public void add(Facility contract) {

    }
}
