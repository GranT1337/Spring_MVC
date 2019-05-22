package com.ostanin.dao;

import com.ostanin.dao.interfaces.IUserDao;
import com.ostanin.dto.User;
import com.ostanin.service.interfaces.IUserManager;
import com.ostanin.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository
public class UserDao implements IUserDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IUserManager userManager;

    @Autowired
    private IUserService userService;

    private RowMapper<User> ROW_MAPPER = new BeanPropertyRowMapper<>(User.class);


    @Override
    public User registerUser(User user) {
        String sql = "INSERT INTO `restaurant`.`user` " +
                "(`name`, `surname`, `role`, `email`, `password`, `balance`) VALUES (?, ?, 'CLIENT', ?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getSurname(), user.getEmail(), user.getPassword(), user.getBalance());
        return user;
    }

    @Override
    public User loginUser(String email, String password) {
        String sql = "SELECT `name`, `surname`, `role`, `email`, `balance` " +
                "FROM restaurant.user " +
                "WHERE email=? AND password=?";
        try {
            return jdbcTemplate.queryForObject(sql, ROW_MAPPER, email, password);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int updateMoney(User user, int money){
        String sql = "UPDATE `restaurant`.`user` SET `balance` = ? WHERE (`email` = ?);";
        return jdbcTemplate.update(sql, userService.addMoney(money), user.getEmail());
    }

    @Override
    public int deductMoney(User user, int money){
        String sql = "UPDATE `restaurant`.`user` SET `balance` = ? WHERE (`email` = ?);";
        return jdbcTemplate.update(sql, money, user.getEmail());
    }
    @Override
    public int balance(User user){
        String sql = "SELECT balance FROM restaurant.user WHERE email=?";
        String balanced = (String) jdbcTemplate.queryForObject(sql, new String[]{user.getEmail()}, String.class);
        return Integer.parseInt(balanced);
    }



    @Override
    public User getUserByEmail(String email) {
        String sql = "SELECT `name`, `surname`, `role`, `email`, `balance` " +
                "FROM restaurant.user " +
                "WHERE email=?";
        try {
            return jdbcTemplate.queryForObject(sql, ROW_MAPPER, email);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}


