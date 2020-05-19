package com.training.game.service.implementation;

import com.training.game.entity.Monster;
import com.training.game.repository.MonsterRepository;
import com.training.game.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonsterServiceImplementation implements MonsterService {
    @Autowired
    private MonsterRepository monsterRepository;

    @Override
    public Monster save(Monster monster) { return monsterRepository.save(monster);
    }

    @Override
    public Monster getOne(Long id) {
        return monsterRepository.getOne(id);
    }

    @Override
    public Monster findById(Long id) {
        return monsterRepository.findById(id).get();
    }
}
