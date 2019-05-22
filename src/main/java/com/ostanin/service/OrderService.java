package com.ostanin.service;

import com.ostanin.dao.interfaces.IItemDao;
import com.ostanin.dao.interfaces.IOrderDao;
import com.ostanin.dto.Item;
import com.ostanin.dto.Order;
import com.ostanin.exception.IngredientsEndingException;
import com.ostanin.service.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Autowired
    private IItemDao itemDao;

    @Override
    public int summa(String[] title, String[] additionalIngr) {
        int sum = 0;
        for (String aTitle1 : title) {
            sum += orderDao.price(aTitle1);
        }

        if (additionalIngr != null) {
            for (String name : additionalIngr) {
                sum += orderDao.priceAdditionalIngredient(name);
            }
        }

        return sum;
    }

    @Override
    public void orderCheck(Order order){
        List<Item> itemList = itemDao.allItems();
        for (int i = 0; i < order.getTitle().length; i++) {
            for (Item items : itemList) {
                if (items.getTitle().equals(order.getTitle()[i])) {
                    if (orderDao.checkQuantity(items.getId())) {
                        break;
                    } else {
                        throw new IngredientsEndingException("Извините, ингредиенты у " + order.getTitle()[i] + " закончились, позвоните администратору для добавления");
                    }
                }
            }
        }

        int sum = 0;
        for (int num : order.getSugar()) {
            sum = sum + num;
        }

        if (!orderDao.checkSugar(sum)) {
            throw new IngredientsEndingException("Извините, у нас закончился сахар, позвоните администратору для добавления.");
        }

        if (order.getAdditional_ingredients() != null) {
            for (String name : order.getAdditional_ingredients()) {
                if (orderDao.checkAdditionalIngredients(name)) {
                } else {
                    throw new IngredientsEndingException("Извините, " + name + " закончился(ась), позвоните администратору для добавления");
                }
            }
        }

    }

    @Override
    public void orderZakaz(Order orderVhodnoy) {
        List<Item> itemList = itemDao.allItems();
        for (int i = 0; i < orderVhodnoy.getTitle().length; i++) {

            for (Item items : itemList) {
                if (items.getTitle().equals(orderVhodnoy.getTitle()[i])) {
                    if (orderDao.checkQuantity(items.getId())) {
                        orderDao.updateIngredients(items.getId());
                        break;
                    } else {
                        throw new IngredientsEndingException("Извините, ингредиенты у " + orderVhodnoy.getTitle()[i] + " закончились, позвоните администратору для добавления");
                    }
                }
            }
        }

        int sum = 0;
        for (int num : orderVhodnoy.getSugar()) {
            sum = sum + num;
        }
        if (!orderDao.checkSugar(sum)) {
            throw new IngredientsEndingException("Извините, у нас закончился сахар, позвоните администратору для добавления.");
        }
        orderDao.updateSugar(sum);

        if (orderVhodnoy.getAdditional_ingredients() != null) {
            for (String name : orderVhodnoy.getAdditional_ingredients()) {
                if (orderDao.checkAdditionalIngredients(name)) {
                    orderDao.updateAdditionalIngredients(name);
                } else {
                    throw new IngredientsEndingException("Извините, " + name + " закончился(ась), позвоните администратору для добавления");
                }
            }
        }
    }
}
