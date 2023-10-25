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

    @GetMapping("{id}")
    public Recipe getById(@PathVariable int id) {
        return recipeService.getById(id);
    }

    @PostMapping("")
    public Recipe create(@RequestBody Recipe recipe) {
        return recipeService.save(recipe);
    }

    @PutMapping("")
    public void update(@RequestBody Recipe recipe) {
        recipeService.save(recipe);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        recipeService.delete(id);
    }
}
