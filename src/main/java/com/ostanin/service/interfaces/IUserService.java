package com.ostanin.service.interfaces;

import com.ostanin.dto.User;

public interface IUserService {

    User addNewUser(User user);

    User getUserByEmailService(User user);

    int addMoney(int money);

    int money(String money);

    int getMoney(User user);

    void buyItem(int sumZakaza);

}
