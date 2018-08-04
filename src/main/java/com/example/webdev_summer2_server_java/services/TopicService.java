package com.example.webdev_summer2_server_java.services;

import com.example.webdev_summer2_server_java.models.Lesson;
import com.example.webdev_summer2_server_java.models.Topic;
import com.example.webdev_summer2_server_java.repositories.LessonRepository;
import com.example.webdev_summer2_server_java.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TopicService {

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    TopicRepository topicRepository;

    @PostMapping("/api/course/{courseId}/module/{moduleId}/lesson/{lessonId}/topic")
    Topic createTopic(@PathVariable(name="lessonId") int lessonId,
                        @RequestBody Topic topic){
        if(lessonRepository.findById(lessonId).isPresent()){
            Lesson lesson = lessonRepository.findById(lessonId).get();
            topic.setLesson(lesson);
            return topicRepository.save(topic);
        }
        return null;
    }

    @DeleteMapping("/api/topic/{topicId}")
    void deleteTopic(@PathVariable("topicId") int topicId){
        if (topicRepository.findById(topicId).isPresent()) {
            topicRepository.deleteById(topicId);
        }
    }

    @GetMapping("/api/topic")
    List<Topic> findAllTopics(){
        return (List<Topic>) topicRepository.findAll();
    }

    @GetMapping("/api/topic/{topicId}")
    Topic findTopicById(@PathVariable("topicId") int topicId){
        if (topicRepository.findById(topicId).isPresent())
            return topicRepository.findById(topicId).get();
        return null;
    }

    @GetMapping("/api/course/{courseId}/module/{moduleId}/lesson/{lessonId}/topic")
    List<Topic> findAllTopicsForLesson(@PathVariable(name="lessonId") int lessonId){
        if(lessonRepository.findById(lessonId).isPresent()){
            Lesson lesson = lessonRepository.findById(lessonId).get();
            return lesson.getTopics();
        }
        return null;
    }

    @PutMapping("/api/topic/{topicId}")
    Topic updateTopic(@PathVariable("topicId") int topicId,
                        @RequestBody Topic newTopic){
        if(topicRepository.findById(topicId).isPresent()){
            Topic topic = topicRepository.findById(topicId).get();
            topic.setTopic(newTopic);
            return topicRepository.save(topic);
        }
        return null;
    }
}
