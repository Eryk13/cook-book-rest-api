package com.eryk.cook.book.service;

import com.eryk.cook.book.model.Ingredient;
import com.eryk.cook.book.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient getById(int id) {
        Optional<Ingredient> result = ingredientRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void delete(int id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public Ingredient findByName(String name) {
        return ingredientRepository.findOneByName(name);
    }

}
