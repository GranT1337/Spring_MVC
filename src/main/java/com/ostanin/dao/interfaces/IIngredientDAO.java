package com.ostanin.dao.interfaces;

import com.ostanin.dto.AdditionalIngredient;
import com.ostanin.dto.Ingredient;

import java.util.List;

public interface IIngredientDAO {
    List<Ingredient> allItems();

    List<AdditionalIngredient> allAdditionalIngredients();

    void addIngredientsOnBD(String name, int quantity);

    void addAdditionalIngredientsOnBD(String name, int quantity);
}
