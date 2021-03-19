package com.innowise.duvalov.dao.impl;

import com.innowise.duvalov.command.SQLCommand;
import com.innowise.duvalov.dao.UserDAO;
import com.innowise.duvalov.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDAOImpl implements UserDAO {

    private final String ADD_USER = SQLCommand.ADD_USER.getCommand();
    private final String FIND_USER_BY_LOGIN = SQLCommand.FIND_USER_BY_LOGIN.getCommand();

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addUser(User user) {
        jdbcTemplate.update(ADD_USER,
                user.getLogin(), user.getPass(), user.getEmail(), user.getRole());
    }

    @Override
    public User findUserByLogin(String login) {
        return jdbcTemplate
                .query(FIND_USER_BY_LOGIN, new BeanPropertyRowMapper<>(User.class), login)
                .stream().findAny().orElse(null);
    }
}
