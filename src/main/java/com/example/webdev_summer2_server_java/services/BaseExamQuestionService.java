package com.example.webdev_summer2_server_java.services;

import com.example.webdev_summer2_server_java.models.BaseExamQuestion;
import com.example.webdev_summer2_server_java.models.Exam;
import com.example.webdev_summer2_server_java.repositories.BaseExamQuestionRepository;
import com.example.webdev_summer2_server_java.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BaseExamQuestionService {

    @Autowired
    ExamRepository examRepository;

    @Autowired
    BaseExamQuestionRepository baseExamQuestionRepository;

    @GetMapping("/api/exam/{examId}/questions")
    List<BaseExamQuestion> findAllQuestionsForExam(@PathVariable("examId") int examId){
        if(examRepository.findById(examId).isPresent()){
            Exam exam = examRepository.findById(examId).get();
            return exam.getQuestions();
        }
        return null;
    }

    @DeleteMapping("/api/question/{questionId}")
    void deleteQuestion(@PathVariable("questionId") int questionId){
        if(baseExamQuestionRepository.findById(questionId).isPresent())
            baseExamQuestionRepository.deleteById(questionId);
    }
}
