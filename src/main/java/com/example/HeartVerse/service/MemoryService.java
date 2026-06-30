package com.example.HeartVerse.service;

import com.example.HeartVerse.entity.Memory;
import com.example.HeartVerse.entity.Planet;
import com.example.HeartVerse.repository.MemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemoryService {

    @Autowired
    private MemoryRepository memoryRepository;

    //SAVING THE MEMORY
    public void saveMemory(Memory memory){
        memoryRepository.save(memory);
    }

    //DELEING MEMORIES
    public void deleteMemoryById(Long id){
        memoryRepository.deleteById(id);
    }

    //GETTING ALL THE MEMORIES
    public Optional<Memory> findMemoryById(Long id){
        return memoryRepository.findById(id);
    }

    public List<Memory> getAllMemoryByPlanet(Planet planet){
        return memoryRepository.findByPlanet(planet);
    }

    public List<Memory> getAllMemoryByTitle(String title){
        return memoryRepository.findByTitle(title);
    }
}
