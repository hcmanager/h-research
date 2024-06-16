package com.hc.research.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "U_CUSTOMER")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @Column(name = "signature")
    private String signature;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "sex")
    private int sex;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private int status;

    @Column(name = "coin")
    private long point;

    @Column(name = "cash")
    private long cash;
}
