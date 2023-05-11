package com.burgeranteux.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {


    private int id_order;
    private String date;

}
