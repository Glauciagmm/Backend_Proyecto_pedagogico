package com.uniquecare.pedagogico_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Contract {
    @Id
    Long id;
    private Date start;
    private Date finish;
    private int totalPrice;

   /* @ManyToOne
    @JoinColumn(name="user_id")
    User user;*/

    @ManyToOne
    @JoinColumn (name = "facilit_id", nullable = false)
    private Facilit facilit;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Contract(){
    }

    public Contract (Long id,Date start, Date finish, User user, Facilit facilit){
        this.id = id;
        this.start  = start;
        this.finish = finish;
        this.user = user;
        this.facilit = facilit;
    }

    public Contract (Date start, Date finish, User user, Facilit facilit){
        this.start  = start;
        this.finish = finish;
        this.user = user;
        this.facilit = facilit;
    }

    public Contract (Long id, User user, Facilit facilit){
        this.id = id;
        this.user = user;
        this.facilit = facilit;
    }

    public void addContract(User user, Facilit facilit){
        user.add(user);
        facilit.add(facilit);

    }
    public void removeContract(User user, Facilit facilit) {
        user.remove(user);
        facilit.remove(facilit);
    }

    @JsonBackReference
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Facilit getFacilit(){ return facilit;}

    public void setFacilit(Facilit facilit){
        this.facilit = facilit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
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
                ", facilit=" + facilit +
                ", user=" + user +
                '}';
    }
}
