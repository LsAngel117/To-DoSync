package com.todosync.services.implementation;

import com.todosync.persistence.entity.Project;
import com.todosync.persistence.repository.ProjectRepository;
import com.todosync.services.interfaces.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public Page<Project> getAllProject(Pageable pageable) {
        return null;
    }

    @Override
    public void save(Project project) {
        projectRepository.save(project);
    }

    @Override
    public Project findOne(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }
}
