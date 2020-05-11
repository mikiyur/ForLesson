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
    @Column
    private float maxHealthPoint;
    @Column
    private float currentHealthPoint;
    @Column
    private float currentManaPoint;
    @Column
    private float maxManaPoint;
    @Column
    private float power;
    @Column
    private float spellPower;
    @Column
    private float defence;
    @Column
    private float chanceCriticalAttack;
    @Column
    private float chanceDodge;
    @Column
    private int level;
    @Column
    private int levelProgress;
    @Column
    private int skillPoint;

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn (name = "heroes", nullable = false)
    private HeroClass heroClass;


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
