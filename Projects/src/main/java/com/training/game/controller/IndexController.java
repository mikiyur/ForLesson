package com.training.game.controller;

import com.training.game.dto.HeroDTO;
import com.training.game.entity.Hero;
import com.training.game.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @Autowired
    private HeroService heroService;

    @GetMapping ("/")
    public String index (){
        return "index";
    }
    @GetMapping("/fight/{heroId}")
    public String getFightJsp(Model model,
                              @PathVariable(name = "heroId") Long heroId){

        Hero hero = heroService.getOne(heroId);
        System.out.println(hero);
        System.out.println(hero.getHeroClass().getName());


        model.addAttribute("hero" ,new HeroDTO(hero));
        return "fight";
    }

}
