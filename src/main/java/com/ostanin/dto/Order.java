package com.ostanin.dto;

import lombok.Data;

@Data
public class Order {
    private String[] title;
    private int price1;
    private int kolichestvo;
    private Integer[] sugar;
    private String[] additional_ingredients;

    public Order(String[] title, Integer[] sugarList, String[] add_ingredients) {
        this.title = title;
        this.sugar = sugarList;
        this.additional_ingredients = add_ingredients;
    }


    public Order(String[] title, Integer[] sugarList) {
        this.title = title;
        this.sugar = sugarList;
    }
}
