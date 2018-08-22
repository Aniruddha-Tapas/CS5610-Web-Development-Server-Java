package com.example.webdev_summer2_server_java.services;

import com.example.webdev_summer2_server_java.models.Exam;
import com.example.webdev_summer2_server_java.models.TrueOrFalseExamQuestion;
import com.example.webdev_summer2_server_java.repositories.ExamRepository;
import com.example.webdev_summer2_server_java.repositories.TrueOrFalseExamQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class TrueOrFalseExamQuestionService {

    @Autowired
    TrueOrFalseExamQuestionRepository trueOrFalseExamQuestionRepository;

    @Autowired
    ExamRepository examRepository;

    @PostMapping("/api/exam/{examId}/truefalse")
    TrueOrFalseExamQuestion createTrueFalseQuestion(@PathVariable("examId") int examId,
                                                    @RequestBody TrueOrFalseExamQuestion trueOrFalseExamQuestion){
        if(examRepository.findById(examId).isPresent()){
            Exam exam = examRepository.findById(examId).get();
            trueOrFalseExamQuestion.setType("True Or False");
            trueOrFalseExamQuestion.setExam(exam);
            return trueOrFalseExamQuestionRepository.save(trueOrFalseExamQuestion);
        }
        return null;
    }

    @PutMapping("/api/truefalse/{questionId}")
    TrueOrFalseExamQuestion updateQuestion(@PathVariable("questionId") int questionId,
                                           @RequestBody TrueOrFalseExamQuestion newTrueOrFalseExamQuestion){
        if(trueOrFalseExamQuestionRepository.findById(questionId).isPresent()){
            TrueOrFalseExamQuestion trueOrFalseExamQuestion = trueOrFalseExamQuestionRepository
                    .findById(questionId)
                    .get();
            trueOrFalseExamQuestion.update(newTrueOrFalseExamQuestion);
            return trueOrFalseExamQuestionRepository.save(trueOrFalseExamQuestion);
        }
        return null;
    }
}
