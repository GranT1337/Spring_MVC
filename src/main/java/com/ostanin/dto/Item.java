package com.ostanin.dto;


import lombok.Data;

import java.util.List;

@Data
public class Item {
    private int id;
    private String title;
    private int price;
    private String weight;
    private String photo_link;
    private int idcategory;
    private List<Item> coffeeList;
    private List<Item> teaList;
    private List<Item> drinksList;


    public Item() {
        super();
        // TODO Auto-generated constructor stub
    }
}
