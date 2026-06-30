package com.example.HeartVerse.controller;

import com.example.HeartVerse.entity.Memory;
import com.example.HeartVerse.entity.Planet;
import com.example.HeartVerse.exception.PlanetNotFoundException;
import com.example.HeartVerse.service.MemoryService;
import com.example.HeartVerse.service.PlanetService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;


@Controller
public class MemoryController {

    @Autowired
    private PlanetService planetService;

    @Autowired
    private MemoryService memoryService;

    @GetMapping("/planet/{planetId}/createMemory")
    public String showCreateMemoryPage(@PathVariable Long planetId,
                                       Model model) {

        model.addAttribute("planetId", planetId);

        return "createMemory";
    }

    @PostMapping("/planet/{planetId}/createMemory")
    public String createMemory(@PathVariable("planetId") Long planetId, @ModelAttribute Memory memory) throws PlanetNotFoundException{
        Planet planet=planetService.findPlanetById(planetId).orElseThrow(()->new PlanetNotFoundException("planet with id "+planetId+" not found!"));
        memory.setPlanet(planet);
        memory.setCreatedDate(LocalDate.now());
        memoryService.saveMemory(memory);
        return "redirect:/planet/"+planetId;
    }

    //@GetMapping("/planet/{planetId")

}
