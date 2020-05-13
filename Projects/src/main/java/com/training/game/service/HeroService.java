package com.training.game.service;

import com.training.game.entity.Hero;
import com.training.game.entity.SpellBook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


public interface HeroService {
     Hero save (Hero hero);
     Hero getOne (Long id);
     Hero findById (Long id);
     Hero getHeroLikeFTLazy(Long id);
     Set<Hero> findAllByUserNull ();
}
