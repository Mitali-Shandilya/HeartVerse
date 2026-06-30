package com.example.HeartVerse.repository;

import com.example.HeartVerse.entity.Memory;
import com.example.HeartVerse.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemoryRepository extends JpaRepository<Memory, Long> {
    List<Memory> findByPlanet(Planet planet);

    List<Memory> findByTitle(String title);
}
