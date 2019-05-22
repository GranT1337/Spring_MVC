package com.ostanin.interceptor;

import com.ostanin.dto.Role;
import com.ostanin.dto.User;
import com.ostanin.service.interfaces.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class AdminInterceptor implements HandlerInterceptor {

    @Autowired
    IUserManager userManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        User currentUser = userManager.getUser();

        if (Objects.isNull(currentUser) || currentUser.getRole().equals(Role.CLIENT)) {
            response.sendRedirect("/home");
            return false;
        }

        return true;
    }
}
