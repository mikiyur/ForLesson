package com.training.game.dto;

import com.training.game.entity.Hero;
import com.training.game.entity.HeroClass;

public class HeroDTO {
    private Long id;
    private String name;

    private float maxHealthPoint;

    private float currentHealthPoint;

    private float currentManaPoint;

    private float maxManaPoint;

    private float power;

    public HeroDTO(Hero hero) {
        this.id = hero.getId();
        this.name = hero.getName();
        this.maxHealthPoint = hero.getMaxHealthPoint();
        this.currentHealthPoint = hero.getCurrentHealthPoint();
        this.currentManaPoint = hero.getCurrentManaPoont();
        this.maxManaPoint = hero.getMaxManaPoont();
        this.power = hero.getPover();
    }

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

    public float getCurrentManaPoint() {
        return currentManaPoint;
    }

    public void setCurrentManaPoint(float currentManaPoint) {
        this.currentManaPoint = currentManaPoint;
    }

    public float getMaxManaPoint() {
        return maxManaPoint;
    }

    public void setMaxManaPoint(float maxManaPoint) {
        this.maxManaPoint = maxManaPoint;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }
}
