package com.burgeranteux.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

enum State {
    READY,
    IN_PROCESS,
    DELIVERED
}

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_order;
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "address")
    private String address;
    @Column(name = "state")
    private State state;
    @Column(name = "comments")
    private String comments;
    @Column(name = "users_id")
    private int users_id;


    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }
}
