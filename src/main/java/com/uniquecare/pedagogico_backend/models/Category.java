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
    private Set<Facilit> facilities= new HashSet<>();
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
   public Set<Facilit> getFacilities(){
        return facilities;
   }
   public void setFacilities(Set<Facilit> facilities){
        this.facilities=facilities;
        for(Facilit facilit:facilities){
            facilit.setCategory(this);
        }
   }


}
