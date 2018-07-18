package com.example.wedevsummer2assignment1.services;

import com.example.wedevsummer2assignment1.models.Course;
import com.example.wedevsummer2assignment1.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/api/course")
    List<Course> findallCourses(){
        return (List<Course>) courseRepository.findAll();
    }

    @PostMapping("/api/course")
    Course createCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @DeleteMapping("/api/course/{courseId}")
    void deleteCourse(@PathVariable("courseId") int courseId){
        if(courseRepository.findById(courseId).isPresent()){
            courseRepository.deleteById(courseId);
        }
    }

    @GetMapping("/api/course/{courseId}")
    Course findCourseById(@PathVariable("courseId") int courseId){
        if (courseRepository.findById(courseId).isPresent()) {
            return courseRepository.findById(courseId).get();
        }
        return null;
    }

    @PutMapping("api/course/{courseId}")
    Course updateCourse(@PathVariable("courseId") int courseId,
                        @RequestBody Course newCourse){
        if(courseRepository.findById(courseId).isPresent()){
            Course course = courseRepository.findById(courseId).get();
            course.setCourse(newCourse);
            return courseRepository.save(course);
        }
        return null;
    }

}
