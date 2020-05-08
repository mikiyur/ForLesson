package com.training.game.controller;

import com.training.game.entity.Hero;
import com.training.game.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GetHero {
    @Autowired
    private HeroService heroService;
    public  Hero getHero(Long heroId) {
        Hero hero = heroService.getOne(heroId);
        System.out.println(hero);
       return hero;
    }

}
