package com.uniquecare.pedagogico_backend.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;
    @OneToMany(mappedBy ="category", cascade = CascadeType.ALL)
    private Set<Facility> facility= new HashSet<>();
/*  public Category() {
    }
   @Enumerated(EnumType.STRING)
    @Column(length = 20)
   private ECategory name;


    public Category(ECategory name) {
        this.name = name;
   }*/
    public Long getId() {
        return this.id;
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

    /*   public ECategory getName() {
           return name;
       }
        public void setName(ECategory name) {
           this.name = name;
       }*/
   public Set<Facility> getFacility(){
        return facility;
   }
   public void setFacility(Set<Facility> facility){
        this.facility=facility;
        for(Facility facilit :facility){
            facilit.setCategory(this);
        }
   }


}
