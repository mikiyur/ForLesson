package com.training.game.controller;

import com.training.game.entity.Hero;
import com.training.game.entity.Monster;
import com.training.game.service.FightService;
import com.training.game.service.HeroService;
import com.training.game.service.MonsterGangComparator;
import com.training.game.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FightController {
    @Autowired
    private HeroService heroService;
    @Autowired
    private MonsterService monsterService;
    @Autowired
    private FightService fightService;

    @GetMapping("fight/{heroId}/{locationId}")
    public String getFight(Model model,
                           @PathVariable(name = "heroId") Long heroId,
                           @PathVariable(name = "locationId") Long locationId) {
        List<Monster> monsters = monsterService.findAllByLocationId(locationId);
        List<Monster> monstersGang = monsterService.separateNextGang(monsters);
        Monster activeMonster;
        do {
            activeMonster = monstersGang.get((int) (Math.random() * monstersGang.size()));
        } while (activeMonster.isDead());
        monstersGang.remove(activeMonster);
        model.addAttribute("hero", heroService.getOne(heroId));
        model.addAttribute("monster", activeMonster);
        model.addAttribute("monstersGang", monstersGang); //  no active monsters
        return "fight";
    }

    @GetMapping("fight/{heroId}/attack/{monsterId}")
    public String fight(@PathVariable(name = "heroId") Long heroId,
                        @PathVariable(name = "monsterId") Long monsterId) {
        Hero hero = heroService.getOne(heroId);
        Monster monster = monsterService.getOne(monsterId);
        Long locationId = monster.getLocation().getId();
        List<Monster> monsters = monsterService.findAllByLocationId(locationId);
//        List<Monster> monsters = monsterService.findAllByLocationId(hero.getCurrentLocation().getId());//to do!!!!!!!
        List<Monster> monstersGang = monsterService.separateTheGang(monsters, monster.getGang());
        fightService.attack(hero, monster);
        monsterService.save(monster);
        heroService.save(hero);

        if (hero.getCurrentHealthPoint() <= 0) {
            fightService.heroDied(hero, monstersGang);
            monsterService.save(monster);
            heroService.save(hero);
            return "hero-died";// ------------------------------------------------------------------- to do
        }

        if (monstersGang.stream().allMatch(x -> x.isDead())) {
            fightService.heroWon(hero, monstersGang);
            monsterService.save(monster);
            heroService.save(hero);
            return "hero-won";
        }
        return "redirect:/fight/{heroId}/"+locationId;
    }
}
