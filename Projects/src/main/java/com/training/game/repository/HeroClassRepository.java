package com.training.game.repository;

import com.training.game.entity.HeroClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroClassRepository extends JpaRepository <HeroClass, Long> {
}
