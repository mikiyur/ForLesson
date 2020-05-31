package com.training.game.dto;

import com.training.game.entity.Hero;
import com.training.game.entity.HeroClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeroDTO {
    private Long id;
    private String name;
    private String fightLog;
    private String fightLogMonster;
    private String pictureURL;
    private float maxHealthPoint;
    private float currentHealthPoint;
    private float currentManaPoint;
    private float maxManaPoint;
    private float power;
    private float defence = 1;
    private float spellPower = 1;
    private float criticalAttack = 0; //%
    private float chanceCriticalAttack = 0; //0-75%
    private float chanceDodge = 0; //0-75%
    private int level = 1;
    private int levelProgress = -100;
    private int skillPoint = 5;
    private int spellPoint = 1; //to improving own spells

    public HeroDTO(Hero hero) {
        this.id = hero.getId();
        this.name = hero.getName();
        this.fightLog = hero.getFightLog();
        this.fightLogMonster = hero.getFightLogMonster();
        this.pictureURL = hero.getPictureURL();
        this.maxHealthPoint = hero.getMaxHealthPoint();
        this.currentHealthPoint = hero.getCurrentHealthPoint();
        this.currentManaPoint = hero.getCurrentManaPoint();
        this.maxManaPoint = hero.getMaxManaPoint();
        this.power = hero.getPower();
        this.defence = hero.getDefence();
        this.spellPower = hero.getSpellPower();
        this.criticalAttack = hero.getCriticalAttack();
        this.chanceCriticalAttack = hero.getChanceCriticalAttack();
        this.chanceDodge = hero.getChanceDodge();
        this.level = hero.getLevel();
        this.levelProgress = hero.getLevelProgress();
        this.skillPoint = hero.getSkillPoint();
        this.spellPoint = hero.getSpellPoint();
    }
}
