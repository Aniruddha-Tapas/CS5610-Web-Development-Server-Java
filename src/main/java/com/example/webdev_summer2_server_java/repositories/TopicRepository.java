package com.example.webdev_summer2_server_java.repositories;

import com.example.webdev_summer2_server_java.models.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Integer> {
}
