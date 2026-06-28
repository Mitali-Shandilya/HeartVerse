package com.example.HeartVerse.controller;

import com.example.HeartVerse.entity.User;
import com.example.HeartVerse.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // ================= REGISTER =================

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        System.out.println("User ID = " + user.getId());
        System.out.println("Name = " + user.getName());
        System.out.println("Email = " + user.getEmail());
        userService.saveUser(user);
        return "redirect:/login";
    }

    // ================= LOGIN =================

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            HttpSession session) {

        User user = userService.getUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) {

            // Store logged-in user's ID in session
            session.setAttribute("userId", user.getId());

            return "redirect:/dashboard";
        }

        return "login";
    }

    // ================= LOGOUT =================

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }

}