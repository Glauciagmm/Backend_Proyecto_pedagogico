package com.uniquecare.pedagogico_backend.models;

import javax.persistence.*;
@Entity
@Table(name = "categories")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ECategory name;
    public Category() {
    }
    public Category(ECategory name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public ECategory getName() {
        return name;
    }
    public void setName(ECategory name) {
        this.name = name;
    }
}
