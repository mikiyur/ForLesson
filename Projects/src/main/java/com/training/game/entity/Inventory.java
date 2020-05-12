package com.training.game.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Inventory {

    @Id
    private Long id;

    @Column
    private int coins;



    @OneToOne
    @JoinColumn (name = "hero_id")
    @MapsId
    private Hero hero;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "inventory", orphanRemoval = true)
    @Setter (AccessLevel.PRIVATE)
    private List <Artifact> artifacts = new ArrayList<Artifact>();

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "inventory", orphanRemoval = true)
    @Setter (AccessLevel.PRIVATE)
    private List <Potion> potions = new ArrayList<Potion>();


    Inventory (Hero hero){
        this.hero = hero;
    }

    public void  addPotion (Potion potion){
        potions.add(potion);
        potion.setInventory(this);
    }

    public void removePotion (Potion potion){
        potions.remove(potion);
        potion.setInventory(null);
    }

    public void addArtifact (Artifact artifact){
        artifacts.add(artifact);
        artifact.setInventory(this);
    }
    public void removeArtifact (Artifact artifact){
        artifacts.remove(artifact);
        artifact.setInventory(null);
    }


}
