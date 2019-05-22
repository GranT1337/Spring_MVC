package com.ostanin.dao.interfaces;

public interface IOrderDao {
    int price(String title);

    int priceAdditionalIngredient(String name);

    boolean checkQuantity(int ID);

    boolean checkSugar(int count);

    boolean checkAdditionalIngredients (String name);

    void updateIngredients (int ID);

    void updateSugar (int count);

    void updateAdditionalIngredients(String name);
}
