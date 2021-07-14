package ru.rmanokhin.crud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rmanokhin.crud.entity.User;
import ru.rmanokhin.crud.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class InitDB {

    private final UserService userService;

    @Autowired
    public InitDB(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void initDB(){
        User firstUser = new User("Igor","Igorev","Igor666@yandex.com");
        User secondUser = new User("Alex","Alexandrow","alex007@mail.ru");
        userService.addUser(firstUser);
        userService.addUser(secondUser);
    }
}
