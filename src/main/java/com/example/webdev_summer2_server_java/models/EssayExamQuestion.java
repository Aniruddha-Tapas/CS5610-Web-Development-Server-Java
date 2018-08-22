package com.example.webdev_summer2_server_java.models;

import javax.persistence.Entity;

@Entity
public class EssayExamQuestion extends BaseExamQuestion {

    public void update(EssayExamQuestion essayExamQuestion){
        if(essayExamQuestion.getTitle() != null)
            this.setTitle(essayExamQuestion.getTitle());
        if(essayExamQuestion.getDescription() != null)
            this.setDescription(essayExamQuestion.getDescription());
        if(essayExamQuestion.getPoints() >= 0)
            this.setPoints(essayExamQuestion.getPoints());
    }
}
