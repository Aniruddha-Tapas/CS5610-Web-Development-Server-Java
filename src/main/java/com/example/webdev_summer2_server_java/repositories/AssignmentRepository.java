package com.example.webdev_summer2_server_java.repositories;

import com.example.webdev_summer2_server_java.models.Assignment;
import org.springframework.data.repository.CrudRepository;

public interface AssignmentRepository extends CrudRepository<Assignment, Integer> {
}
