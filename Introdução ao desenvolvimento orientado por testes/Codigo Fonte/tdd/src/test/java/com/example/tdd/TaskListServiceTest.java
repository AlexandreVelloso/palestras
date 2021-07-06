package com.example.tdd;

import com.example.tdd.database.TaskListDatabase;
import com.example.tdd.entity.Task;
import com.example.tdd.exception.ResourceNotFoundException;
import com.example.tdd.service.TaskListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class TaskListServiceTest {

    private TaskListDatabase database;
    private TaskListService service;

    @BeforeEach
    public void setUp() {
        database = mock(TaskListDatabase.class);
        service = new TaskListService(database);
    }

    @Test
    void shouldReturnAllTasks() {
        List<Task> tasks = Collections.singletonList(new Task(1, "Task", false));

        doReturn(tasks).when(database).get();

        List<Task> result = service.all();

        assertEquals(tasks.get(0).getId(), result.get(0).getId());
        verify(database, times(1)).get();
    }

    @Test
    void shouldFindATask() {
        Task task = new Task(1, "Task", false);

        doReturn(task).when(database).find(anyInt());

        Task result = service.find(1);

        assertEquals(task.getId(), result.getId());
        verify(database, times(1)).find(1);
    }

    @Test
    void shouldThrowExceptionWhenTaskNotFound() {
        doThrow(new ResourceNotFoundException("Task not found"))
                .when(database).find(anyInt());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            service.find(1);
        });

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains("Task not found"));
        verify(database, times(1)).find(1);
    }

    @Test
    void shouldSaveTask() {
        doNothing().when(database).save(any(Task.class));

        Task task = new Task();
        service.save(task);

        verify(database, times(1)).save(task);
    }

    @Test
    void shouldUpdateTask() {
        Task task = new Task(1, "Task", false);

        doReturn(task).when(database).find(anyInt());
        doNothing().when(database).update(task, 1);

        service.update(task, 1);
        verify(database, times(1)).update(task, 1);
    }

    @Test
    void shouldThrowErrorWhenTryUpdateTaskThatDoesNotExist() {
        Task task = new Task(1, "Task", false);

        doThrow(new ResourceNotFoundException("Task not found"))
                .when(database).update(task, 1);

        assertThrows(ResourceNotFoundException.class, () -> {
            service.update(task, 1);
        });

        verify(database, times(1)).update(task, 1);
    }

    @Test
    void shouldDeleteTask() {
        doNothing().when(database).delete(1);

        database.delete(1);

        verify(database, times(1)).delete(1);
    }
}
