package com.training.game.service;

import com.training.game.entity.HeroClass;

import java.util.List;

public interface HeroClassService {
    List<HeroClass> findAll ();

    void save(HeroClass heroClass);

    void removeById(Long id);

    HeroClass findById(Long id);
}
