package com.example.metaversestudyback.repository;

import com.example.metaversestudyback.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
//    Task findByTitle(String taskTitle);

    List<Task> findByCategoryId(Long categoryId);

    Task findByNameAndUserId(String taskName, Long userId);
}