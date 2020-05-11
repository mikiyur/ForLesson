package com.training.game.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class Inventory {

    @Id
    @OneToOne
    @JoinColumn (name = "hero_id")
    private Hero hero;

    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "inventory")
    private List <Artifact> artifacts;

    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "inventory")
    private List <Potion> potions;



}
