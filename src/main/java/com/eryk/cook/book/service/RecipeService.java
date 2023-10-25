package com.eryk.cook.book.service;

import com.eryk.cook.book.model.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    List<Recipe> getAll();
    Recipe getById(int id);
    Recipe save(Recipe recipe);
    void delete(int id);
}
