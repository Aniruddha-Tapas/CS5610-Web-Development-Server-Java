package com.example.wedevsummer2assignment1.services;

import com.example.wedevsummer2assignment1.models.Course;
import com.example.wedevsummer2assignment1.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @PostMapping("/api/course")
    Course createCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @DeleteMapping("/api/course/{courseId}")
    public void deleteCourse(@PathVariable("courseId") int courseId){
        if(courseRepository.findById(courseId).isPresent()){
            courseRepository.deleteById(courseId);
        }
    }

    @GetMapping("/api/course")
    public List<Course> findallCourses(){
        return (List<Course>) courseRepository.findAll();
    }

    @GetMapping("/api/course/{courseId}")
    public Course findCourseById(@PathVariable("courseId") int courseId){
        if (courseRepository.findById(courseId).isPresent()) {
            return courseRepository.findById(courseId).get();
        }
        return null;
    }

    @PutMapping("api/course/{courseId}")
    public Course updateCourse(@PathVariable("courseId") int courseId,
                        @RequestBody Course newCourse){
        if(courseRepository.findById(courseId).isPresent()){
            Course course = courseRepository.findById(courseId).get();
            course.setCourse(newCourse);
            return courseRepository.save(course);
        }
        return null;
    }
}
