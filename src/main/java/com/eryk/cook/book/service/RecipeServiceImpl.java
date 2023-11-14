package com.eryk.cook.book.service;

import com.eryk.cook.book.model.Ingredient;
import com.eryk.cook.book.model.Recipe;
import com.eryk.cook.book.model.User;
import com.eryk.cook.book.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService{

    private RecipeRepository recipeRepository;
    private IngredientService ingredientService;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, IngredientService ingredientService) {
        this.recipeRepository = recipeRepository;
        this.ingredientService = ingredientService;
    }

    @Override
    public List<Recipe> getAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Page<Recipe> getAll(int userId, int page, int itemsPerPage, String search) {
        Pageable pageable = PageRequest.of(page, itemsPerPage);
        return recipeRepository.findByUserIdAndTitleContains(userId, pageable, search);
    }


    @Override
    public Recipe getById(int id) {
        Optional<Recipe> result = recipeRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public Recipe save(Recipe recipe, User user) {
        List<Ingredient> ingredients = new ArrayList<>();
        for(Ingredient ingredient : recipe.getIngredients()) {
            Ingredient ingredientDb = ingredientService.findByName(ingredient.getName());
                if(ingredientDb == null) {
                    ingredients.add(ingredient);
                    continue;
                }
                ingredients.add(ingredientDb);
        }
        recipe.setIngredients(ingredients);
        recipe.setUser(user);
        return recipeRepository.save(recipe);
    }

    @Override
    public void delete(int id) {
        recipeRepository.deleteById(id);
    }

}
