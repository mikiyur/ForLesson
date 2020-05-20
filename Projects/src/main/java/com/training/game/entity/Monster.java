package com.training.game.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Monster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int gang;

    private String name;

    private boolean boss;

    private boolean dead = false;

    private String pictureURL;

    private int level; // to coins and exp
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


}
