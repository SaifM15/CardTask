package com.CardTask.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CardTask.Entity.Task;
import com.CardTask.Repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(Long userId) {
        return taskRepository.findByUserIdAndDeletedFalse(userId);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Task task) {
        task.setDeleted(true);
        taskRepository.save(task);
    }
}
