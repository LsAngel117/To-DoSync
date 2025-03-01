package com.todosync.services.implementation;

import com.todosync.persistence.entity.Task;
import com.todosync.persistence.repository.TaskRepository;
import com.todosync.services.exception.TaskNotFoundException;
import com.todosync.services.interfaces.TaskService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EntityManager entityManager;

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
    public Task findOne(Long id) throws TaskNotFoundException {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("La tarea con ID " + id + " no existe."));
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
