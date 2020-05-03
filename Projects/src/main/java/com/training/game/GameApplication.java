package com.training.game;

import com.training.game.controller.HeroController;
import com.training.game.dto.HeroDTO;
import com.training.game.entity.Hero;
import com.training.game.repository.HeroRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GameApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(GameApplication.class, args);


//        Hero hero2 = new Hero();
//        Hero hero3 = new Hero();
//        HeroClass mag = new HeroClass();
//        mag.setName("Mag");
//
//        hero1.setName("Yura");
//        hero2.setName("Oleg");
//        hero3.setName("Vasia");
//        hero1.setHeroClass(mag);
//        hero2.setHeroClass(mag);
//        hero3.setHeroClass(mag);
//
//        List <Hero> heroes = new ArrayList<Hero>();
//        heroes.add(hero1);
//        heroes.add(hero2);
//        heroes.add(hero3);
//        mag.setHeroes(heroes);


        HeroRepository heroRepository = run.getBean(HeroRepository.class);

        Hero hero =  heroRepository.getOne(1L);
        hero.setHeroClass(heroRepository.getOne(1L).getHeroClass());

        System.out.println(hero);
        System.out.println(hero.getHeroClass().getName());

    }

}
