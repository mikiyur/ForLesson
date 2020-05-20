package com.training.game.repository;

import com.training.game.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findAllByCurrentHeroNull();
}
