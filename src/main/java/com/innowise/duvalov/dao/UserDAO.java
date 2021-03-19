package com.innowise.duvalov.dao;

import com.innowise.duvalov.model.User;

public interface UserDAO {
    void addUser(User user);

    User findUserByLogin(String login);
}
