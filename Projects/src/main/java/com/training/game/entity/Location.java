package com.training.game.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    private boolean ready  = false;
    private String name;
    private String pictureURL = "https://images.pexels.com/photos/912110/pexels-photo-912110.jpeg";
    private int minLevel;
    @Setter (value = AccessLevel.PRIVATE)
    private int countMonsters = 0;
    @Setter (value = AccessLevel.PRIVATE)
    private boolean hasBoss = false;
    @Setter (value = AccessLevel.PRIVATE)
    private String bossName;


    @OneToMany (fetch = FetchType.EAGER, mappedBy = "location",cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter (value = AccessLevel.PRIVATE)
    private List<Monster> monsters;

    @ManyToMany
    @Setter (value = AccessLevel.PRIVATE)
    private List<Hero> passedBy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "current_hero_id")
    private  Hero currentHero;

    public Location (String name){
        this.name = name;
    }



    public void addPassedBy (Hero hero){
        passedBy.add(hero);
    }
    public void removePassedBy (Hero hero){
        passedBy.remove(hero);
    }

    public void addMonster (Monster monster){
        if (monster.isBoss()&&hasBoss) return;
        monster.setId(null);
        monsters.add(monster);
        monster.setLocation(this);
        countMonsters ++;
        if (monster.isBoss()){
            hasBoss = true;
            bossName = monster.getName();
        }
    }
    public void removeMonster (Monster monster){
        monsters.remove(monster);
        monster.setLocation(null);
        countMonsters --;
        if (monster.isBoss()){
            hasBoss = false;
            bossName = null;
        }
    }
}
