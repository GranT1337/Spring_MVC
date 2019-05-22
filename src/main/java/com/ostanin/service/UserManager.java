package com.ostanin.service;

import com.ostanin.dto.User;
import com.ostanin.service.interfaces.IUserManager;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Service
public class UserManager implements IUserManager {
    private User user;

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }
}
