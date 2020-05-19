package com.training.game.service.implementation;

import com.training.game.entity.HeroClass;
import com.training.game.repository.HeroClassRepository;
import com.training.game.service.HeroClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroClassServiceImplementation implements  HeroClassService {
    @Autowired
    HeroClassRepository heroClassRepository;

    @Override
    public List<HeroClass> findAll() {
        return heroClassRepository.findAll();
    }
}
