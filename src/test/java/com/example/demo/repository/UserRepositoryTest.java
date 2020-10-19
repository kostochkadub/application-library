package com.example.demo.repository;

import com.example.demo.model.Book;
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
    void selectAllFromUser() {
        List<User> userList = getUserCollection();
        userRepository.saveAll(userList);

        List<User> usersFromTable = userRepository.selectAllFromUser();
        Assertions.assertTrue( userList.equals(usersFromTable));
    }


    private List<User> getUserCollection() {
        ArrayList<User> userCollection= new ArrayList<>();
        userCollection.add(new User(null, "Pasha"));
        userCollection.add(new User(null, "Masha"));
        userCollection.add(new User(null, "Sasha"));
        userCollection.add(new User(null, "user4"));
        userCollection.add(new User(null, "user5"));

        return userCollection;
    }
    private List<Book> getBookCollection() {
        ArrayList<Book> bookCollection= new ArrayList<>();
        bookCollection.add(new Book(null, "Хроники Дюны", "Фрэнк Герберт"));
        bookCollection.add(new Book(null, "Война и мир", "Лев Толстой"));
        bookCollection.add(new Book(null, "Тестирование Дот Ком", "Роман Савин"));

        return bookCollection;
    }


}