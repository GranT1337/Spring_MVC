package com.ostanin.service.interfaces;

import com.ostanin.dto.AdditionalIngredient;
import com.ostanin.dto.Ingredient;

import java.util.List;

public interface IIngredientService {
    List<Ingredient> getSmallAmountIngredients();

    List<AdditionalIngredient> getSmallAmountAdditionalIngredients();

    void addAdditionalIngredients(String name, int quantity);

    void addIngredients(String name, int quantity);

    List<Ingredient> getIngredients();

    List<AdditionalIngredient> getAdditionalIngredients();

    List<AdditionalIngredient> getHavingAdditionalIngredient();

}


