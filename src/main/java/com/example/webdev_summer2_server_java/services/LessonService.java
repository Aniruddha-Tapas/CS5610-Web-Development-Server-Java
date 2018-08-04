package com.example.webdev_summer2_server_java.services;

import com.example.webdev_summer2_server_java.models.Lesson;
import com.example.webdev_summer2_server_java.models.Module;
import com.example.webdev_summer2_server_java.repositories.LessonRepository;
import com.example.webdev_summer2_server_java.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class LessonService {

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    LessonRepository lessonRepository;

    @PostMapping("/api/course/{courseId}/module/{moduleId}/lesson")
    Lesson createLesson(@PathVariable(name="moduleId") int moduleId,
                        @RequestBody Lesson lesson){
        if(moduleRepository.findById(moduleId).isPresent()){
            Module module = moduleRepository.findById(moduleId).get();
            lesson.setModule(module);
            return lessonRepository.save(lesson);
        }
        return null;
    }

    @DeleteMapping("/api/lesson/{lessonId}")
    void deleteLesson(@PathVariable("lessonId") int lessonId){
        if (lessonRepository.findById(lessonId).isPresent()) {
            lessonRepository.deleteById(lessonId);
        }
    }

    @GetMapping("/api/lesson")
    List<Lesson> findAllLessons(){
        return (List<Lesson>) lessonRepository.findAll();
    }

    @GetMapping("/api/lesson/{lessonId}")
    Lesson findLessonById(@PathVariable("lessonId") int lessonId){
        if (lessonRepository.findById(lessonId).isPresent())
            return lessonRepository.findById(lessonId).get();
        return null;
    }

    @GetMapping("/api/course/{courseId}/module/{moduleId}/lesson")
    List<Lesson> findAllLessonForModule(@PathVariable(name="moduleId") int moduleId){
        if(moduleRepository.findById(moduleId).isPresent()){
            Module module = moduleRepository.findById(moduleId).get();
            return module.getLessons();
        }
        return null;
    }

    @PutMapping("/api/lesson/{lessonId}")
    Lesson updateLesson(@PathVariable("lessonId") int lessonId,
                        @RequestBody Lesson newLesson){
        if(lessonRepository.findById(lessonId).isPresent()){
            Lesson lesson = lessonRepository.findById(lessonId).get();
            lesson.setLesson(newLesson);
            return lessonRepository.save(lesson);
        }
        return null;
    }
}
