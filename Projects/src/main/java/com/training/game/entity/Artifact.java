package com.training.game.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Artifact {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String pictureURL;

    @Column(precision = 2)
    private float maxHealthPointBonus;
    @Column(precision = 2)
    private float currentHealthPointBonus;
    @Column(precision = 2)
    private float currentManaPointBonus;
    @Column(precision = 2)
    private float maxManaPointBonus;
    @Column(precision = 2)
    private float powerBonus;
    @Column(precision = 2)
    private float defenceBonus;
    @Column(precision = 2)
    private float spellPowerBonus;
    @Column(precision = 2)
    private float criticalAttackBonus; //%
    @Column(precision = 2)
    private float chanceCriticalAttackBonus; //0-75%
    @Column(precision = 2)
    private float chanceDodgeBonus; //0-75%

    @ManyToOne (fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn (name = "inventory_id")
    private Inventory inventory;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name = "shop_id")
    private Shop shop;


}
