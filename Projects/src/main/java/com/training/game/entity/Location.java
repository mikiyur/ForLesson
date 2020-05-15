package com.training.game.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Location {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private String pictureURL;
    private int minLevel;

    @OneToMany (fetch = FetchType.EAGER,mappedBy = "location",cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter (value = AccessLevel.PRIVATE)
    private List<Monster> monsters;

    @ManyToMany
    @Setter (value = AccessLevel.PRIVATE)
    private List<Hero> passedBy;




    public void addPassedBy (Hero hero){
        passedBy.add(hero);
    }
    public void removePassedBy (Hero hero){
        passedBy.remove(hero);
    }

    public void addMonster (Monster monster){
        monster.setId(null);
        monsters.add(monster);
        monster.setLocation(this);
    }
    public void removeMonster (Monster monster){
        monsters.remove(monster);
        monster.setLocation(null);
    }
}
