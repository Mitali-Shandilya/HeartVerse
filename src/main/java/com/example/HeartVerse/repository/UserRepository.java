package com.example.HeartVerse.repository;

import com.example.HeartVerse.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //Handles database operations.
public interface UserRepository extends CrudRepository<User,Long> {
    User findByEmail(String email);
}
