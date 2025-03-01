package com.todosync.presentation.controller;

import com.todosync.persistence.entity.Project;
import com.todosync.persistence.entity.Task;
import com.todosync.services.interfaces.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class projectController {
    @Autowired
    private ProjectService projectService;

    @ModelAttribute("task")
    public Task getTask() {
        return new Task();
    }

    @GetMapping("projectlist")
    public String showProjectList(Model model) {
        Project project = new Project();
        List<Project> projects = projectService.getAllProject();
        model.addAttribute("titulo", "Listado de Proyectos");
        model.addAttribute("projectsList", projects);
        return "pages/projectList";
    }

    @PostMapping("addProject")
    public String addProject(@Valid @ModelAttribute("project") Project project, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Nuevo proyecto");
            List<Project> projects = projectService.getAllProject();
            model.addAttribute("projects", projects);
            model.addAttribute("project", project);
            return "pages/formProject";
        }
        projectService.save(project);
        System.out.println("Proyecto guardado con éxito");
        model.addAttribute("successMessage", "Proyecto guardado con éxito");
        return "redirect:/projectlist";
    }

    @GetMapping("editProject/{id}")
    public String editProject(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        Project project = projectService.findOne(id);
        if (project == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "El proyecto no existe");
            return "redirect:/projectlist";
        }
        model.addAttribute("titulo", "Editar Proyecto");
        model.addAttribute("project", project);
        return "pages/formProject";
    }

    @PostMapping("editProject")
    public String updateProject(@Valid @ModelAttribute("task") Project project, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Editar Proyecto");
            return "pages/formProject";
        }
        model.addAttribute("titulo", "Editar Proyecto");
        model.addAttribute("project", project);
        projectService.save(project);
        return "redirect:/projectlist";
    }

    @GetMapping("deleteProject/{id}")
    public String deleteProject(@PathVariable(value = "id") Long id, RedirectAttributes redirectAttributes) {
        if (id > 0) {
            projectService.delete(id);
            redirectAttributes.addFlashAttribute("successMessage", "Proyecto eliminada con éxito.");
        }
        return "redirect:/projectlist";
    }
}
