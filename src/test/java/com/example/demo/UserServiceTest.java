package com.example.demo;


import com.example.demo.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;


    @Test
    void addNewUser() {
        String testUserBob = "Bob 32 bob32@gmail.com";
        String testUserAlex = "Alex 11 alex12@mail.ru";

        userService.addNewUserFromString(testUserBob);
        List<User> user = userService.addNewUserFromString(testUserAlex);

        Assertions.assertEquals(2, user.size());
        System.out.println(user);
    }

    @Test
    void addNotValidNewUser() {
        String testUserBob = "Bob123 32 bob32@gmail.com";
        String testUserAlex = "Alex 1111 alex12@mail.ru";
        String testUserTao = "Alex 1111 alex12mail.ru";

        userService.addNewUserFromString(testUserBob);
        userService.addNewUserFromString(testUserTao);
        List<User> user = userService.addNewUserFromString(testUserAlex);

        Assertions.assertEquals(null, user);
    }

}