package com.example.webdev_summer2_server_java.services;

import com.example.webdev_summer2_server_java.models.Assignment;
import com.example.webdev_summer2_server_java.models.Topic;
import com.example.webdev_summer2_server_java.models.Widget;
import com.example.webdev_summer2_server_java.repositories.AssignmentRepository;
import com.example.webdev_summer2_server_java.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AssignmentService {

    @Autowired
    AssignmentRepository assignmentRepository;

    @Autowired
    TopicRepository topicRepository;

    @PostMapping("/api/topic/{topicId}/assignment")
    Assignment createAssignment(@PathVariable("topicId") int topicId, @RequestBody Assignment assignment){
        System.out.println("here");
        if(topicRepository.findById(topicId).isPresent()){
            Topic topic = topicRepository.findById(topicId).get();
            assignment.setWidgetType("Assignment");
            assignment.setTopic(topic);
            return assignmentRepository.save(assignment);
        }
        return null;
    }

    @GetMapping("/api/topic/{topicId}/assignment")
    List<Assignment> getAssignmentForTopic(@PathVariable("topicId") int topicId){
        List<Assignment> assignmentList = new ArrayList<>();
        if(topicRepository.findById(topicId).isPresent()){
            Topic topic = topicRepository.findById(topicId).get();
            List<Widget> widgets = topic.getWidgets();
            for(Widget widget: widgets){
                if(widget.getWidgetType().equals("Assignment"))
                    assignmentList.add((Assignment) widget);
            }
            return assignmentList;
        }
        return null;
    }

    @GetMapping("/api/assignment")
    List<Assignment> findAllAssignment(){
        return (List<Assignment>) assignmentRepository.findAll();
    }

    @GetMapping("/api/assignment/{assignmentId}")
    Assignment findAssignmentById(@PathVariable("assignmentId") int assignmentId){
        if(assignmentRepository.findById(assignmentId).isPresent())
            return assignmentRepository.findById(assignmentId).get();
        return null;
    }

    @PutMapping("/api/assignment/{assignmentId}")
    Assignment updateAssignment(@PathVariable("assignmentId") int assignmentId, @RequestBody Assignment newAssignment){
        if(assignmentRepository.findById(assignmentId).isPresent()){
            Assignment assignment = assignmentRepository.findById(assignmentId).get();
            assignment.updateAssignment(newAssignment);
            return assignmentRepository.save(assignment);
        }
        return null;
    }

    @DeleteMapping("/api/assignment/{assignmentId}")
    void deleteAssignmentById(@PathVariable("assignmentId") int assignmentId){
        if(assignmentRepository.findById(assignmentId).isPresent())
            assignmentRepository.deleteById(assignmentId);
    }
}
