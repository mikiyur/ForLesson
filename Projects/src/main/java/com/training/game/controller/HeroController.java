package com.training.game.controller;


import com.training.game.entity.Hero;
import com.training.game.entity.Monster;
import com.training.game.service.HeroService;
import com.training.game.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HeroController {

    @Autowired
    private HeroService heroService;
    @Autowired
    private MonsterService monsterService;


    @GetMapping("/fight/{heroId}/{monsterId}")
    public String getFight(Model model,
                           @PathVariable(name = "heroId") Long heroId,
                           @PathVariable(name = "monsterId") Long monsterId){
        model.addAttribute("hero" , heroService.getOne(heroId));
        model.addAttribute("monster" , monsterService.getOne(monsterId));
        return "hero";
    }

    @PostMapping("/fight/{heroId}/{monsterId}")
    public String fight(Model model,
                        @PathVariable(name = "heroId") Long heroId,
                        @PathVariable(name = "monsterId") Long monsterId) {
        Hero hero = heroService.getOne(heroId);
        Monster monster = monsterService.getOne(monsterId);
        hero.setCurrentHealthPoint(hero.getCurrentHealthPoint()-monster.getPower());
        monster.setCurrentHealthPoint(monster.getCurrentHealthPoint()-hero.getPower());
        heroService.save(hero);
//        monsterService.save(monster);
        model.addAttribute("hero" , hero);
        model.addAttribute("monster" , monster);
        return "hero";
    }

}
