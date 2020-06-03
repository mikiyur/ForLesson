package com.training.game;

import javax.persistence.OneToMany;

public class ForTests {
    public static void main(String[] args) {

//        printLevelTab();
//        printDefVsPower();
        for (int i = 0; i < 100; i++) {
            System.out.println(((Math.random()*0.8)+0.6) * 100);
        }



    }

        public static void printDefVsPower(){
            float defense = 2;//2
            float damage = 20;//1
            float damageMultiplier = 1f - ((0.05f * (defense)) / (0.9f + (0.08f * (defense))));
            float attack = (damage * damageMultiplier) - (defense*0.25f);
            if (attack < 1) {
                attack = 1;
            }
            System.out.println(attack);
        }

    public static void printLevelTab() {
        int level;
        for (level = 1; level <= 100; level++) {
            System.out.println("level " + level + " = " + (-(80 + (level * 20) + (level * level))));
        }
    }
}