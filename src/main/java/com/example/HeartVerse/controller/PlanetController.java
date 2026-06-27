package com.example.HeartVerse.controller;

import com.example.HeartVerse.entity.Planet;
import com.example.HeartVerse.service.PlanetService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    // ================= PLANETS =================
    @GetMapping("/createPlanet")
    public String getCreatePlanet(){
        return "createPlanet";
    }

    @PostMapping("/createPlanet")
    public String createPlanet(@ModelAttribute Planet planet){
        planet.setCreatedDate(LocalDate.now());
        planetService.savePlanet(planet);
        return "redirect:/dashboard";
    }

    // ================= DASHBOARD =================


    @GetMapping("/dashboard")
    public String showDashboard(Model model, HttpSession session) {

        if (session.getAttribute("userId") == null) {
            return "redirect:/login";
        }

        Iterable<Planet> planets = planetService.getAllPlanets();
        model.addAttribute("planets",planets);
        return "dashboard";
    }

}
