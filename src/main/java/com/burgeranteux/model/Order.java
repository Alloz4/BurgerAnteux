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
    private long id_order;
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "address")
    private String address;
    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private State state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_order_id")
    private List<Detail> details;

    @PrePersist
    public void setDate() {
        this.date = LocalDateTime.now();
    }

    public Double getTotal() {
        Double total = 0.00;
        for (Detail detail : details) {
            total += detail.getImport();
        }
        return total;
    }

    public long getOrder_id() {
        return order_id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDateTime getDate() {
        return date;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }
}
