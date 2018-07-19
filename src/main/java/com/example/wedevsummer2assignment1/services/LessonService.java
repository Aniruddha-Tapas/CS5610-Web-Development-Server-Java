package com.example.wedevsummer2assignment1.services;

import com.example.wedevsummer2assignment1.models.Lesson;
import com.example.wedevsummer2assignment1.models.Module;
import com.example.wedevsummer2assignment1.repositories.CourseRepository;
import com.example.wedevsummer2assignment1.repositories.LessonRepository;
import com.example.wedevsummer2assignment1.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class LessonService {

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    CourseRepository courseRepository;

    @PostMapping("/api/module/{moduleId}/lesson")
    Lesson createLesson(@PathVariable("moduleId") int moduleId,
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

    @GetMapping("/api//module/{moduleId}/lesson")
    List<Lesson> findAllLessonForModule(@PathVariable("moduleId") int moduleId){
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
