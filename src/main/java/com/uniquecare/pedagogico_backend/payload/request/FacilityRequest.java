package com.uniquecare.pedagogico_backend.payload.request;

import com.uniquecare.pedagogico_backend.models.User;

public class FacilityRequest {
    private String title;
    private String description;
    private double pricePerHour;
    private Long categoryId;

    private User assistant;

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

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public User getAssistant() {
        return assistant;
    }

    public void setAssistant(User assistant) {
        this.assistant = assistant;
    }
}
