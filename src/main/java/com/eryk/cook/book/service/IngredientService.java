package com.eryk.cook.book.service;

import com.eryk.cook.book.model.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getAll();
    Ingredient getById(int id);
    Ingredient save(Ingredient ingredient);
    void delete(int id);
    Ingredient findByName(String name);
}
