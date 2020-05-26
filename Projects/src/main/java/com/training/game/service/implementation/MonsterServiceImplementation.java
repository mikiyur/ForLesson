package com.training.game.service.implementation;

import com.training.game.entity.Monster;
import com.training.game.repository.MonsterRepository;
import com.training.game.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonsterServiceImplementation implements MonsterService {
    @Autowired
    private MonsterRepository monsterRepository;

    @Override
    public Monster save(Monster monster) {
        return monsterRepository.save(monster);
    }

    @Override
    public Monster getOne(Long id) {
        return monsterRepository.getOne(id);
    }

    @Override
    public Monster findById(Long id) {
        return monsterRepository.findById(id).get();
    }

    @Override
    public Monster removeById(Long id) { return monsterRepository.removeById(id); }

    @Override
    public List<Monster> findAllByLocation(Long id) {
        return monsterRepository.findAllByLocation(id);
    }

    @Override
    public List<Monster> findAllByLocationNull() {
        return monsterRepository.findAllByLocationNull();
    }

    @Override
    public List<Monster> separateOneGang(List<Monster> monsters) {
        List<Monster> monstersAfterFilter = monsters;
        for (int i =0; i <= 10; i++) {
            int iterator = i;
            monstersAfterFilter = monsters.stream().filter(x -> x.getGang() <= iterator)
                    .filter(x -> !x.isDead()).collect(Collectors.toList());
            if (monstersAfterFilter.size() > 0) break;
        }
        return monstersAfterFilter;
    }


}
