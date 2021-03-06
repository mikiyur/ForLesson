package com.training.game.service.implementation;

import com.training.game.entity.HeroClass;
import com.training.game.repository.HeroClassRepository;
import com.training.game.service.HeroClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroClassServiceImpl implements  HeroClassService {
    @Autowired
    HeroClassRepository heroClassRepository;

    @Override
    public List<HeroClass> findAll() {
        return heroClassRepository.findAll();
    }

    @Override
    public void save(HeroClass heroClass) {
        heroClassRepository.save(heroClass);
    }

    @Override
    public void removeById(Long id) {
        heroClassRepository.deleteById(id);
    }

    @Override
    public HeroClass findById(Long id) {
        return heroClassRepository.findById(id).get();
    }

}
