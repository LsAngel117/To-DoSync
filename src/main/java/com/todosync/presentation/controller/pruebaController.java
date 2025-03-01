package com.todosync.presentation.controller;

import com.todosync.persistence.entity.Project;
import com.todosync.persistence.entity.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class pruebaController {

    @ModelAttribute("task")
    public Task getTask() {
        return new Task();
    }

    @GetMapping("layout")
    public String inicio(Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        return "layouts/layoutPanel";
    }

    @GetMapping("dashboard")
    public String panel(Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        return "pages/dashboard";
    }

    @GetMapping("formTask")
    public String formTask(Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        return "pages/tasks/form";
    }

    @GetMapping("formProject")
    public String formProject(Model model){
        Project project = new Project();

        model.addAttribute("project", project);
        return "pages/formProject";
    }

    @GetMapping("calendar")
    public String appCalendar(Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        return "pages/calendar";
    }
}