package com.example.webdev_summer2_server_java.repositories;

import com.example.webdev_summer2_server_java.models.Exam;
import org.springframework.data.repository.CrudRepository;

public interface ExamRepository extends CrudRepository<Exam, Integer> {
}
