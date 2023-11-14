package com.eryk.cook.book.service;

import com.eryk.cook.book.model.Recipe;
import com.eryk.cook.book.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAll();
    Page<Recipe> getAll(int user_id, int page, int itemsPerPage, String search);
    Recipe getById(int id);
    Recipe save(Recipe recipe, User user);
    void delete(int id);
}
