package com.ostanin.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;


@Data
public class User {

    @NotEmpty(message="Имя должно быть заполненено")
    private String name;
    @NotEmpty(message="Поле фамилия должно быть заполненено")
    private String surname;
    private Role role;
    @NotEmpty(message="Необходимо заполнить поле почты")
    @Email(message="Введите корректный адрес почты")
    private String email;
    @NotEmpty(message="Необходимо заполнить поле пароля")
    @Size(min = 5, message="Пароль должен быть длиннее 5")
    private String password;
    private int balance;
    private Order order;



    public User() {
        super();
        // TODO Auto-generated constructor stub
    }


    public User(@NotEmpty(message = "Имя должно быть заполнено") String name,
                @NotEmpty(message = "Фамилия должно быть заполнено") String surname,
                Role role,
                @NotEmpty(message = "Необходимо заполнить поле почты") @Email(message = "Введите корректный адрес почты") String email,
                @NotEmpty(message = "Необходимо заполнить поле пароля") @Size(min = 5, message = "Пароль должен быть длиннее 5") String password,
                int balance) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }
}


