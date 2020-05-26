package com.training.game.repository;

import com.training.game.entity.Monster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface MonsterRepository extends JpaRepository<Monster, Long> {
    List <Monster> findAllByLocation (Long id);
    List <Monster> findAllByLocationNull ();
    Monster removeById (Long id);
}
