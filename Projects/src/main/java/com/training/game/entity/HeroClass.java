package com.training.game.entity;

import javax.persistence.*;
import java.util.List;

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

        @OneToMany (mappedBy = "heroClass", cascade = CascadeType.ALL)
        private List<Hero> heroes;

        public Long getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public float getMaxHealthPointBonus() {
                return maxHealthPointBonus;
        }

        public void setMaxHealthPointBonus(float maxHealthPointBonus) {
                this.maxHealthPointBonus = maxHealthPointBonus;
        }

        public float getMaxManaPoontBonus() {
                return maxManaPointBonus;
        }

        public void setMaxManaPoontBonus(float maxManaPoontBonus) {
                this.maxManaPointBonus = maxManaPoontBonus;
        }

        public float getPoverBonus() {
                return poverBonus;
        }

        public void setPoverBonus(float poverBonus) {
                this.poverBonus = poverBonus;
        }

        public float getSpellPoverBonus() {
                return spellPoverBonus;
        }

        public void setSpellPoverBonus(float spellPoverBonus) {
                this.spellPoverBonus = spellPoverBonus;
        }

        public float getDefenceBonus() {
                return defenceBonus;
        }

        public void setDefenceBonus(float defenceBonus) {
                this.defenceBonus = defenceBonus;
        }

        public float getChanceCriticalAttackBonus() {
                return chanceCriticalAttackBonus;
        }

        public void setChanceCriticalAttackBonus(float chanceCriticalAttackBonus) {
                this.chanceCriticalAttackBonus = chanceCriticalAttackBonus;
        }

        public float getChanceDodgeBonus() {
                return chanceDodgeBonus;
        }

        public void setChanceDodgeBonus(float chanceDodgeBonus) {
                this.chanceDodgeBonus = chanceDodgeBonus;
        }

        public List<Hero> getHeroes() {
                return heroes;
        }

        public void setHeroes(List<Hero> heroes) {
                this.heroes = heroes;
        }
}
