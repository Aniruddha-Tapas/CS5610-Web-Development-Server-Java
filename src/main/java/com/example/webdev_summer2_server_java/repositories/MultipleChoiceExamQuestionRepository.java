package com.example.webdev_summer2_server_java.repositories;

import com.example.webdev_summer2_server_java.models.MultipleChoiceExamQuestion;
import org.springframework.data.repository.CrudRepository;

public interface MultipleChoiceExamQuestionRepository extends CrudRepository<MultipleChoiceExamQuestion, Integer> {
}
