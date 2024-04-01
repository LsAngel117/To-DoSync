package com.todo.sync.controllers;

import com.todo.sync.entities.User;
import com.todo.sync.services.UserService;
import com.todo.sync.util.paginacion.pageRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping({"listar"})
    public String listarUsers(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 5);
        Page<User> users = userService.findAll(pageRequest);
        pageRender<User> PageRender = new pageRender<>("/listar", users);

        model.addAttribute("titulo", "Listado de usuarios");
        model.addAttribute("Usuarios",users);
        model.addAttribute("page", PageRender);

        return "listar";
    }
}
