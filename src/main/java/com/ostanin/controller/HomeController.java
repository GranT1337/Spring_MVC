package com.ostanin.controller;

import com.ostanin.dto.*;
import com.ostanin.exception.NoMoneyException;
import com.ostanin.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private IUserManager userManager;

    @Autowired
    private IItemService itemService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IIngredientService ingredientService;



    @RequestMapping("/home")
    public ModelAndView getCatalogPage() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("home-page");

        modelAndView.addObject("addINGREDIENT", ingredientService.getHavingAdditionalIngredient());

        modelAndView.addObject("COFFEE", itemService.coffeeList());
        modelAndView.addObject("TEA", itemService.teaList());

        modelAndView.addObject("currentUserRole", userManager.getUser().getRole());
        modelAndView.addObject("userName", userManager.getUser().getName());
        modelAndView.addObject("userBalance", userManager.getUser().getBalance());

        return modelAndView;
    }


    @PostMapping("/home")
    @ResponseBody
    public ModelAndView addNewOrder( @RequestParam(value = "items") String[] title1,
                                     @RequestParam(value = "sugar[]") Integer[] sugar,
                                     @RequestParam(required=false, value = "ingr[]") String[] ingredients) {

        ModelAndView modelAndView = new ModelAndView();
        userManager.getUser().setOrder(new Order(title1, sugar, ingredients));
        modelAndView.setViewName("redirect:/order");
        return modelAndView;
    }



    @RequestMapping("/topup")
    public ModelAndView topUp() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userBalance", userManager.getUser().getBalance());
        modelAndView.setViewName("top-up");
        return modelAndView;
    }

    @PostMapping("/topup")
    @ResponseBody
    public ModelAndView topUppost(@RequestParam(required=false, value="money") String money) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            userService.money(money);
            userManager.getUser().setBalance(userService.getMoney(userManager.getUser()));
            modelAndView.setViewName("redirect:/home");
        } catch (NoMoneyException e){
            modelAndView.setViewName("top-up");
            modelAndView.addObject("userBalance", userManager.getUser().getBalance());
            modelAndView.addObject("errorMoney", e.getMessage());
        }
        return modelAndView;
    }









}