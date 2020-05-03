package com.training.game.dto;

import com.training.game.entity.Hero;
import com.training.game.entity.HeroClass;

public class HeroDTO {
    private Long id;
    private String name;
    private String heroClass;

    public HeroDTO(Hero hero) {
        this.id = hero.getId();
        this.name = hero.getName();
        this.heroClass = hero.getHeroClass().getName();
    }
    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
