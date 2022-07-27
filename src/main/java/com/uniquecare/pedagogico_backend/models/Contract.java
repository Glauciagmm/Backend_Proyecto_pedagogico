package com.uniquecare.pedagogico_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Contract {
    @Id
    Long id;
    private LocalDateTime start;
    private LocalDateTime finish;
    private int totalPrice;

   /* @ManyToOne
    @JoinColumn(name="user_id")
    User user;*/

    @ManyToOne
    //@JsonIgnoreProperties("contract")

    @JoinColumn (name = "facility_id", referencedColumnName = "id", nullable = false)
    private Facility facility;

    @ManyToOne(cascade = CascadeType.ALL)
    //@JsonIgnoreProperties("contract")
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    public Contract(){
    }

    public void Contract (Long id, LocalDateTime start, LocalDateTime finish, Facility facility, int totalPrice){
        this.id = id;
        this.start  = start;
        this.finish = finish;
        //this.user = user;
        this.facility = facility;
        this.totalPrice = totalPrice;
    }

    /*public Contract (LocalDateTime start, LocalDateTime finish, User user, Facilit facilit){
        this.start  = start;
        this.finish = finish;
        this.user = user;
        this.facilit = facilit;
    }*/

  /*  public Contract (Long id, User user, Facilit facilit){
        this.id = id;
        this.user = user;
        this.facilit = facilit;
    }

    public void addContract(User user, Facilit facilit, LocalDateTime start, LocalDateTime finish){
        this.user(user);
        this.facilit(facilit);
        this.start(start);
        this.finish(finish);
    }*/
/*    public void removeContract(User user, Facilit facilit, LocalDateTime start, LocalDateTime finish) {
        user.remove(user);
        facilit.remove(facilit);
    }*/

    @JsonBackReference
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Facility getFacilit(){ return facility;}

    public void setFacilit(Facility facility){

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
                ", user=" + user +
                '}';
    }
}
