package com.training.game.service;

import com.training.game.entity.Location;

import java.util.List;

public interface LocationService {
    Location save (Location location);
    void deleteById (Long id);
    Location findById (Long id);
    List <Location> findAllLocation ();
}
