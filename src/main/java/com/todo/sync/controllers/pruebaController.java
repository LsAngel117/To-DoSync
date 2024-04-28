package com.todo.sync.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pruebaController {

    @GetMapping("layout")
    public String inicio(){
        return "layouts/layoutPanel";
    }

    @GetMapping("dashboard")
    public String panel(){
        return "pages/panel";
    }

    /*@GetMapping("tasklist")
    public String taskList() {
        return "pages/taskList";
    }*/

    /*@GetMapping("lay")
    public String layo() {
        return "layouts/layout";
    }

    @GetMapping("cont")
    public String cont() {
        return "pages/content";
    }*/

    /*@GetMapping("frag")
    public String frag(){
        return "fragments/footer";
    }*/
}