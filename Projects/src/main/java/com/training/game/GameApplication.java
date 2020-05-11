package com.training.game;

import com.training.game.entity.*;
import com.training.game.repository.HeroRepository;
import com.training.game.service.HeroService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GameApplication {



    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(GameApplication.class, args);

        Hero hero1 = new Hero();
        Hero hero2 = new Hero();
        hero1.setName("Yura");
        hero2.setName("Oleg");

        HeroClass mag = new HeroClass();
        mag.setName("Mag");
        mag.addHero(hero1);
        mag.addHero(hero2);

        hero1.setHeroClass(mag);
        hero2.setHeroClass(mag);


        Potion potion1 = new Potion();
        potion1.setName("BigHeath");
        Artifact artifact1 = new Artifact();
        artifact1.setName("Axe");

        Inventory inventory = new Inventory();
        inventory.addArtifact(artifact1);
        inventory.addPotion(potion1);

        artifact1.setInventory(inventory);
        potion1.setInventory(inventory);

        hero1.setInventory(inventory);
        inventory.setHero(hero1);


//
//
        HeroService heroService = run.getBean(HeroService.class);
//        heroService.save(hero1);
//        heroRepository.save(hero1);
//        HeroRepository heroRepository = run.getBean(HeroRepository.class);



//GetHero getHero = run.getBean(GetHero.class);
//Hero hero = getHero.getHero(1L);

        System.out.println(hero2.getClass() );
        System.out.println(hero2.getHeroClass().getName());

    }

}
