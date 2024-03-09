package com.task.app.demo.repositories.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "users")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "contra")
    private String password;

    @Column(name = "fecha_registro")
    private LocalDate registerDate;

    @Column(name = "telefono")
    private String phone;

    public UserEntity() {
    }

    public UserEntity(Long id, String name, String email, String password, LocalDate registerDate, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.registerDate = registerDate;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
