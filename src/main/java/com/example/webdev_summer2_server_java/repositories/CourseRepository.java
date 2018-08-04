package com.example.webdev_summer2_server_java.repositories;

import com.example.webdev_summer2_server_java.models.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer>{
}
