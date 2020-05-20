package com.training.game.controller;

import com.training.game.entity.Hero;
import com.training.game.entity.Monster;
import com.training.game.service.FightService;
import com.training.game.service.HeroService;
import com.training.game.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;
@Controller
public class FightController {
    @Autowired
    private HeroService heroService;
    @Autowired
    private MonsterService monsterService;
    @Autowired
    private FightService fightService;

    @GetMapping("/fight/{heroId}/{locationId}")
    public String getFight(Model model,
                           @PathVariable(name = "heroId") Long heroId,
                           @PathVariable(name = "locationId") Long monsterId){
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
        fightService.fight(hero, monster);



        List<Monster> monsters = monsterService.findAllByLocation(hero.getCurrentLocation().getId());
        List<Monster> monstersGang = monsterService.separateOneGang(monsters);
        Monster activeMonster = monstersGang.get((int)(Math.random()*monstersGang.size()));
        monstersGang.remove(activeMonster);
        model.addAttribute("hero" , hero);
        model.addAttribute("monster" , hero);
        model.addAttribute("monstersGang" , monstersGang);
        return "hero";
    }
}
