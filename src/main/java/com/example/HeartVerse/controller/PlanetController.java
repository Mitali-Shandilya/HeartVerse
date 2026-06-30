package com.example.HeartVerse.controller;

import com.example.HeartVerse.entity.Planet;
import com.example.HeartVerse.exception.UserNotFoundException;
import com.example.HeartVerse.service.PlanetService;
import com.example.HeartVerse.service.UserService;
import jakarta.servlet.http.HttpSession;
import com.example.HeartVerse.entity.User;
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

    @Autowired
    private UserService userService;
    @PostMapping("/createPlanet")
    public String createPlanet(@ModelAttribute Planet planet, HttpSession session)throws UserNotFoundException{
        Long UserId=(Long)session.getAttribute("userId");
        User user=userService.findUserById(UserId).orElseThrow(()-> new UserNotFoundException("User with id: "+UserId+" not found"));
        planet.setUser(user);
        planet.setCreatedDate(LocalDate.now());
        planetService.savePlanet(planet);
        return "redirect:/dashboard";
    }

    // ================= DASHBOARD =================


    @GetMapping("/dashboard")
    public String showDashboard(Model model, HttpSession session) throws UserNotFoundException{

        if (session.getAttribute("userId") == null) {
            return "redirect:/login";
        }

        Long userId=(Long)session.getAttribute("userId");
        User user=userService.findUserById(userId).orElseThrow(() ->new UserNotFoundException("user with id:"+userId+" not found"));
        Iterable<Planet> planets = planetService.getPlanetsByUser(user);
        model.addAttribute("planets",planets);
        return "dashboard";
    }

}
