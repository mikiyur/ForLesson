package com.training.game.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String pictureURL;
    @Column(precision = 2)
    private float maxHealthPoint = 20;
    @Column(precision = 2)
    private float currentHealthPoint = 20;
    @Column(precision = 2)
    private float currentManaPoint = 5;
    @Column(precision = 2)
    private float maxManaPoint = 5;
    @Column(precision = 2)
    private float power = 1;
    @Column(precision = 2)
    private float defence = 1;
    @Column(precision = 2)
    private float spellPower = 1;
    @Column(precision = 2)
    private float criticalAttack; //%
    @Column(precision = 2)
    private float chanceCriticalAttack; //0-75%
    @Column(precision = 2)
    private float chanceDodge; //0-75%
    private int level = 1;
    private int levelProgress = -100;
    private int skillPoint = 5;
    private int spellPoint = 1; //to improving own spells

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hero_class_id", nullable = false)
    private HeroClass heroClass;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "passedBy")
    @Setter(AccessLevel.PRIVATE)
    private List<Location> passedLocations;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "hero", orphanRemoval = true)
    private Inventory inventory = new Inventory(this);

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "hero", orphanRemoval = true)
    private SpellBook spellBook = new SpellBook(this);

    @OneToOne(mappedBy = "currentHero", cascade = CascadeType.ALL)
    @JoinColumn(name = "current_lication_id")
    private Location currentLocation;

    public void addLocation(Location passedLocation) {
        passedLocations.add(passedLocation);
        passedLocation.addPassedBy(this);
    }

    public void removeLocation(Location passedLocation) {
        passedLocations.remove(passedLocation);
        passedLocation.removePassedBy(this);
    }



    @Override
    public String toString() {
        return "Hero {" +
                "id= " + id +
                ", name= " + name +
                ", pictureURL= " + pictureURL +
                ", maxHealthPoint= " + maxHealthPoint +
                ", currentHealthPoint= " + currentHealthPoint +
                ", currentManaPoint= " + currentManaPoint +
                ", maxManaPoint= " + maxManaPoint +
                ", power= " + power +
                ", spellPower= " + spellPower +
                ", defence= " + defence +
                ", chanceCriticalAttack= " + chanceCriticalAttack +
                ", chanceDodge= " + chanceDodge +
                ", level= " + level +
                ", levelProgress= " + levelProgress +
                ", skillPoint= " + skillPoint +
                '}';
    }
}
