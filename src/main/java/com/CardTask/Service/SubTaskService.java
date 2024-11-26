package com.CardTask.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CardTask.Entity.SubTask;
import com.CardTask.Repository.SubTaskRepository;

@Service
public class SubTaskService {

    @Autowired
    private SubTaskRepository subTaskRepository;

    public SubTask createSubTask(SubTask subTask) {
        return subTaskRepository.save(subTask);
    }

    public List<SubTask> getAllSubTasks(Long taskId) {
        return subTaskRepository.findByTaskIdAndDeletedFalse(taskId);
    }

    public SubTask updateSubTask(SubTask subTask) {
        return subTaskRepository.save(subTask);
    }

    public void deleteSubTask(SubTask subTask) {
        subTask.setDeleted(true);
        subTaskRepository.save(subTask);
    }
}

