package com.example.demo.repository;

import com.example.demo.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Library, Integer> {

    //получить все книги автора с ID;
    @Query(value = "SELECT title, name\n" +
            "FROM user_schema.book, user_schema.author\n" +
            "WHERE user_schema.book.authorId = user_schema.author.id\n" +
            "AND user_schema.book.authorId = (:authorId);", nativeQuery = true)
    List<Library> selectAllAuthorsBooksWithID(@Param("authorId") Integer authorId);
}
