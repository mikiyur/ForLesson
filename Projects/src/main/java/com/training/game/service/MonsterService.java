package com.training.game.service;

import com.training.game.entity.Monster;

import java.util.List;

public interface MonsterService {
    Monster save (Monster monster);
    Monster getOne (Long id);
    Monster findById (Long id);
    Monster removeById (Long id);
    List <Monster> findAllByLocation(Long id);
    List <Monster> findAllByLocationNull ();
    List <Monster> separateOneGang (List <Monster> monsters);


}
