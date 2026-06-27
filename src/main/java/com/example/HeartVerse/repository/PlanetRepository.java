package com.example.HeartVerse.repository;

import com.example.HeartVerse.entity.Planet;
import com.example.HeartVerse.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, Long> {

    List<Planet> findByUser(User user);

}