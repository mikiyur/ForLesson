package com.training.game.service;

import com.training.game.entity.Location;

public interface LocationService {
    Location save (Location location);
    Location findById (Long id);
}
