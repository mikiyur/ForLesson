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
@NoArgsConstructor
@Entity
public class SpellBook {

    @Id
    private Long id;

    @Column
    private String pictureURL;

    @OneToOne
    @JoinColumn (name = "hero_id")
    @MapsId
    private Hero hero;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "spellBook", orphanRemoval = true)
    @Setter (AccessLevel.PRIVATE)
    private List<Spell> spells = new ArrayList<Spell>();

    SpellBook (Hero hero){
        this.hero = hero;
    }

    public void addSpell (Spell spell){
        spells.add(spell);
        spell.setSpellBook(this);
    }

    public void removeSpell (Spell spell){
        spells.remove(spell);
        spell.setSpellBook(null);
    }
}
