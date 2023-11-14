package com.eryk.cook.book.controller;

import com.eryk.cook.book.helper.IdNotMatchException;
import com.eryk.cook.book.helper.NotFoundException;
import com.eryk.cook.book.model.Recipe;
import com.eryk.cook.book.model.User;
import com.eryk.cook.book.service.RecipeService;
import com.eryk.cook.book.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("recipes")
public class RecipeController {
    private RecipeService recipeService;
    private UserService userService;

    public RecipeController(RecipeService recipeService, UserService userService) {
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @GetMapping("")
    public Page<Recipe> getAll(@RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "itemsPerPage", defaultValue = "2") int itemsPerPage,
                               @RequestParam(name = "search", defaultValue = "") String search) {
        User user = getUser();
        return recipeService.getAll(user.getId(), page, itemsPerPage, search);
    }

    @GetMapping("{id}")
    public Recipe getById(@PathVariable int id) {
        User user = getUser();
        Recipe recipe = findById(id);
        if(recipe.getUser().getId() != user.getId()) {
            throw new IdNotMatchException("recipe doesn't belong to user");
        }
        return recipe;
    }

    @PostMapping("")
    public Recipe create(@Valid @RequestBody Recipe recipe) {
        User user = getUser();
        return recipeService.save(recipe, user);
    }

    @PutMapping("")
    public void update(@Valid @RequestBody Recipe recipe) {
        User user = getUser();
        Recipe recipeDb = findById(recipe.getId());
        if(recipeDb.getUser().getId() != user.getId()) {
            throw new IdNotMatchException("recipe doesn't belong to user");
        }
        recipeService.save(recipe, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        User user = getUser();
        Recipe recipe = findById(id);
        if(recipe.getUser().getId() != user.getId()) {
            throw new IdNotMatchException("recipe doesn't belong to user");
        }
        recipeService.delete(id);
    }

    private Recipe findById(int id) {
        Recipe recipe = recipeService.getById(id);
        if(recipe == null) {
            throw new NotFoundException("recipe with id: " + id + " not found");
        }
        return recipe;
    }
    private User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userService.findByUsername(username);
    }
}
