package com.eryk.cook.book.service;

import com.eryk.cook.book.model.Recipe;
import com.eryk.cook.book.model.User;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAll();
    List<Recipe> getAll(int user_id);
    Recipe getById(int id);
    Recipe save(Recipe recipe, User user);
    void delete(int id);
}
