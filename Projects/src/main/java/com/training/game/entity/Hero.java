package com.training.game.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;



@Proxy(lazy=false)
@Entity
public class Hero {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private float maxHealthPoint;
    @Column
    private float currentHealthPoint;
    @Column
    private float currentManaPoont;
    @Column
    private float maxManaPoont;
    @Column
    private float pover;
    @Column
    private float spellPover;
    @Column
    private float defence;
    @Column
    private float chanceCriticalAttack;
    @Column
    private float chanceDodge;
    @Column
    private int level;
    @Column
    private int levelProgress;
    @Column
    private int skillPoint;

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn (name = "heroes", nullable = false)
    private HeroClass heroClass;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMaxHealthPoint() {
        return maxHealthPoint;
    }

    public void setMaxHealthPoint(float maxHealthPoint) {
        this.maxHealthPoint = maxHealthPoint;
    }

    public float getCurrentHealthPoint() {
        return currentHealthPoint;
    }

    public void setCurrentHealthPoint(float currentHealthPoint) {
        this.currentHealthPoint = currentHealthPoint;
    }

    public float getCurrentManaPoont() {
        return currentManaPoont;
    }

    public void setCurrentManaPoont(float currentManaPoont) {
        this.currentManaPoont = currentManaPoont;
    }

    public float getMaxManaPoont() {
        return maxManaPoont;
    }

    public void setMaxManaPoont(float maxManaPoont) {
        this.maxManaPoont = maxManaPoont;
    }

    public float getPover() {
        return pover;
    }

    public void setPover(float pover) {
        this.pover = pover;
    }

    public float getSpellPover() {
        return spellPover;
    }

    public void setSpellPover(float spellPover) {
        this.spellPover = spellPover;
    }

    public float getDefence() {
        return defence;
    }

    public void setDefence(float defence) {
        this.defence = defence;
    }

    public float getChanceCriticalAttack() {
        return chanceCriticalAttack;
    }

    public void setChanceCriticalAttack(float chanceCriticalAttack) {
        this.chanceCriticalAttack = chanceCriticalAttack;
    }

    public float getChanceDodge() {
        return chanceDodge;
    }

    public void setChanceDodge(float chanceDodge) {
        this.chanceDodge = chanceDodge;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevelProgress() {
        return levelProgress;
    }

    public void setLevelProgress(int levelProgress) {
        this.levelProgress = levelProgress;
    }

    public int getSkillPoint() {
        return skillPoint;
    }

    public void setSkillPoint(int skillPoint) {
        this.skillPoint = skillPoint;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name  +
                ", maxHealthPoint=" + maxHealthPoint +
                ", currentHealthPoint=" + currentHealthPoint +
                ", currentManaPoont=" + currentManaPoont +
                ", maxManaPoont=" + maxManaPoont +
                ", pover=" + pover +
                ", spellPover=" + spellPover +
                ", defence=" + defence +
                ", chanceCriticalAttack=" + chanceCriticalAttack +
                ", chanceDodge=" + chanceDodge +
                ", level=" + level +
                ", levelProgress=" + levelProgress +
                ", skillPoint=" + skillPoint +
                '}';
    }
}
