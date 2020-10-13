package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> addNewUserFromString(String userParam) {
        if (userParam.matches("^[a-zA-Zа-яА-Я]+\\s[0-9]{1,3}\\s[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+")) {
            String[] words = userParam.split("\\s");
            userRepository.addNewUser(words[0], Integer.parseInt(words[1]), words[2]);
            return userRepository.findAll();
        } else {
            System.out.println("Неверный формат");
            return null;
        }

    }

    public User getById(Long id){
        return userRepository.getOne(id);

    }
}
