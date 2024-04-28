package com.todo.sync.services;

import com.todo.sync.entities.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService {
    public List<Task> getAllTask();
    public Page<Task> getAllTask(Pageable pageable);
    public void save (Task task);
    public Task findOne(Long id);
    public void delete(Long id);
}
