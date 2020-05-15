package com.training.game;

public class ForTests {
    public static void main(String[] args) {

//        printLevelTab();


    }
    public static void printLevelTab() {
        int level;
        for (level = 1; level <= 50; level++) {
            System.out.println("level " + level + " = " + (-(80 + (level * 20) + (level * level))));
        }
    }
}