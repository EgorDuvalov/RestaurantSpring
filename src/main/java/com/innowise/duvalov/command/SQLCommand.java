package com.innowise.duvalov.command;

import lombok.Getter;

public enum SQLCommand {
    ADD_USER("INSERT INTO user (login, password, email, role) VALUES (?,?,?,?)"),
    FIND_USER_BY_LOGIN("SELECT * FROM user WHERE login = (?)"),
    TAKE_ALL_USERS("SELECT * FROM user"),

    ADD_MEAL("INSERT INTO meal (name,price) VALUES (?,?)"),
    FIND_MEAL_BY_NAME("SELECT * FROM meal WHERE name=(?)"),
    TAKE_ALL_MEALS("SELECT * FROM meal");


    @Getter
    String command;

    SQLCommand(String command) {
        this.command = command;
    }
}
