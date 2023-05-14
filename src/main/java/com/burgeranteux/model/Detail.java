package com.burgeranteux.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "DETAILS")
public class Detail {

    @Id
    @Column(name = "orders_id")
    private int orders_id;
    @Column(name = "products_id")
    private int products_id;
    @Column(name = "quantity")
    private int quantity;

    public Detail() {

    }

    public Detail(int orders_id, int products_id, int quantity) {
        this.orders_id = orders_id;
        this.products_id = products_id;
        this.quantity = quantity;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public int getProducts_id() {
        return products_id;
    }

    public void setProducts_id(int products_id) {
        this.products_id = products_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
