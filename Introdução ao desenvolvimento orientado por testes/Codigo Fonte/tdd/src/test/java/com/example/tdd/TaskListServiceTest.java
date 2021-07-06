package com.example.tdd;

import com.example.tdd.database.TaskListDatabase;
import com.example.tdd.entity.Task;
import com.example.tdd.service.TaskListService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class TaskListServiceTest {

    @Test
    void shouldReturnAllTasks() {
        TaskListDatabase database = Mockito.mock(TaskListDatabase.class);
        TaskListService service = new TaskListService(database);

        List<Task> tasks = Collections.singletonList(new Task(1, "Task", false));

        Mockito.when(database.get())
                .thenReturn(tasks);

        List<Task> result = service.all();
        Assertions.assertEquals(tasks, result);
    }

}
