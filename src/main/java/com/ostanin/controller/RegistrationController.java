package com.ostanin.controller;

import com.ostanin.dto.User;
import com.ostanin.exception.SuchUserAlreadyRegisteredException;
import com.ostanin.service.interfaces.IUserManager;
import com.ostanin.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class RegistrationController {

    @Autowired
    private IUserManager userManager;

    @Autowired
    private IUserService userService;

    @GetMapping("/registration")
    public ModelAndView getRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }


    @PostMapping("/registration")
    @ResponseBody
    public ModelAndView registration(@Validated User user, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            modelAndView.addObject("errors", result.getAllErrors());
        } else {
            try {
                userService.addNewUser(user);
                modelAndView.setViewName("redirect:/home");
                return modelAndView;
            } catch (SuchUserAlreadyRegisteredException e){
                modelAndView.addObject("emailbusy", e.getMessage());
            }
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }

}
