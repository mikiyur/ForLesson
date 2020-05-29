package com.training.game.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class HeroClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pictureURL;
    private String name;
    @Column(precision = 2)
    private float maxHealthPerSkillPoint;
    @Column(precision = 2)
    private float maxManaPerSkillPoint;
    @Column(precision = 2)
    private float powerPerSkillPoint;
    @Column(precision = 2)
    private float spellPowerPerSkillPoint;
    @Column(precision = 2)
    private float defencePerSkillPoint;
    @Column(precision = 2)
    private float criticalAttackPerSkillPoint;
    @Column(precision = 2)
    private float chanceCriticalAttackPerSkillPoint;
    @Column(precision = 2)
    private float chanceDodgePerSkillPoint;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "heroClass", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter(AccessLevel.PRIVATE)
    private List<Hero> heroes = new ArrayList<Hero>();

    public void addHero(Hero hero) {
        heroes.add(hero);
        hero.setHeroClass(this);
    }

}
