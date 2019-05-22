package com.ostanin.dao;

import com.ostanin.dao.interfaces.IIngredientDAO;
import com.ostanin.dto.AdditionalIngredient;
import com.ostanin.dto.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class IngredientDAO implements IIngredientDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Ingredient> allItems() {
        String sql = "SELECT idIngredient, ingredient, unit, quantityOstatok FROM restaurant.warehouse;";
        List<Ingredient> ingredients = new ArrayList<>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {
            Ingredient ingredient = new Ingredient();
            ingredient.setId((Integer)(row.get("idIngredient")));
            ingredient.setName((String)(row.get("ingredient")));
            ingredient.setUnit((String)(row.get("unit")));
            ingredient.setQuantityOstatok((Integer)(row.get("quantityOstatok")));
            ingredients.add(ingredient);
        }
        return ingredients;
    }

    @Override
    public List<AdditionalIngredient> allAdditionalIngredients() {
        String sql = "SELECT * FROM restaurant.additional_ingredients;";
        List<AdditionalIngredient> additionalIngredients = new ArrayList<>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {
            AdditionalIngredient additionalIngredient = new AdditionalIngredient();
            additionalIngredient.setId((Integer)(row.get("idadditional_ingredients")));
            additionalIngredient.setName((String)(row.get("name")));
            additionalIngredient.setPrice((Integer)(row.get("price")));
            additionalIngredient.setQuantity((Integer)(row.get("quantity")));
            additionalIngredients.add(additionalIngredient);
        }
        return additionalIngredients;
    }


    @Override
    public void addIngredientsOnBD(String name, int quantity){
        String sql = "UPDATE `restaurant`.`warehouse` SET `quantityOstatok` = (quantityOstatok + ? )  WHERE (`ingredient` = ?);";
        jdbcTemplate.update(sql, quantity, name);
    }

    @Override
    public void addAdditionalIngredientsOnBD(String name, int quantity){
        String sql = "UPDATE `restaurant`.`additional_ingredients`  SET `quantity` = (quantity + ? )  WHERE (`name` = ?);";
        jdbcTemplate.update(sql, quantity, name);
    }



}
