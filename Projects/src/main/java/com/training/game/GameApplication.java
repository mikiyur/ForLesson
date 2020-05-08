package com.training.game;

import com.training.game.controller.GetHero;
import com.training.game.controller.HeroController;
import com.training.game.dto.HeroDTO;
import com.training.game.entity.Hero;
import com.training.game.entity.HeroClass;
import com.training.game.repository.HeroRepository;
import com.training.game.service.HeroService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GameApplication {



    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(GameApplication.class, args);

//        Hero hero1 = new Hero();
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
//
//
//         heroService = run.getBean(HeroService.class);
//        heroRepository.save(hero1);
//        HeroService heroService = run.getBean(HeroService.class);

//        Hero hero = heroService.getOne(1L);

//        hero.setHeroClass(heroRepository.getOne(1L).getHeroClass());

GetHero newGet = new GetHero();
        System.out.println( newGet.getHero(1L));
//        System.out.println(hero.getHeroClass().getName());

    }

}
