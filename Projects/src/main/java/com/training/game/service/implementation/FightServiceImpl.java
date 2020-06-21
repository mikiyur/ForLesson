package com.training.game.service.implementation;

import com.training.game.entity.Hero;
import com.training.game.entity.Monster;
import com.training.game.service.FightService;
import com.training.game.service.HeroClassService;
import com.training.game.service.HeroService;
import com.training.game.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FightServiceImpl implements FightService {
    @Autowired
    HeroService heroService;
    @Autowired
    MonsterService monsterService;


    @Override
    public void attack(Hero hero, Monster monster) {
        hero.setFightLog(" ");
        hero.setFightLogMonster(" ");
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
            hero.setFightLog(hero.getName() + " attacked " + monster.getName() + " -->but " + monster.getName() + " dodges" + "\n");
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
        hero.setFightLog(hero.getName()+" attacked "+monster.getName()+ " --> and caused " + damage +" damage"+ hero.getFightLog());
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
    public void heroDied(Hero hero, List<Monster> monstersGang) {
    }

    @Override
    public void heroWon(Hero hero, List<Monster> monstersGang) {
        hero.setCurrentHealthPoint(hero.getMaxHealthPoint());
        hero.setCurrentManaPoint(hero.getMaxManaPoint());

        float sumMonstersLevels = 0;
        for (Monster monster : monstersGang) {
            if (monster.isBoss()){
                sumMonstersLevels += monster.getLevel()*3;
            }else{
                sumMonstersLevels += monster.getLevel();
            }
        }
        int receivedCoins = (int)addRandomFortyPercent(sumMonstersLevels*2);
        hero.getInventory().setCoins(hero.getInventory().getCoins() + receivedCoins);
        int receivedExperience = (int)addRandomFortyPercent(sumMonstersLevels*5);
        heroAddExperience (hero, receivedExperience);
    }

    private void heroAddExperience(Hero hero, int receivedExperience) {
        for (int i = receivedExperience; i > 0; i--){
            hero.setLevelProgress(hero.getLevelProgress()+1);
            if (hero.getLevelProgress() >= 0){
                heroLevelUp(hero);
            }
        }
    }

    private void heroLevelUp(Hero hero) {
        hero.setLevel(hero.getLevel()+1);
        hero.setLevelProgress(-(80 + (hero.getLevel() * 20) + (hero.getLevel() * hero.getLevel())));
        hero.setSkillPoint(hero.getSkillPoint()+3);
        if (hero.getLevel()%3==0) {
            hero.setSpellPoint(hero.getSpellPoint()+1);
        }
    }


}
