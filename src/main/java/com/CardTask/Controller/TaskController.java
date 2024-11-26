package com.CardTask.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.CardTask.Entity.Task;
import com.CardTask.JWTutility.JwtUtil;
import com.CardTask.Service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public Task createTask(@RequestHeader("Authorization") String token, @RequestBody Task task) {
        validateToken(token); // Validate token before proceeding
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks(@RequestHeader("Authorization") String token, @RequestParam Long userId) {
        validateToken(token); // Validate token before proceeding
        return taskService.getAllTasks(userId);
    }

    @PutMapping("/{id}")
    public Task updateTask(@RequestHeader("Authorization") String token, @PathVariable Long id, @RequestBody Task task) {
        validateToken(token); // Validate token before proceeding
        task.setId(id);
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        validateToken(token); // Validate token before proceeding
        Task task = new Task();
        task.setId(id);
        taskService.deleteTask(task);
    }

    // Helper method for token validation
    private void validateToken(String token) {
        try {
            jwtUtil.extractUserId(token.replace("Bearer ", ""));
        } catch (Exception e) {
            throw new RuntimeException("Unauthorized: Invalid or expired token");
        }
    }
}
