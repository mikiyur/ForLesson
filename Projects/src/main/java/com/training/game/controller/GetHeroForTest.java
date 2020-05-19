package com.training.game.controller;

import com.training.game.entity.Hero;
import com.training.game.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Controller
public class GetHeroForTest {
    @Autowired
    private HeroService heroService;
    public  Hero getHero(Long heroId) {
        Hero hero = heroService.getOne(heroId);
        hero.getHeroClass().getChanceCriticalAttackPerSkillPoint();
//        System.out.println(hero.getHeroClass().getName());

       return hero;
    }

}
