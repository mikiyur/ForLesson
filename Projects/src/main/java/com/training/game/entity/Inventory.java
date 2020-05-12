package com.training.game.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Inventory {

    @Id
    private Long id;

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

    public void  addPotion (Potion potion){
        potions.add(potion);
    }
    public void addArtifact (Artifact artifact){
        artifacts.add(artifact);
    }


}
