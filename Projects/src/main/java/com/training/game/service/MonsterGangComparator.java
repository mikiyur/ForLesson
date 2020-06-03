package com.training.game.service;

import com.training.game.entity.Monster;

import java.util.Comparator;

public class MonsterGangComparator implements Comparator <Monster>{
        @Override
         public int compare(Monster a, Monster b) {
            if (a.getGang() < b.getGang()) {
                return 1;
            } else if (a.getGang() > b.getGang()) {
                return -1;
            } else {
                return 0;
            }
        }

}
