package com.training.game.repository;

import com.training.game.entity.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface MonsterRepository extends JpaRepository<Monster, Long> {
}
