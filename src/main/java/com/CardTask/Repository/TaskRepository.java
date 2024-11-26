package com.CardTask.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CardTask.Entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserIdAndDeletedFalse(Long userId);
}

