package com.training.game.service;

import com.training.game.entity.Hero;
import com.training.game.entity.Monster;

import java.util.List;

public interface FightService {
    void fight (Hero hero, Monster monster);

    void heroIsLoser(Hero hero, List<Monster> monstersGang);

    void heroIsWinner(Hero hero, List<Monster> monstersGang);

}
