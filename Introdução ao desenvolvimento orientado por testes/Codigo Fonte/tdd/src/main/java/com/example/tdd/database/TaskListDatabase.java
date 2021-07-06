package com.example.tdd.database;

import com.example.tdd.entity.Task;
import com.example.tdd.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskListDatabase {

    private final List<Task> tasks = new ArrayList<>();
    private int lastId = 0;

    public List<Task> get() {
        return tasks;
    }

    public Task find(int id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    }

    public void save(Task todo) {
        todo.setId(++this.lastId);
        tasks.add(todo);
    }

    public void update(Task todo, int id) {
        Task task = find(id);

        task.setName(todo.getName());
        task.setCompleted(todo.getCompleted());
    }

    public void delete(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

}