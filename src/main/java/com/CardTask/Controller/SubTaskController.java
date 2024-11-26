package com.CardTask.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CardTask.Entity.SubTask;
import com.CardTask.Service.SubTaskService;

@RestController
@RequestMapping("/api/subtasks")
public class SubTaskController {

    @Autowired
    private SubTaskService subTaskService;

    @PostMapping
    public SubTask createSubTask(@RequestBody SubTask subTask) {
        return subTaskService.createSubTask(subTask);
    }

    @GetMapping
    public List<SubTask> getAllSubTasks(@RequestParam Long taskId) {
        return subTaskService.getAllSubTasks(taskId);
    }

    @PutMapping("/{id}")
    public SubTask updateSubTask(@PathVariable Long id, @RequestBody SubTask subTask) {
        subTask.setId(id);
        return subTaskService.updateSubTask(subTask);
    }

    @DeleteMapping("/{id}")
    public void deleteSubTask(@PathVariable Long id) {
        SubTask subTask = new SubTask();
        subTask.setId(id);
        subTaskService.deleteSubTask(subTask);
    }
}
