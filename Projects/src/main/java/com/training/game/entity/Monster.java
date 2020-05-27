package com.training.game.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Monster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int gang;
    private String name;
    private boolean boss;
    private boolean dead = false;
    private String pictureURL;
    private int level; // to coins and exp4
    @Column(precision = 2)
    private float maxHealthPoint;
    @Column (precision = 2)
    private float maxManaPoint;
    @Column (precision = 2)
    private float currentHealthPoint;
    @Column (precision = 2)
    private float currentManaPoint;
    @Column (precision = 2)
    private float power;
    @Column (precision = 2)
    private float spellPower;
    @Column (precision = 2)
    private float defence;
    @Column (precision = 2)
    private float criticalAttack; //%
    @Column(precision = 2)
    private float chanceCriticalAttack; //% 0-75%
    @Column (precision = 2)
    private float chanceDodge; //% 0-75%

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name = "location_id")
    private Location location;

    public Monster(Monster monster) {
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
        this.location = monster.getLocation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return gang == monster.gang &&
                level == monster.level &&
                Float.compare(monster.maxHealthPoint, maxHealthPoint) == 0 &&
                Float.compare(monster.maxManaPoint, maxManaPoint) == 0 &&
                Float.compare(monster.power, power) == 0 &&
                Float.compare(monster.spellPower, spellPower) == 0 &&
                Float.compare(monster.defence, defence) == 0 &&
                Objects.equals(name, monster.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gang, name, level, maxHealthPoint, maxManaPoint, power, spellPower, defence);
    }
}
