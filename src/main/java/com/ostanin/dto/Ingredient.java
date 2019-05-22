package com.ostanin.dto;

import lombok.Data;

import java.util.List;


@Data
public class Ingredient {
    private int id;
    private String name;
    private String unit;
    private int quantityOstatok;
    private List<Ingredient> ingredients;
}
