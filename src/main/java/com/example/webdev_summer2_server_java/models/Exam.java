package com.example.webdev_summer2_server_java.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Exam extends Widget {

    private String title;
    private String description;
    @OneToMany(mappedBy="exam")
    @JsonIgnore
    private List<BaseExamQuestion> questions;

    public Exam() {
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

    public List<BaseExamQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<BaseExamQuestion> questions) {
        this.questions = questions;
    }
}
