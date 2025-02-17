package com.ejemplo.microservicio.modelo;

public class Rating {
    private int rating;
    private String rated_by;

    // Getters y setters

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRated_by() {
        return rated_by;
    }

    public void setRated_by(String rated_by) {
        this.rated_by = rated_by;
    }
}