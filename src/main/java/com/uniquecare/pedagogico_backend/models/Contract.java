package com.uniquecare.pedagogico_backend.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Contract {
    @Id
    Long id;
    private LocalDateTime start;
    private LocalDateTime finish;
    private int totalPrice;

    @ManyToOne
    @JoinColumn (name = "facility_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties({"contract"})
    private Facility facility;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties({"contract", "facility", "roles"})
    private User client;

    public Contract(){
    }

    public void Contract (Long id, LocalDateTime start, LocalDateTime finish, Facility facility, int totalPrice, User client){
        this.id = id;
        this.start  = start;
        this.finish = finish;
        this.client = client;
        this.facility = facility;
        this.totalPrice = totalPrice;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Facility getFacility(){ return facility;}

    public void setFacility(Facility facility){

        this.facility = facility;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }


    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", start=" + start +
                ", finish=" + finish +
                ", totalPrice=" + totalPrice +
                ", facility=" + facility +
                ", client=" + client +
                '}';
    }

    public void add(Contract contract) {
    }
}