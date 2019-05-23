package com.ostanin.service.interfaces;

import com.ostanin.dto.Item;

import java.util.List;

public interface IItemService {

    List<Item> coffeeList();

    List<Item> teaList();

    List<Item> searchList(String searchString);

}
