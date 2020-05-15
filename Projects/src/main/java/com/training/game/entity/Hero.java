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
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String pictureURL;
    @Column (precision = 2)
    private float maxHealthPoint;
    @Column (precision = 2)
    private float currentHealthPoint;
    @Column (precision = 2)
    private float currentManaPoint;
    @Column (precision = 2)
    private float maxManaPoint;
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

    private int level = 1;

    private int levelProgress;

    private int skillPoint = 5;

    private int spellPoint = 1;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "user_id")
    private User user;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "hero_class_id", nullable = false)
    private HeroClass heroClass;

    @ManyToMany (fetch = FetchType.LAZY, mappedBy = "passedBy")
    @Setter (AccessLevel.PRIVATE)
    private List <Location> passedLocations;

    @OneToOne (cascade = CascadeType.ALL, mappedBy = "hero", orphanRemoval = true)
    private Inventory inventory = new Inventory(this);

    @OneToOne (cascade = CascadeType.ALL, mappedBy = "hero", orphanRemoval = true)
    private SpellBook spellBook = new SpellBook(this);

    public void addLocation (Location passedLocation){
        passedLocations.add(passedLocation);
        passedLocation.addPassedBy(this);
    }
    public void removeLocation (Location passedLocation){
        passedLocations.remove(passedLocation);
        passedLocation.removePassedBy(this);
    }


    @Override
    public String toString() {
        return "Hero {" +
                "id= " + id +
                ", name= " + name  +
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
