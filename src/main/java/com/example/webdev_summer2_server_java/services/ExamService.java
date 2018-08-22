package com.example.webdev_summer2_server_java.services;

import com.example.webdev_summer2_server_java.models.Exam;
import com.example.webdev_summer2_server_java.models.Topic;
import com.example.webdev_summer2_server_java.models.Widget;
import com.example.webdev_summer2_server_java.repositories.ExamRepository;
import com.example.webdev_summer2_server_java.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ExamService {

    @Autowired
    ExamRepository examRepository;

    @Autowired
    TopicRepository topicRepository;

    @PostMapping("/api/topic/{topicId}/exam")
    Exam createExam(@PathVariable("topicId") int topicId, @RequestBody Exam exam){
        if(topicRepository.findById(topicId).isPresent()){
            Topic topic = topicRepository.findById(topicId).get();
            exam.setWidgetType("Exam");
            exam.setTopic(topic);
            return examRepository.save(exam);
        }
        return null;
    }

    @GetMapping("/api/topic/{topicId}/exam")
    List<Exam> getExamForTopic(@PathVariable("topicId") int topicId){
        List<Exam> examList = new ArrayList<>();
        if(topicRepository.findById(topicId).isPresent()){
            Topic topic = topicRepository.findById(topicId).get();
            List<Widget> widgets = topic.getWidgets();
            for(Widget widget: widgets){
                if(widget.getWidgetType().equals("Exam"))
                    examList.add((Exam) widget);
            }
            return examList;
        }
        return null;
    }

    @DeleteMapping("/api/exam/{examId}")
    void deleteExam(@PathVariable("examId") int examId){
        if(examRepository.findById(examId).isPresent())
            examRepository.deleteById(examId);
    }
}
