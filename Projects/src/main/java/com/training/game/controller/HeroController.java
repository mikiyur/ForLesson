package com.training.game.controller;


import com.training.game.entity.Hero;
import com.training.game.entity.Monster;
import com.training.game.service.HeroService;
import com.training.game.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class HeroController {

    @Autowired
    private HeroService heroService;
    @Autowired
    private MonsterService monsterService;


}
