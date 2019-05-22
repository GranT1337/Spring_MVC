package com.ostanin.controller;

import com.ostanin.dto.User;
import com.ostanin.exception.NoSuchUserException;
import com.ostanin.service.interfaces.IUserManager;
import com.ostanin.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class AuthController {

    @Autowired
    private IUserManager userManager;

    @Autowired
    private IUserService userService;

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/login");
        request.getSession().invalidate();

        return modelAndView;
    }


    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login-page");
        modelAndView.addObject("login-page");

        return modelAndView;
    }


    @PostMapping("/login")
    public ModelAndView login(User user) {
        ModelAndView modelAndView = new ModelAndView();


        try {
            userManager.setUser(userService.getUserByEmailService(user));
            modelAndView.setViewName("redirect:/home");
        } catch (NoSuchUserException e) {
            modelAndView.addObject("errorMsg", e.getMessage());
            modelAndView.addObject("email", user.getEmail());
            modelAndView.setViewName("login-page");
        }

        return modelAndView;
    }
}
