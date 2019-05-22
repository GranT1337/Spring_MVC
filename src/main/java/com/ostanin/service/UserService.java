package com.ostanin.service;

import com.ostanin.dao.interfaces.IUserDao;
import com.ostanin.dto.User;
import com.ostanin.exception.NoMoneyException;
import com.ostanin.exception.NoSuchUserException;
import com.ostanin.exception.SuchUserAlreadyRegisteredException;
import com.ostanin.service.interfaces.IUserManager;
import com.ostanin.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Objects;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserManager userManager;

    @Autowired
    private IUserDao userDao;

    @Override
    public User addNewUser(User user) {
        if (!Objects.isNull(userDao.getUserByEmail(user.getEmail()))) {
            throw new SuchUserAlreadyRegisteredException("E-mail уже занят, зарегистрированы?");
        }
        return userDao.registerUser(user);
    }


    @Override
    public User getUserByEmailService(User user) {
        User currentUser = userDao.loginUser(user.getEmail(), user.getPassword());
        if (Objects.isNull(currentUser)) {
            throw new NoSuchUserException("Неверный логин или пароль");
        }
        return currentUser;
    }

    @Override
    public int addMoney(int money) {
        return (money + userManager.getUser().getBalance());
    }

    @Override
    public int money(String money){
        if (money.equals("")) {
            throw new NoMoneyException("Введите сумму!");
        }
            return addMoney(userDao.updateMoney(userManager.getUser(), Integer.parseInt(money)));

    }

    @Override
    public int getMoney(User user) {
        return userDao.balance(user);
    }

    @Override
    public void buyItem(int sumZakaza) {
        userManager.getUser().setBalance(userManager.getUser().getBalance() - sumZakaza);
        userDao.deductMoney(userManager.getUser(), userManager.getUser().getBalance());
    }
}
