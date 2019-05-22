package com.ostanin.dao;

import com.ostanin.dao.interfaces.IOrderDao;
import com.ostanin.service.interfaces.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class OrderDao implements IOrderDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IUserManager userManager;


    @Override
    public int price(String title) {
        String sql = "SELECT price FROM restaurant.menu\n" +
                "WHERE title = ?";
        String price = (String) jdbcTemplate.queryForObject(sql, new Object[] {title}, String.class);
        return Integer.parseInt(price);
    }

    @Override
    public int priceAdditionalIngredient(String name) {
        String sql = "SELECT price FROM restaurant.additional_ingredients\n" +
                "WHERE name = ?";
        String price = (String) jdbcTemplate.queryForObject(sql, new Object[] {name}, String.class);
        return Integer.parseInt(price);
    }

    @Override
    public boolean checkQuantity(int ID){
        String sql = "SELECT quantityOstatok - quantity " +
                "FROM restaurant.warehouse, restaurant.composition " +
                "WHERE restaurant.warehouse.idIngredient =  restaurant.composition.idingredient " +
                "AND restaurant.composition.idDrink =" + ID;
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {
            if ((Double)(row.get("quantityOstatok - quantity")) < 0.0) {
                return false;
            }
        }
        return true;
    }


    @Override
    public boolean checkSugar(int count){
        String sql = "SELECT quantityOstatok FROM `restaurant`.`warehouse`  WHERE (`idIngredient` = '8');";
        String quantity = (String) jdbcTemplate.queryForObject(sql, String.class);
        return Integer.parseInt(quantity) > count;
    }


    @Override
    public boolean checkAdditionalIngredients (String name) {
        String sql = "SELECT quantity FROM `restaurant`.`additional_ingredients` WHERE name = \""  + name + "\"";
        String quantity = (String) jdbcTemplate.queryForObject(sql, String.class);
        int newQuantity = Integer.parseInt(quantity) - 1;
        return newQuantity > 0;
    }

    @Override
    public void updateIngredients (int ID) {
        String sql = "UPDATE `restaurant`.`warehouse` AS tbl_1\n" +
                "INNER JOIN (SELECT restaurant.warehouse.idIngredient AS ID, (quantityOstatok - quantity) AS Col1\n" +
                "\tFROM restaurant.warehouse, restaurant.composition\n" +
                "\tWHERE restaurant.warehouse.idIngredient =  restaurant.composition.idingredient \n" +
                "\tAND restaurant.composition.idDrink = ?) AS tbl_2\n" +
                "SET tbl_1.quantityOstatok = tbl_2.Col1\n" +
                "WHERE tbl_1.idIngredient = tbl_2.ID;";
        jdbcTemplate.update(sql, ID);
    }

    @Override
    public void updateSugar (int count) {
        String sql = "UPDATE `restaurant`.`warehouse` SET `quantityOstatok` = (quantityOstatok - ?) WHERE (`idIngredient` = '8');";
        jdbcTemplate.update(sql, count);
    }

    @Override
    public void updateAdditionalIngredients(String name) {
        String sql = "UPDATE `restaurant`.`additional_ingredients` SET `quantity` = (quantity - 1) WHERE (`name` = ?);";
        jdbcTemplate.update(sql, name);

    }
}
