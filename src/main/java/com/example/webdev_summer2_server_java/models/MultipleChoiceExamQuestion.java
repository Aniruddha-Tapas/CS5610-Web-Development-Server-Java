package com.example.webdev_summer2_server_java.models;

import javax.persistence.Entity;

@Entity
public class MultipleChoiceExamQuestion extends BaseExamQuestion{

    private String[] choices;
    private int correct;

    public MultipleChoiceExamQuestion() {
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public void update(MultipleChoiceExamQuestion multipleChoiceExamQuestion){
        if(multipleChoiceExamQuestion.getTitle() != null)
            this.setTitle(multipleChoiceExamQuestion.getTitle());
        if(multipleChoiceExamQuestion.getDescription() != null)
            this.setDescription(multipleChoiceExamQuestion.getDescription());
        if(multipleChoiceExamQuestion.getPoints() >= 0)
            this.setPoints(multipleChoiceExamQuestion.getPoints());
        if(multipleChoiceExamQuestion.getCorrect() >= 0)
            this.setCorrect(multipleChoiceExamQuestion.getCorrect());
        if(multipleChoiceExamQuestion.getChoices() != null)
            this.setChoices(multipleChoiceExamQuestion.getChoices());
    }
}
