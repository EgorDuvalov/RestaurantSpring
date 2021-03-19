package com.innowise.duvalov.dao.impl;

import com.innowise.duvalov.command.SQLCommand;
import com.innowise.duvalov.dao.MealDAO;
import com.innowise.duvalov.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuDAOImpl implements MealDAO {
    private final String TAKE_ALL_MEALS = SQLCommand.TAKE_ALL_MEALS.getCommand();
    private final String FIND_MEAL_BY_NAME = SQLCommand.FIND_MEAL_BY_NAME.getCommand();

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MenuDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Meal> takeAllMeals() {
        return jdbcTemplate.query(TAKE_ALL_MEALS, new BeanPropertyRowMapper<>(Meal.class));
    }

    @Override
    public Meal findMealByName(String name) {
        return this.jdbcTemplate.query(FIND_MEAL_BY_NAME, new BeanPropertyRowMapper<Meal>(), name)
                .stream().findAny().orElse(null);
    }
}
