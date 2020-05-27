package com.training.game.dto;

import com.training.game.entity.Monster;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MonsterDTO {

    private Long id;
    private int gang;
    private String name;
    private boolean boss;
    private boolean dead;
    private String pictureURL;
    private int level; // to coins and exp

    private float maxHealthPoint;

    private float maxManaPoint;

    private float currentHealthPoint;

    private float currentManaPoint;

    private float power;

    private float spellPower;

    private float defence;

    private float criticalAttack; //%

    private float chanceCriticalAttack; //% 0-75%

    private float chanceDodge; //% 0-75%

    public MonsterDTO(Monster monster) {
        this.id = monster.getId();
        this.gang = monster.getGang();
        this.name = monster.getName();
        this.boss = monster.isBoss();
        this.dead = monster.isDead();
        this.pictureURL = monster.getPictureURL();
        this.level = monster.getLevel();
        this.maxHealthPoint = monster.getMaxHealthPoint();
        this.maxManaPoint = monster.getMaxManaPoint();
        this.currentHealthPoint = monster.getCurrentHealthPoint();
        this.currentManaPoint = monster.getCurrentManaPoint();
        this.power = monster.getPower();
        this.spellPower = monster.getSpellPower();
        this.defence = monster.getDefence();
        this.criticalAttack = monster.getCriticalAttack();
        this.chanceCriticalAttack = monster.getChanceCriticalAttack();
        this.chanceDodge = monster.getChanceDodge();
    }
}
