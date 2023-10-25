package com.eryk.cook.book.repository;

import com.eryk.cook.book.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}
