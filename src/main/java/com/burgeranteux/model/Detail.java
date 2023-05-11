package com.burgeranteux.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "details")
public class Detail {

    @Id
    private int orders_id;
    private int products_id;
    private String id_detail;
    private int quantity;


}
