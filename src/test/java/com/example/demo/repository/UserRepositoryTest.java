package com.example.demo.repository;

import com.example.demo.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void findAllByAgeGreaterThan() {
        List<User> userList = getUserCollection();
        userRepository.saveAll(userList);

        List<User> userFindAllByAgeGreaterThan = userRepository.findAllByAgeGreaterThan(25);
        System.out.println(userFindAllByAgeGreaterThan);
        Assertions.assertEquals(4, userFindAllByAgeGreaterThan.size());
    }

    @Test
    void findAllByAgeBetween() {
        List<User> userList = getUserCollection();
        userRepository.saveAll(userList);

        List<User> userFindAllByAgeBetween = userRepository.findAllByAgeBetween(25, 35);
        System.out.println(userFindAllByAgeBetween);

        Assertions.assertEquals(4, userFindAllByAgeBetween.size());
    }

    @Transactional
    @Test
    void deleteByName() {
        List<User> userList = getUserCollection();
        userRepository.saveAll(userList);

        List<User> userDeleteByName = userRepository.deleteByName("Pasha");


        Assertions.assertEquals( 9, userDeleteByName.size());
        System.out.println(userDeleteByName);

}


    private List<User> getUserCollection() {
        ArrayList<User> userCollection= new ArrayList<>();
        userCollection.add(new User(1L, "Pasha", 10, "pashka@mail.ru"));
        userCollection.add(new User(2L, "Masha",25, "mashka@mail.ru"));
        userCollection.add(new User(3L, "Sasha",30, "sashka@mail.ru"));
        userCollection.add(new User(4L, "user4",45, "user4@mail.ru"));
        userCollection.add(new User(5L, "user5",27, "user5@mail.ru"));
        userCollection.add(new User(6L, "user6",24, "user6@mail.ru"));
        userCollection.add(new User(7L, "user7",22, "user7@mail.ru"));
        userCollection.add(new User(8L, "user8",26, "user8@mail.ru"));
        userCollection.add(new User(9L, "user9",20, "user9@mail.ru"));
        userCollection.add(new User(10L, "user10",15, "user10@mail.ru"));

        return userCollection;
    }

}