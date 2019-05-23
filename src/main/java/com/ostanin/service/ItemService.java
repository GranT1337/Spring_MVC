package com.ostanin.service;

import com.ostanin.dao.interfaces.IItemDao;
import com.ostanin.dao.interfaces.IOrderDao;
import com.ostanin.dto.Item;
import com.ostanin.service.interfaces.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService implements IItemService {


    @Autowired
    private IItemDao itemDao;

    @Autowired
    private IOrderDao orderDao;


    @Override
    public List<Item> coffeeList() {
        List<Item> itemList = itemDao.allItems();
        List<Item> coffeeList = new ArrayList<>();
        for (Item i : itemList) {
            if (i.getIdcategory() == 1) {
                if (orderDao.checkQuantity(i.getId())) {
                    coffeeList.add(i);
                }
            }
        }

        return coffeeList;
    }

    @Override
    public List<Item> teaList() {
        List<Item> itemList = itemDao.allItems();
        List<Item> teaList = new ArrayList<>();
        for (Item i : itemList) {
            if (i.getIdcategory() == 2) {
                if (orderDao.checkQuantity(i.getId())) {
                    teaList.add(i);
                }
            }
        }

        return teaList;
    }

    @Override
    public List<Item> searchList(String searchString) {
        return itemDao.searchItems(searchString);
    }



}
