package com.example.HeartVerse.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Users") //without this, hibernate creates table "user", if i want "users" instead, i gotta use @Table
public class User {
    @Id //this id field is a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Planet> planets;



    private String name;
    private String email;
    private String password;

    public User(){

    }
    public Long getId() {
        return id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
