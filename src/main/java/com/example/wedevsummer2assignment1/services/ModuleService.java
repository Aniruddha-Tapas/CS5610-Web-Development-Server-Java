package com.example.wedevsummer2assignment1.services;

import com.example.wedevsummer2assignment1.models.Course;
import com.example.wedevsummer2assignment1.models.Module;
import com.example.wedevsummer2assignment1.repositories.CourseRepository;
import com.example.wedevsummer2assignment1.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ModuleService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ModuleRepository moduleRepository;

    @PostMapping("/api/course/{courseId}/module")
    public Module createModule(@PathVariable("courseId") int courseId,
                        @RequestBody Module module){
        if(courseRepository.findById(courseId).isPresent()){
            Course course = courseRepository.findById(courseId).get();
            module.setCourse(course);
            return moduleRepository.save(module);
        }
        return null;
    }

    @DeleteMapping("/api/module/{moduleId}")
    public void deleteModule(@PathVariable("moduleId") int moduleId){
        if(moduleRepository.findById(moduleId).isPresent()) {
            moduleRepository.deleteById(moduleId);
        }
    }

    @GetMapping("/api/module")
    List<Module>  findAllModules(){
        return (List<Module>) moduleRepository.findAll();
    }

    @GetMapping("/api/module/{moduleId}")
    Module findModuleById(@PathVariable("moduleId") int moduleId){
        if (moduleRepository.findById(moduleId).isPresent())
            return moduleRepository.findById(moduleId).get();
        return null;
    }

    @GetMapping("/api/course/{courseId}/module")
    List<Module> findAllModuleForCourse(@PathVariable("courseId") int courseId){
        if(courseRepository.findById(courseId).isPresent()){
            Course course = courseRepository.findById(courseId).get();
            return course.getModules();
        }
        return null;
    }

    @PutMapping("/api/module/{moduleId}")
    Module updateModule(@PathVariable("moduleId") int moduleId,
                        @RequestBody Module newModule){
        if(moduleRepository.findById(moduleId).isPresent()){
            Module module = moduleRepository.findById(moduleId).get();
            module.setModule(newModule);
            return moduleRepository.save(module);
        }
        return null;
    }
}