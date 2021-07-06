package com.example.tdd.service;

import com.example.tdd.database.TaskListDatabase;
import com.example.tdd.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskListService {

    private final TaskListDatabase taskListDatabase;

    public TaskListService(TaskListDatabase taskListDatabase) {
        this.taskListDatabase = taskListDatabase;
    }

    public List<Task> all() {
        return this.taskListDatabase.get();
    }

    public Task find(int id) {
        return this.taskListDatabase.find(id);
    }

    public void save(Task todo) {
        this.taskListDatabase.save(todo);
    }

    public void update(Task todo, int id) {
        this.taskListDatabase.update(todo, id);
    }

    public void delete(int id) {
        this.taskListDatabase.delete(id);
    }

}
