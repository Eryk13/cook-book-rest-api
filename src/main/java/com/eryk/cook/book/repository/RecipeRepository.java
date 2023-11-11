package com.eryk.cook.book.repository;

import com.eryk.cook.book.model.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    Page<Recipe> findByUserId(int userId, Pageable pageable);
}
