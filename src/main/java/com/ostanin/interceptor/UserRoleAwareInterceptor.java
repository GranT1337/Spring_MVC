package com.ostanin.interceptor;

import com.ostanin.dto.User;
import com.ostanin.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class UserRoleAwareInterceptor implements HandlerInterceptor {

    @Autowired
    private UserManager userManager;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        User currentUser = userManager.getUser();

       if (Objects.isNull(currentUser)) {
           return;
       }
    }

}