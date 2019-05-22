package com.ostanin.dao.interfaces;

import com.ostanin.dto.User;

public interface IUserDao {

    User registerUser(User user);

    User loginUser(String email, String password);

    int updateMoney(User user, int money);

    int deductMoney(User user, int money);

    int balance(User user);

    User getUserByEmail(String email);

}
