package com.example.HeartVerse.service;

import com.example.HeartVerse.entity.User;
import com.example.HeartVerse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service //Contains business logic.
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public Optional<User> findUserById(Long Id){ return userRepository.findById(Id);}

}
