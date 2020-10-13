package com.example.demo.repository;

import com.example.demo.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


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

        List<User> userDeleteByName = userRepository.findAll();
        Assertions.assertEquals( 10, userDeleteByName.size());

        userRepository.deleteByName("Pasha");

        userDeleteByName = userRepository.findAll();
        Assertions.assertEquals( 9, userDeleteByName.size());
        System.out.println(userDeleteByName);
}

    @Test
    void selectAllFromUser() {
        List<User> userList = getUserCollection();
        userRepository.saveAll(userList);

        List<User> usersFromTable = userRepository.selectAllFromUser();
        Assertions.assertTrue( userList.equals(usersFromTable));
    }


    private List<User> getUserCollection() {
        ArrayList<User> userCollection= new ArrayList<>();
        userCollection.add(new User(null, "Pasha", 10, "pashka@mail.ru"));
        userCollection.add(new User(null, "Masha",25, "mashka@mail.ru"));
        userCollection.add(new User(null, "Sasha",30, "sashka@mail.ru"));
        userCollection.add(new User(null, "user4",45, "user4@mail.ru"));
        userCollection.add(new User(null, "user5",27, "user5@mail.ru"));
        userCollection.add(new User(null, "user6",24, "user6@mail.ru"));
        userCollection.add(new User(null, "user7",22, "user7@mail.ru"));
        userCollection.add(new User(null, "user8",26, "user8@mail.ru"));
        userCollection.add(new User(null, "user9",20, "user9@mail.ru"));
        userCollection.add(new User(null, "user10",15, "user10@mail.ru"));

        return userCollection;
    }


}