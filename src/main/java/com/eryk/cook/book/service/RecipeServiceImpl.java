package com.eryk.cook.book.service;

import com.eryk.cook.book.model.Recipe;
import com.eryk.cook.book.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService{

    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getAll() {
        return recipeRepository.findAll();
    }
    @Override
    public Recipe getById(int id) {
        Optional<Recipe> result = recipeRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public void delete(int id) {
        recipeRepository.deleteById(id);
    }
}
