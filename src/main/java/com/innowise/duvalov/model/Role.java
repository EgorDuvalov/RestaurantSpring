package com.innowise.duvalov.model;

public enum Role {
    USER(0),
    ADMIN(1);

    private final int roleId;

    Role(int roleId) {
        this.roleId = roleId;
    }
}
