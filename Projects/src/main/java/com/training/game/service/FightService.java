package com.training.game.service;

import com.training.game.entity.Hero;
import com.training.game.entity.Monster;

public interface FightService {
    void fight (Hero hero, Monster monster);
}
