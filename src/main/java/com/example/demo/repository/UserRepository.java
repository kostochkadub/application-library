package com.example.demo.repository;


import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByAgeGreaterThan(int minAge);
    List<User> findAllByAgeBetween(int minAge, int maxAge);
    List<User> deleteByName(String name);


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO user (name, age, email) VALUES :name, :age, :email", nativeQuery = true)
    List<User> addNewUser(String name, int age, String email);
}



