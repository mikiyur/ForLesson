package com.training.game.controller;

import com.google.gson.Gson;
import com.training.game.dto.HeroDTO;
import com.training.game.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HeroController {

    @Autowired
   private HeroService heroService;

    @GetMapping("/getOneHero/{id}")
    @ResponseBody
    public String getOne(@PathVariable(name = "id") Long id) {
        Gson gson = new Gson();
        return gson.toJson(new HeroDTO(heroService.getOne(id)));


    }

}
