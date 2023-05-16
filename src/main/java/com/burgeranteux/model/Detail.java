package com.burgeranteux.model;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "details")
public class Detail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private Long detail_id;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "FK_product_id", referencedColumnName = "product_id")
    private Product product;

    public Double getImport() {
        return quantity.doubleValue() * product.getPrice();
    }


    public Detail() {

    }

    public Detail(Integer quantity, Product product) {
        super();
        this.quantity = quantity;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
