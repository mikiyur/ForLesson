package com.training.game.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/newhero")
    public String newhero(){
        return "newhero";
    }

}
