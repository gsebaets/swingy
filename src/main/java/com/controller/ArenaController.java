package com.controller;

import com.model.PlayerModel;
import com.view.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ArenaController {

    public static PlayerModel playerModel;
    public static PlayerModel enemyModel;
    private static List<PlayerModel> enemies;
    public static char[][] arena;
    private ArenaView arenaView;
    int width;
    int height;

    public ArenaController() {

    }

    private String getRank() {
        Random Fighter = new Random();
        String Rank[] = {"Hokage", "Anbu", "Jonin"};
        return (Rank[Fighter.nextInt(3)]);
    }

    private static String RandomEnemy() {
        Random Akatsuki = new Random();
        String names[] = {"Deidara", "Itachi", "Nagato", "Tobi", "Hidan"};
        return (names[Akatsuki.nextInt(5)]);
    }

    public static PlayerModel setStats(String name, String rank, int level) {
        PlayerModel tempHero = null;
        int exp = (int)(level*1000+Math.pow((double)(level - 1), 2.0) * 450);
        switch (rank) {
            case "Hokage":
                tempHero = new PlayerModel(name, rank,level, exp,25, 25,100);
                break;

            case "Anbu":
                tempHero = new PlayerModel(name, rank,level, exp,15, 15,100);
                break;

            case "Jonin":
                tempHero = new PlayerModel(name, rank,level, exp,5, 5,100);
                break;
        }
        return (tempHero);
    }

    public static void fighting(PlayerModel fightRival) {

        Random random = new Random();

       int attack = random.nextInt(50 - 25 + 1) + 25;
        enemyModel = fightRival;
        System.out.println(ArenaController.playerModel.getName() + " vs " + fightRival.getName());

        removeEnemy(fightRival);
    }

    public static void removeEnemy(PlayerModel fightRival){
        for (Iterator<PlayerModel> iter = enemies.listIterator(); iter.hasNext(); ) {
            PlayerModel tempEnemy = iter.next();
            if (enemyModel == tempEnemy) {
                iter.remove();
                System.out.println("You killed " + fightRival.getName());
            }
        }
    }

    public static int buildArena(PlayerModel hero) {
        int wholeMap;

        wholeMap = (hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2);
        hero.setY(wholeMap/2);
        hero.setX(wholeMap/2);
        arena = new char[wholeMap][wholeMap];
        for (int y = 0; y < wholeMap; y++) {
            for (int x = 0; x < wholeMap; x++) {
                arena[y][x] = '*';
            }
        }

        arena[hero.getY()][hero.getX()] = 'H';
        randomPlayerPosition(hero, wholeMap);

        return (wholeMap);
    }

    private static void randomPlayerPosition(PlayerModel hero, int wholeMap){
        Random	rand = new Random();
        int		maxEnemies = rand.nextInt((wholeMap * wholeMap) / 2) + 1;
        enemies = new ArrayList<>();

        for(int i = 1; i <= maxEnemies; i++){

            int x;
            int y;

            do {
                 x = rand.nextInt(wholeMap);
                 y = rand.nextInt(wholeMap);
            }while((x == hero.getX() && y == hero.getY()) || arena[y][x] != '*');
                PlayerModel enemy = new PlayerModel(RandomEnemy(), "Akatsuki");
                enemy.setX(x);
                enemy.setY(y);
                arena[y][x] = 'E';
            enemies.add(enemy);
        }
    }

    public static boolean enemyEncountered (PlayerModel hero){

        for(PlayerModel enemy: enemies) {
            if (enemy.getX() == hero.getX() && enemy.getY() == hero.getY())
                return true;
        }
        return false;
    }

    public static boolean outOfBound(PlayerModel hero, int wholeMap){
        return true;
   }

    public static PlayerModel getEnemy(PlayerModel hero){

        for(PlayerModel enemy: enemies) {
            if (enemy.getX() == hero.getX() && enemy.getY() == hero.getY())
                return enemy;
        }
        return null;
    }

    public static void movement(int option, PlayerModel hero) {

        arena[hero.getY()][hero.getX()] = '*';
        switch (option){
            case 1: //North
                hero.setY(hero.getY() - 1);
                break;
            case 2: //East
                hero.setX(hero.getX() + 1);
                break;
            case 3: //West
                hero.setX(hero.getX() - 1);
                break;
            case 4: //South
                hero.setY(hero.getY() + 1);
                break;
        }
        arena[hero.getY()][hero.getX()] = 'H';
    }

    public  static boolean renderGame(PlayerModel hero, int wholeMap){
        playerModel = hero;
        ArenaConsoleView.printDetails(hero, wholeMap);
        return (true);
    }

    public static void	goBack(PlayerModel hero) {
        playerModel = hero;
        hero.setX(hero.getX() + 1);
    }
}