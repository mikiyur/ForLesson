package com.training.game;

import com.training.game.entity.*;
import com.training.game.repository.HeroRepository;
import com.training.game.repository.MonsterRepository;
import com.training.game.service.HeroService;
import com.training.game.service.LocationService;
import com.training.game.service.MonsterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class GameApplication {



    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(GameApplication.class, args);

//        Hero hero1 = new Hero();
//        Hero hero2 = new Hero();
//        hero1.setName("Yura");
//        hero2.setName("Oleg");
//
//        HeroClass mag = new HeroClass();
//        mag.setName("Mag");
//        mag.addHero(hero1);
//        mag.addHero(hero2);
//
//
//        Potion potion1 = new Potion();
//        potion1.setName("BigHeath");
//        Artifact artifact1 = new Artifact();
//        artifact1.setName("Axe");
//
//
//        hero1.getInventory().addArtifact(artifact1);
//        hero1.getInventory().addPotion(potion1);

//        Monster monster = new Monster();
//        monster.setName("firstMoster");
//        monster.setMaxHealthPoint(100);


        HeroService heroService = run.getBean(HeroService.class);
//        Hero hero1 = heroService.getHeroLikeFTLazy(1l);
//        List <Hero> heroList = heroService.findAllByUserNull();

//        System.out.println(heroList);



//        System.out.println( heroService.findById(1l).getSpellBook());
//        heroService.save(hero1);
//        System.out.println(heroService.findById(2l).getInventory());

    }

}
