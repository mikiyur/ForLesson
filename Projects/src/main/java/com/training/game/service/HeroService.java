package com.training.game.service;

import com.training.game.entity.Hero;
import org.springframework.stereotype.Service;




public interface HeroService {
    public Hero save (Hero hero);
    public Hero getOne (Long Id);
}
