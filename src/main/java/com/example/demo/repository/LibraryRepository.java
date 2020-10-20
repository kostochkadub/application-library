package com.example.demo.repository;

import com.example.demo.model.Library;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {

    //получить все книги, которые читает читатель с ID;
    @Query(value = "SELECT name, title " +
            "FROM user_schema.user ,user_schema.library, user_schema.book " +
            "WHERE  user_schema.library.userId = user_schema.user.id " +
            "AND user_schema.library.userId = (:userId) " +
            "AND user_schema.library.bookId =  user_schema.book.id;", nativeQuery = true)
    List<Library> selectAllBooksReadByTheReaderWithID(@Param("userId") Integer userId);

    //получить читателя, который читает книгу с ID;
    @Query(value = "SELECT name AS reader, title AS book\n" +
            "FROM user_schema.user ,user_schema.library, user_schema.book\n" +
            "WHERE  user_schema.library.userId = user_schema.user.id\n" +
            "AND user_schema.library.bookId =  user_schema.book.id\n" +
            "AND user_schema.library.bookId = (:bookId);", nativeQuery = true)
    List<Library> selectReaderWhoReadsABookWithID(@Param("bookId") Integer userId);

    //#получить всех читателей, которые читают книги автора с ID.
    @Query(value = "SELECT name, userId, title, authorId\n" +
            "FROM user_schema.user ,user_schema.library, user_schema.book\n" +
            "WHERE  user_schema.library.userId = user_schema.user.id\n" +
            "AND user_schema.library.bookId =  user_schema.book.id\n" +
            "AND user_schema.book.authorId =  (:authorId);", nativeQuery = true)
    List<Library> selectAllReadersWhoReadTheAuthorsBooksWithID(@Param("authorId") Integer authorId);
}
