package com.ostanin.dto;

import lombok.Data;

import java.util.List;

@Data
public class AdditionalIngredient {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private List<AdditionalIngredient> additionalIngredients;
}
