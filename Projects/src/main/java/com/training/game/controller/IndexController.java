package com.training.game.controller;

import com.training.game.dto.HeroDTO;
import com.training.game.entity.Hero;
import com.training.game.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired
    private HeroService heroService;

    @GetMapping ("/")
    public String index(@RequestParam(name="title", required=false, defaultValue="Yura") String title, Model model) {
        model.addAttribute("title", title);
        return "index";
    }
}
