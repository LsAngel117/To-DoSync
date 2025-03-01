package com.todosync.presentation.controller;

import com.todosync.persistence.entity.Task;
import com.todosync.services.interfaces.TaskService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("tasklist")
    public String showTaskList(Model model) {
        List<Task> tasks = taskService.getAllTask();
        model.addAttribute("titulo", "Listado de Tareas");
        model.addAttribute("tasksList", tasks);
        model.addAttribute("task", new Task());
        return "pages/tasks/list";
    }

    @PostMapping("addTask")
    public String addTask(@Valid @ModelAttribute("task") Task task, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Nueva tarea");
            List<Task> tasks = taskService.getAllTask();
            model.addAttribute("addTask", tasks);
            return "pages/tasks/form";
        }
        taskService.save(task);
        System.out.println("Tarea creada con éxito");
        model.addAttribute("successMessage", "Tarea guardada con éxito");
        return "redirect:/tasks/list?success=true";
    }

    @GetMapping("editTask/{id}")
    public String editTask(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        Task task = taskService.findOne(id);
        if (task == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "La tarea no existe");
            return "redirect:/tasks/list";
        }
        model.addAttribute("titulo", "Editar Tarea");
        model.addAttribute("task", task);
        return "pages/tasks/form";
    }

    @PostMapping("editTask")
    public String updateTask(@Valid @ModelAttribute("task") Task task, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Editar Tarea");
            return "pages/tasks/form";
        }
        taskService.save(task);
        return "redirect:/tasks/list";
    }

    @GetMapping("deleteTask/{id}")
    public String deleteTask(@PathVariable(value = "id") Long id, RedirectAttributes redirectAttributes) {
        if (id > 0) {
            taskService.delete(id);
            redirectAttributes.addFlashAttribute("successMessage", "Tarea eliminada con éxito.");
        }
        return "redirect:/tasks/list";
    }
}
