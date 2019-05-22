package com.ostanin.dao;

import com.ostanin.dao.interfaces.IItemDao;
import com.ostanin.dto.Item;
import com.ostanin.service.interfaces.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ItemDao implements IItemDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IItemService itemService;

    @Override
    public List<Item> allItems() {
        String sql = "SELECT idmenu, title,price,weight,photo_link, idcategory FROM restaurant.menu;";
        List<Item> items = new ArrayList<>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {
            Item item = new Item();
            item.setId((Integer)(row.get("idmenu")));
            item.setTitle((String)(row.get("title")));
            item.setPrice((Integer)(row.get("price")));
            item.setWeight((String)(row.get("weight")));
            item.setPhoto_link((String)(row.get("photo_link")));
            item.setIdcategory((Integer)(row.get("idcategory")));
            items.add(item);
        }
        return items;
    }


    @Override
    public List<Map<String, Object>> alllItems() {
        String sql = "SELECT title,price,weight,photo_link, idcategory FROM restaurant.menu;";
        List<Map<String, Object>> rs = jdbcTemplate.queryForList(sql);
        return rs;
    }
}
