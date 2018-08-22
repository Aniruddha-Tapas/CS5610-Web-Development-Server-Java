package com.example.webdev_summer2_server_java.models;

import javax.persistence.Entity;

@Entity
public class FillInTheBlanksExamQuestion extends BaseExamQuestion {

    private String variable;

    public FillInTheBlanksExamQuestion() {
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public void update(FillInTheBlanksExamQuestion fillInTheBlanksExamQuestion){
        if(fillInTheBlanksExamQuestion.getTitle() != null)
            this.setTitle(fillInTheBlanksExamQuestion.getTitle());
        if(fillInTheBlanksExamQuestion.getDescription() != null)
            this.setDescription(fillInTheBlanksExamQuestion.getDescription());
        if(fillInTheBlanksExamQuestion.getPoints() >= 0)
            this.setPoints(fillInTheBlanksExamQuestion.getPoints());
        if(fillInTheBlanksExamQuestion.getVariable() != null)
            this.setVariable(fillInTheBlanksExamQuestion.getVariable());
    }
}
