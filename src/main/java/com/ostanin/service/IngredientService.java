package com.ostanin.service;

import com.ostanin.dao.interfaces.IIngredientDAO;
import com.ostanin.dao.interfaces.IOrderDao;
import com.ostanin.dto.AdditionalIngredient;
import com.ostanin.dto.Ingredient;
import com.ostanin.service.interfaces.IIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService implements IIngredientService {

    @Autowired
    private IIngredientDAO ingredientDAO;

    @Autowired
    private IOrderDao orderDao;

    @Override
    public List<Ingredient> getSmallAmountIngredients(){
        List<Ingredient> ingr = new ArrayList<>();
        for (int i = 0; i < getIngredients().size(); i++) {
            if (getIngredients().get(i).getQuantityOstatok() < 200) {
                ingr.add(getIngredients().get(i));
            }
        }
        return ingr;
    }

    @Override
    public List<AdditionalIngredient> getSmallAmountAdditionalIngredients(){
        List<AdditionalIngredient> addtionalIngr = new ArrayList<>();
        for (int i = 0; i < getAdditionalIngredients().size(); i++) {
            if (getAdditionalIngredients().get(i).getQuantity() < 15) {
                addtionalIngr.add(getAdditionalIngredients().get(i));
            }
        }
        return addtionalIngr;
    }

    @Override
    public void addAdditionalIngredients(String name,  int quantity) {
        ingredientDAO.addAdditionalIngredientsOnBD(name,quantity);
    }

    @Override
    public void addIngredients(String name, int quantity) {
        ingredientDAO.addIngredientsOnBD(name,quantity);
    }


    @Override
    public List<Ingredient> getIngredients() {
        return ingredientDAO.allItems();
    }


    @Override
    public List<AdditionalIngredient> getHavingAdditionalIngredient() {
        List<AdditionalIngredient> newIngredientList = new ArrayList<>();
        for (AdditionalIngredient i: ingredientDAO.allAdditionalIngredients()) {
            if(orderDao.checkAdditionalIngredients(i.getName())){
                newIngredientList.add(i);
            }
        }
        return newIngredientList;
    }

    @Override
    public List<AdditionalIngredient> getAdditionalIngredients() {
        return ingredientDAO.allAdditionalIngredients();
    }
}
