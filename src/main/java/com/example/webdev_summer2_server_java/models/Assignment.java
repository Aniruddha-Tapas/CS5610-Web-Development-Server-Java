package com.example.webdev_summer2_server_java.models;

import javax.persistence.Entity;

@Entity
public class Assignment extends Widget {

    private String title;
    private String description;
    private int points;

    public Assignment() {
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void updateAssignment(Assignment assignment){
        this.title = assignment.title != null ?
                assignment.title : this.title;
        this.description = assignment.description != null ?
                assignment.description : this.description;
        this.points = assignment.points >= 0 ?
                assignment.points : this.points;
    }
}
