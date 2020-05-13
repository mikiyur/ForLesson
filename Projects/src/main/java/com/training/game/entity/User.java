package com.training.game.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Long id;

    private String name;

    private String password;

    private String phone;

    private String Email;

    @Setter (AccessLevel.PRIVATE)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hero> heroes = new ArrayList<Hero>();


 //   @Enumerated(EnumType.STRING)
    private Role role;

    public void addHero (Hero hero){
        heroes.add(hero);
        hero.setUser(null);
    }
}
