package com.training.game.service.implementation;

import com.training.game.entity.Monster;
import com.training.game.repository.MonsterRepository;
import com.training.game.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonsterServiceImpl implements MonsterService {
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
    public void removeById(Long id) {
        monsterRepository.deleteById(id);
    }

    @Override
    public List<Monster> findAllByLocationId(Long id) {
        return monsterRepository.findAllByLocationId(id);
    }

    @Override
    public List<Monster> findAllByLocationNull() {
        return monsterRepository.findAllByLocationNull();
    }

    @Override
    public List<Monster> separateNextGang(List<Monster> monsters) {
        List<Monster> separatedMonsters = new ArrayList<Monster>();
        for (int i = 1; i <= 9; i++) {
            int iterator = i;
            separatedMonsters = monsters.stream().filter(x -> x.getGang() <= iterator)
                    .collect(Collectors.toList());
            if (separatedMonsters.size() > 0) break;
        }
        return separatedMonsters;
    }

    @Override
    public List<Monster> separateTheGang(List<Monster> monsters, int gang) {
        List<Monster> separatedMonsters = new ArrayList<Monster>();
        monsters.forEach(monster -> {
                    if (monster.getGang() == gang) {
                        separatedMonsters.add(monster);
                    }
                });
        return separatedMonsters;
    }

}
