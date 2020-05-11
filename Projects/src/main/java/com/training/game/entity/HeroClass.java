package com.training.game.entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class HeroClass {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column
        private String name;
        @Column
        private float maxHealthPointBonus;
        @Column
        private float maxManaPointBonus;
        @Column
        private float poverBonus;
        @Column
        private float spellPoverBonus;
        @Column
        private float defenceBonus;
        @Column
        private float chanceCriticalAttackBonus;
        @Column
        private float chanceDodgeBonus;

        @OneToMany (fetch = FetchType.LAZY, mappedBy = "heroClass", cascade = CascadeType.ALL)
        @Setter (AccessLevel.PRIVATE)
        private List<Hero> heroes;

        public void addHero (Hero hero){
            heroes.add(hero);
        }
}
