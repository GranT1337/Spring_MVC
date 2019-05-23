package com.ostanin.dao.interfaces;

import com.ostanin.dto.Item;

import java.util.List;
import java.util.Map;

public interface IItemDao {
    List<Item> allItems();

    List<Map<String, Object>> alllItems();

    List<Item> searchItems(String searchString);

}
