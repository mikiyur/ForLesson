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
        this.currentManaPoint = hero.getCurrentManaPoint();
        this.maxManaPoint = hero.getMaxManaPoint();
        this.power = hero.getPower();
    }

    public Long getId() {
        return id;
    }


}
