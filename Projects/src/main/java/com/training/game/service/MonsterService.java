package com.training.game.service;

import com.training.game.entity.Monster;

public interface MonsterService {
    Monster save (Monster monster);
    Monster getOne (Long id);
    Monster findById (Long id);
}
