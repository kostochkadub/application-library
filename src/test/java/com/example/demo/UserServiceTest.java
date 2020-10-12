package com.example.demo;


import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;


    @Test
    void addNewUser() {
       String testUser="Bob 32 bob32@gmail.com";
       userService.addNewUser(testUser);

    }


    private List<User> getUserCollection() {
        ArrayList<User> userCollection= new ArrayList<>();
        userCollection.add(new User(1L, "Pasha", 10, "pashka@mail.ru"));
        userCollection.add(new User(2L, "Masha",25, "mashka@mail.ru"));
        return userCollection;
    }

}