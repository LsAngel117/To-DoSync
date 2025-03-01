package com.todosync.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthLoginController {

    @GetMapping({"/", "login"})
    public String login() {
        return "auth-login";
    }

    @RequestMapping("home")
    public String loginSubmit() {
        return "pages/panel";
    }
}
