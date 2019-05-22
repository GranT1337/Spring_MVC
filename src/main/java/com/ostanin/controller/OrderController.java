package com.ostanin.controller;

import com.ostanin.exception.IngredientsEndingException;
import com.ostanin.exception.NoMoneyException;
import com.ostanin.service.interfaces.IOrderService;
import com.ostanin.service.interfaces.IUserManager;
import com.ostanin.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {

    @Autowired
    private IUserManager userManager;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IUserService userService;

    @RequestMapping("/order")
    public ModelAndView order() {
        ModelAndView modelAndView = new ModelAndView();
        int summa = orderService.summa(userManager.getUser().getOrder().getTitle(), userManager.getUser().getOrder().getAdditional_ingredients());
        modelAndView.addObject("SUM", summa);
        modelAndView.addObject("userBalance", userManager.getUser().getBalance());
        modelAndView.addObject("zakaz", userManager.getUser().getOrder().getTitle());
        modelAndView.addObject("zakazAdditional", userManager.getUser().getOrder().getAdditional_ingredients());
        try {
            orderService.orderCheck(userManager.getUser().getOrder());
            modelAndView.setViewName("order");
        } catch (IngredientsEndingException e) {
            modelAndView.setViewName("error");
            modelAndView.addObject("NoIngredients", e.getMessage());
        }
        return modelAndView;
    }

    @PostMapping("/order")
    public ModelAndView addNewOrder() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            orderService.orderZakaz(userManager.getUser().getOrder());
            userService.buyItem(orderService.summa(userManager.getUser().getOrder().getTitle(), userManager.getUser().getOrder().getAdditional_ingredients()));
            modelAndView.setViewName("redirect:/home");
        } catch (IngredientsEndingException e) {
            modelAndView.setViewName("error");
            modelAndView.addObject("NoIngredients", e.getMessage());

        }
        return modelAndView;
    }
}
