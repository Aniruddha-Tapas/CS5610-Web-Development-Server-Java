package com.example.webdev_summer2_server_java.repositories;

import com.example.webdev_summer2_server_java.models.Widget;
import org.springframework.data.repository.CrudRepository;

public interface WidgetRepository extends CrudRepository<Widget, Integer>{
}
