package com.ostanin.controller;

import com.ostanin.service.interfaces.IIngredientService;
import com.ostanin.service.interfaces.IItemService;
import com.ostanin.service.interfaces.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    private IUserManager userManager;

    @Autowired
    private IItemService itemService;

    @Autowired
    private IIngredientService ingredientService;

    @PostMapping("/admin")
    @ResponseBody
    public ModelAndView otpravka(@RequestParam(required=false, value = "AdditionalIngr") String additionalIngr,
                                 @RequestParam(required=false, value = "Ingr") String ingredient,
                                 @RequestParam(value = "quantity") int quantity) {
        ModelAndView modelAndView = new ModelAndView();
        if (additionalIngr == null) {
            ingredientService.addIngredients(ingredient, quantity);
        } else {
            ingredientService.addAdditionalIngredients(additionalIngr, quantity);
        }
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }



    @GetMapping("/admin")
    public ModelAndView adminPage() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("COFFEE", itemService.coffeeList());
        modelAndView.addObject("TEA", itemService.teaList());

        modelAndView.setViewName("admin-page");

        modelAndView.addObject("addINGREDIENT", ingredientService.getAdditionalIngredients());
        modelAndView.addObject("INGREDIENT", ingredientService.getIngredients());

        modelAndView.addObject("ingredients_ending", ingredientService.getSmallAmountIngredients());
        modelAndView.addObject("additional_ingredients_ending", ingredientService.getSmallAmountAdditionalIngredients());
        modelAndView.addObject("userName", userManager.getUser().getName());

        return modelAndView;
    }

}
