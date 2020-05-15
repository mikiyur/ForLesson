package com.training.game.repository;

import com.training.game.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface LocationRepository extends JpaRepository <Location, Long> {

}
