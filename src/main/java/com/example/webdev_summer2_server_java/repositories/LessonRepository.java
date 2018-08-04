package com.example.webdev_summer2_server_java.repositories;

import com.example.webdev_summer2_server_java.models.Lesson;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {
}
