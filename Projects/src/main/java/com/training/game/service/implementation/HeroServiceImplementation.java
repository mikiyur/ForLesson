package com.training.game.service.implementation;

import com.training.game.entity.Hero;
import com.training.game.repository.HeroRepository;
import com.training.game.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroServiceImplementation implements HeroService {

    @Autowired
    private HeroRepository heroRepository;

    @Override
    public Hero save(Hero hero) {
        return heroRepository.save(hero);
    }

    @Override
    public Hero getOne(Long id) {
        return heroRepository.getOne(id);
    }
}
