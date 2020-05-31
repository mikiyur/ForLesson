package com.training.game.service.implementation;

import com.training.game.entity.Hero;
import com.training.game.entity.Location;
import com.training.game.entity.Monster;
import com.training.game.entity.SpellBook;
import com.training.game.repository.HeroRepository;
import com.training.game.service.HeroClassService;
import com.training.game.service.HeroService;
import com.training.game.service.LocationService;
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
    @Autowired
    private LocationService locationService;

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


    @Override
    public List<Hero> findAllByUserNull() {
        return heroRepository.findAllByUserNull();
    }

    @Override
    public void setNewCurrentLocation(Hero hero, Location location) {
        location.setId(null);
        location.getMonsters().forEach(x-> x.setId(null));
        hero.setCurrentLocation(location);
        location.setCurrentHero(hero);
        locationService.save(location);
    }



}
