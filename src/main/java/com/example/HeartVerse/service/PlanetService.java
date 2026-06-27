package com.example.HeartVerse.service;

import com.example.HeartVerse.entity.Planet;
import com.example.HeartVerse.entity.User;
import com.example.HeartVerse.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetService {
    @Autowired
    private PlanetRepository planetRepository;

    public void savePlanet(Planet planet) {
        planetRepository.save(planet);

    }

    public Iterable<Planet> getAllPlanets() {
        return planetRepository.findAll();
    }

    public Optional<Planet> findPlanetById(Long id){
        return planetRepository.findById(id);
    }

    public void deletePlanet(Long id){
        planetRepository.deleteById(id);
    }

    public List<Planet> getPlanetsByUser(User user){
        return planetRepository.findByUser(user);
    }
}
