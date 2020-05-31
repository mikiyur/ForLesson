package com.training.game.service.implementation;

import com.training.game.entity.Hero;
import com.training.game.entity.Monster;
import com.training.game.service.FightService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FightServiceImplementation implements FightService {
    @Override
    public void fight(Hero hero, Monster monster) {
        hero.setFightLogMonster(" ");
        hero.setFightLog(" ");
        heroAttack(hero, monster);
        if (monsterDied(monster)) {
            return;
        }
        monsterAttack(monster, hero);
    }


    private boolean monsterDied(Monster monster) {
        if (monster.getCurrentHealthPoint() <= 0) {
            monster.setCurrentHealthPoint(0);
            monster.setDead(true);
            return true;
        }
        return false;
    }


    private void heroAttack(Hero hero, Monster monster) {
        if (testChance(monster.getChanceDodge())) {
            hero.setFightLog(hero.getName() + " attacks " + monster.getName() + " -->but " + monster.getName() + " dodges" + "\n");
            return;
        }
        float damage = hero.getPower();
        if (testChance(hero.getChanceCriticalAttack())) {
            float criticalBonus = damage * hero.getCriticalAttack() / 100;
            damage += criticalBonus;
            hero.setFightLog(" CRITICAL ");
        }
        damage = addRandomFortyPercent(damage);
        damage = defend(damage, monster.getDefence());
        hero.setFightLog(hero.getName()+" attacks "+monster.getName()+ " --> and caused " + damage +" damage"+ hero.getFightLog());
        monster.setCurrentHealthPoint(monster.getCurrentHealthPoint() - damage);

    }


    private void monsterAttack(Monster monster, Hero hero) {
        if (testChance(hero.getChanceDodge())) {
            hero.setFightLogMonster(monster.getName() + " attacks " + hero.getName() + " -->but " + hero.getName() + " dodges" + "\n");
            return;
        }
        float damage = monster.getPower();
        if (testChance(monster.getChanceCriticalAttack())) {
            float criticalBonus = damage * monster.getCriticalAttack() / 100;
            damage = damage + criticalBonus;
            hero.setFightLogMonster(" CRITICAL ");
        }
        damage = addRandomFortyPercent(damage);
        damage = defend(damage, hero.getDefence());
        hero.setFightLogMonster(monster.getName()+" attacks "+hero.getName()+ " --> and caused " + damage +" damage "+ hero.getFightLogMonster());
        hero.setCurrentHealthPoint(hero.getCurrentHealthPoint() - damage);
    }

    private boolean testChance(float chance) {
        return (Math.random() * 100f) <= chance;
    }

    private float addRandomFortyPercent(float value) {
        return (float) ((Math.random() * 0.8f) + 0.6f) * value;

    }

    private float defend(float damage, float defence) {
        float damageMultiplier = 1f - ((0.05f * (defence)) / (0.9f + (0.08f * (defence))));
        damage = (damage * damageMultiplier) - (defence * 0.25f);
        if (damage < 1) {
            damage = 1;
        }
        return damage;
    }


    @Override
    public void heroIsLoser(Hero hero, List<Monster> monstersGang) {

    }

    @Override
    public void heroIsWinner(Hero hero, List<Monster> monstersGang) {

    }


}
