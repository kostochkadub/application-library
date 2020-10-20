package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM user", nativeQuery = true)
    List<User> selectAllFromUser();

    @Modifying
    @Query(value = "INSERT INTO user (name) VALUES (:name)", nativeQuery = true)
    @Transactional
    void addNewUser(@Param("name") String name);
}



