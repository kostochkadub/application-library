package com.example.demo;

import com.example.demo.model.User;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(DemoApplication.class, args);


        /*String id = "1";
        DataSource dataSource = prepareDataSource();
        List<User> users = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE id=?")) {
                statement.setString(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        User user = new User();

                        user.setName(resultSet.getString("name"));

                        System.out.println(user);
                        users.add(user);
                    }
                }
            }
        }
        System.out.println(users);*/

    }



    private static DataSource prepareDataSource() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/user_schema");
        dataSource.setServerTimezone("UTC");
        return dataSource;
    }
}