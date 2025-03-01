package com.todosync.services.interfaces;

import com.todosync.persistence.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    public List<Project> getAllProject();
    public Page<Project> getAllProject(Pageable pageable);
    public void save (Project project);
    public Project findOne(Long id);
    public void delete(Long id);
}
