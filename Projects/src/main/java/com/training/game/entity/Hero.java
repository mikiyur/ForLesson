package com.training.game.entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;



@Getter
@Setter
@Entity
public class Hero {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String pictureURL;
    @Column //(precision = 2)
    private float maxHealthPoint;
    @Column //(precision = 2)
    private float currentHealthPoint;
    @Column //(precision = 2)
    private float currentManaPoint;
    @Column //(precision = 2)
    private float maxManaPoint;
    @Column //(precision = 2)
    private float power;
    @Column //(precision = 2)
    private float spellPower;
    @Column //(precision = 2)
    private float defence;
    @Column //(precision = 2)
    private float chanceCriticalAttack;
    @Column //(precision = 2)
    private float chanceDodge;
    @Column
    private int level;
    @Column
    private int levelProgress;
    @Column
    private int skillPoint;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "user_id")
    private User user;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "hero_class_id", nullable = false)
    private HeroClass heroClass;

    @OneToOne (cascade = CascadeType.ALL, mappedBy = "hero", orphanRemoval = true)
    private Inventory inventory = new Inventory(this);

    @OneToOne (cascade = CascadeType.ALL, mappedBy = "hero", orphanRemoval = true)
    private SpellBook spellBook = new SpellBook(this);


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
