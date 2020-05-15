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

    private String name;

    private boolean boss;

    private String pictureURL;
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
    private float chanceCriticalAttack;
    @Column (precision = 2)
    private float chanceDodge;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name = "location_id")
    private Location location;


}
