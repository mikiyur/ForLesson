package com.training.game.controller;

import com.training.game.entity.HeroClass;
import com.training.game.service.HeroClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HeroClassController {
    @Autowired
    HeroClassService heroClassService;

    @GetMapping ("/heroclasses")
    public String getHeroClasses (Model model){
        model.addAttribute("heroclasses", heroClassService.findAll());
        return "hero";
    }
}
