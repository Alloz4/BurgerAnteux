package com.burgeranteux.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {


    private int id_product;
    private String category;
    private String name;
    private double price;
    private String description;
    private String image;


}
