package com.example.webdev_summer2_server_java.services;

import com.example.webdev_summer2_server_java.models.EssayExamQuestion;
import com.example.webdev_summer2_server_java.models.Exam;
import com.example.webdev_summer2_server_java.repositories.EssayExamQuestionRepository;
import com.example.webdev_summer2_server_java.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class EssayExamQuestionService {

    @Autowired
    ExamRepository examRepository;

    @Autowired
    EssayExamQuestionRepository essayExamQuestionRepository;

    @PostMapping("/api/exam/{examId}/essay")
    EssayExamQuestion createEssayQuestion(@PathVariable("examId") int examId,
                                          @RequestBody EssayExamQuestion essayExamQuestion){
        if(examRepository.findById(examId).isPresent()){
            Exam exam = examRepository.findById(examId).get();
            essayExamQuestion.setType("Essay");
            essayExamQuestion.setExam(exam);
            return essayExamQuestionRepository.save(essayExamQuestion);
        }
        return null;
    }

    @PutMapping("/api/essayquestion/{questionId}")
    EssayExamQuestion updateQuestion(@PathVariable("questionId") int questionId,
                                     @RequestBody EssayExamQuestion newEssayExamQuestion){
        if(essayExamQuestionRepository.findById(questionId).isPresent()){
            EssayExamQuestion essayExamQuestion = essayExamQuestionRepository.findById(questionId).get();
            essayExamQuestion.update(newEssayExamQuestion);
            return essayExamQuestionRepository.save(essayExamQuestion);
        }
        return null;
    }
}
