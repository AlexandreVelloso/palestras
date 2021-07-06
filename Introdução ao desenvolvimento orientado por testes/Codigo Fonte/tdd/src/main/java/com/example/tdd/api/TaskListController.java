package com.example.tdd.api;

import com.example.tdd.entity.Task;
import com.example.tdd.service.TaskListService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskListController {

    private final TaskListService taskListService;

    public TaskListController(TaskListService todoListService) {
        this.taskListService = todoListService;
    }

    @GetMapping("/tasks")
    public List<Task> all() {
        return this.taskListService.all();
    }

    @GetMapping("/tasks/{id}")
    public Task find(@PathVariable int id) {
        return this.taskListService.find(id);
    }

    @PostMapping("/tasks")
    public void save(@RequestBody Task todo) {
        this.taskListService.save(todo);
    }

    @PutMapping("/tasks/{id}")
    public void update(@RequestBody Task todo, @PathVariable int id) {
        this.taskListService.update(todo, id);
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable int id) {
        this.taskListService.delete(id);
    }

}
