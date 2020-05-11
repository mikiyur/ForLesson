package com.training.game.repository;

import com.training.game.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface HeroRepository extends JpaRepository <Hero, Long> {
    Hero findHeroById (Long id);


}
