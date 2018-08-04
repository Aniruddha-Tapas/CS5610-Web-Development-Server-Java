package com.example.webdev_summer2_server_java.services;

import com.example.webdev_summer2_server_java.models.Topic;
import com.example.webdev_summer2_server_java.models.Widget;
import com.example.webdev_summer2_server_java.repositories.TopicRepository;
import com.example.webdev_summer2_server_java.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetService {

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    WidgetRepository widgetRepository;

    @GetMapping("/api/widget")
    List<Widget> findAllWidget(){
        return (List<Widget>) widgetRepository.findAll();
    }

    @GetMapping("/api/widget/{widgetId}")
    Widget findWidgetById(@PathVariable("widgetId") int widgetId){
        if(widgetRepository.findById(widgetId).isPresent()){
            return widgetRepository.findById(widgetId).get();
        }
        return null;
    }

    @GetMapping("/api/topic/{topicId}/widget")
    List<Widget> findAllWidgetForTopic(@PathVariable("topicId") int topicId){
        if(topicRepository.findById(topicId).isPresent()){
            Topic topic = topicRepository.findById(topicId).get();
            return topic.getWidgets();
        }
        return null;
    }

    @PostMapping("/api/topic/{topicId}/widget")
    public void createWidget(@PathVariable("topicId") int topicId,
                             @RequestBody List<Widget> widgets) {

        if (topicRepository.findById(topicId).isPresent()) {
            Topic topic = topicRepository.findById(topicId).get();
            List<Widget> w = topic.getWidgets();

            for (Widget widget : w) {
                widgetRepository.deleteById(widget.getId());
            }

            for (Widget widget : widgets) {
                widget.setTopic(topic);
                widgetRepository.save(widget);
            }
            topic.setWidgets(widgets);

        }
    }

    @PutMapping("/api/widget/{widgetId}")
    Widget updateWidget(@PathVariable("widgetId") int widgetId,
                        @RequestBody Widget newWidget){
        if(widgetRepository.findById(widgetId).isPresent()){
            Widget widget = widgetRepository.findById(widgetId).get();
            widget.setWidget(newWidget);
            return widgetRepository.save(widget);
        }
        return null;
    }

    @DeleteMapping("/api/widget/{widgetId}")
    void deleteWidgetById(@PathVariable("widgetId") int widgetId){
        if(widgetRepository.findById(widgetId).isPresent())
            widgetRepository.deleteById(widgetId);
    }
    
}