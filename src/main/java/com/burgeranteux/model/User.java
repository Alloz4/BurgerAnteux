package com.burgeranteux.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;
    @Column(name = "user", length = 20, nullable = false)
    private String user;
    @Column(name = "password", length = 20, nullable = false)
    private String password;
    @Column(name = "name", length = 45, nullable = false)
    private String name;
    @Column(name = "email", length = 45, nullable = false)
    private String email;
    @Column(name = "phone", length = 11, nullable = false)
    private String phone;
    @Column(name = "address", length = 45, nullable = false)
    private String address;



    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
