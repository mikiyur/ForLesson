package com.training.game.service;

import com.training.game.entity.Monster;

import java.util.List;

public interface MonsterService {
    Monster save (Monster monster);
    Monster getOne (Long id);
    Monster findById (Long id);
    void removeById (Long id);
    List <Monster> findAllByLocationId(Long id);
    List <Monster> findAllByLocationNull ();
    List <Monster> separateNextGang (List <Monster> monsters);
    List <Monster> separateTheGang (List<Monster> monsters, int gang);



}
