package com.todo.sync.controllers;

import com.todo.sync.entities.Task;
import com.todo.sync.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

    @Controller
    @RequestMapping("/tasklist")
    public class TaskController {
        @Autowired
        private TaskService taskService;

        @GetMapping({"","/"})
        public String showTaskList (Model model) {
            List<Task> tasks = taskService.getAllTask();
            model.addAttribute("titulo", "Listado de Tareas");
            model.addAttribute("tasksList", tasks);
            return "pages/taskList";
        }
    }
