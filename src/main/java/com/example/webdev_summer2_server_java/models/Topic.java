package com.example.webdev_summer2_server_java.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ManyToOne
    @JsonIgnore
    private Lesson lesson;
    @OneToMany(mappedBy = "topic")
    @OrderBy("orderNumber ASC")
    @JsonIgnore
    private List<Widget> widgets = new ArrayList<>();


    public Topic() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public List<Widget> getWidgets() {
        return widgets;
    }

    public void setWidgets(List<Widget> widgets) {
        this.widgets = widgets;
    }

    public void setTopic(Topic topic){
        this.title = topic.title != null ? topic.title : this.title;
    }
}
