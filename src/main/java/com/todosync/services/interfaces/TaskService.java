package com.todosync.services.interfaces;

import com.todosync.persistence.entity.Task;
import com.todosync.services.exception.TaskNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService {
    public List<Task> getAllTask();
    public Page<Task> getAllTask(Pageable pageable);
    public void save (Task task);
    public Task findOne(Long id) throws TaskNotFoundException;
    public void delete(Long id);
}
