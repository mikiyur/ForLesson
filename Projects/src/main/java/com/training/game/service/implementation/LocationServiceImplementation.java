package com.training.game.service.implementation;

import com.training.game.entity.Location;
import com.training.game.repository.LocationRepository;
import com.training.game.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImplementation implements LocationService {
    @Autowired
    LocationRepository locationRepository;

    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location findById(Long id) {
        return locationRepository.findById(id).get();
    }
}
