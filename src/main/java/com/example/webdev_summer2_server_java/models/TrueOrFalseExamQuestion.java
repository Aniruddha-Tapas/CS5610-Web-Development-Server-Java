package com.example.webdev_summer2_server_java.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;

@Entity
public class TrueOrFalseExamQuestion extends BaseExamQuestion {

    @JsonProperty
    boolean isTrue;

    public TrueOrFalseExamQuestion() {
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public void update(TrueOrFalseExamQuestion trueOrFalseExamQuestion){
        if(trueOrFalseExamQuestion.getTitle() != null)
            this.setTitle(trueOrFalseExamQuestion.getTitle());
        if(trueOrFalseExamQuestion.getDescription() != null)
            this.setDescription(trueOrFalseExamQuestion.getDescription());
        if(trueOrFalseExamQuestion.getPoints() >= 0)
            this.setPoints(trueOrFalseExamQuestion.getPoints());
        if(trueOrFalseExamQuestion.isTrue() != this.isTrue)
            this.setTrue(trueOrFalseExamQuestion.isTrue());
    }
}
