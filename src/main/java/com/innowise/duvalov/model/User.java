package com.innowise.duvalov.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String login;
    private String pass;
    private String email;
    private int role;


    //    public User(Long id, String login, String pass, String email, int role) {
//        this.id = id;
//        this.login = login;
//        this.pass = pass;
//        this.email = email;
//        this.role = (role == 0) ? Role.USER : Role.ADMIN;
//    }
}
