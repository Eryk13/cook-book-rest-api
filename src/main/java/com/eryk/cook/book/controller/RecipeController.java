package com.eryk.cook.book.controller;

import com.eryk.cook.book.model.Recipe;
import com.eryk.cook.book.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recipes")
public class RecipeController {
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("")
    public List<Recipe> getAll() {
        return recipeService.getAll();
    }

    @PostMapping("")
    public Recipe create(@RequestBody Recipe recipe) {
        return recipeService.save(recipe);
    }



}
