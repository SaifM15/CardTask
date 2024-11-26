package com.CardTask.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CardTask.Entity.SubTask;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
    List<SubTask> findByTaskIdAndDeletedFalse(Long taskId);
}
