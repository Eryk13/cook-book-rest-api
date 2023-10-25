package com.eryk.cook.book.repository;

import com.eryk.cook.book.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    Ingredient findOneByName(String name);
}
