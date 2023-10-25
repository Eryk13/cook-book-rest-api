package com.eryk.cook.book.controller;

import com.eryk.cook.book.helper.NotFoundException;
import com.eryk.cook.book.model.ErrorResponse;
import com.eryk.cook.book.model.Recipe;
import com.eryk.cook.book.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

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
        return findById(id);
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
        findById(id);
        recipeService.delete(id);
    }
    private Recipe findById(int id) {
        Recipe recipe = recipeService.getById(id);
        if(recipe == null) {
            throw new NotFoundException("recipe with id: " + id + " not found");
        }
        return recipe;
    }
}
