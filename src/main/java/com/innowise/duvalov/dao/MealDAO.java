package com.innowise.duvalov.dao;

import com.innowise.duvalov.model.Meal;

import java.util.List;

public interface MealDAO {
    List<Meal> takeAllMeals();
    Meal findMealByName(String name);
}
