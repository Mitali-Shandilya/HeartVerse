package com.example.HeartVerse.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Memory {

    @ManyToOne
    @JoinColumn(name = "planet_id")
    private Planet planet;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memoryId;
    private String title;
    private String description;
    private LocalDate memoryDate;
    private String imageUrl;
    private LocalDate createdDate;
    private String mood;

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public Long getMemoryId() {
        return memoryId;
    }

    public void setMemoryId(Long memoryId) {
        this.memoryId = memoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getMemoryDate() {
        return memoryDate;
    }

    public void setMemoryDate(LocalDate memoryDate) {
        this.memoryDate = memoryDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Memory(Planet planet, String title, String description, LocalDate memoryDate, String imageUrl, LocalDate createdDate, String mood) {
        this.planet = planet;
        this.title = title;
        this.description = description;
        this.memoryDate = memoryDate;
        this.imageUrl = imageUrl;
        this.createdDate = createdDate;
        this.mood = mood;
    }

    public Memory() {
    }
}
