package com.todo.sync.services;

import com.todo.sync.entities.Task;
import com.todo.sync.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Page<Task> getAllTask(Pageable pageable) {
        return null;
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Task findOne(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
