package com.training.game.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Shop {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany (fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "shop")
    private List <Potion> potions;

    @OneToMany (fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "shop")
    private List <Artifact> artifacts;
}
