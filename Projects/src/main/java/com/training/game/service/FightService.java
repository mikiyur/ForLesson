package com.training.game.service;

import com.training.game.entity.Hero;
import com.training.game.entity.Monster;

import java.util.List;

public interface FightService {
    void attack (Hero hero, Monster monster);

    void heroDied(Hero hero, List<Monster> monstersGang);

    void heroWon(Hero hero, List<Monster> monstersGang);

}
