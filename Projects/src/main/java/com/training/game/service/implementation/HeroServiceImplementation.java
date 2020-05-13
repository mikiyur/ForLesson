package com.training.game.service.implementation;

import com.training.game.entity.Hero;
import com.training.game.entity.SpellBook;
import com.training.game.repository.HeroRepository;
import com.training.game.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class HeroServiceImplementation implements HeroService {

    @Autowired
    private HeroRepository heroRepository;

    @Override
    public Hero save(Hero hero) {
        return heroRepository.save(hero);
    }

    @Override
    public Hero getOne(Long id) {return heroRepository.getOne(id);
    }
    @Override
    public Hero findById(Long id) {
        return heroRepository.findById(id).get() ;
    }


    @Transactional
    @Override
    public Hero getHeroLikeFTLazy(Long id) {
        Hero hero = heroRepository.getOne(id);
        hero.getSpellBook().getSpells().size();
        hero.getInventory().getArtifacts().size();
        hero.getInventory().getPotions().size();
        return hero;
    }

    @Override
    public List<Hero> findAllByUserNull() {
        return heroRepository.findAllByUserNull();
    }


}
