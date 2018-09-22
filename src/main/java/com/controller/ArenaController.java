package com.controller;

import com.model.PlayerModel;
import com.view.*;

import java.util.List;
import java.util.Random;

public class ArenaController {

    private PlayerModel playerModel;
    private PlayerModel enemyModel;
    private List<PlayerModel> enemies;
    private char[][] arena;
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

    private String RandomEnemy() {
        Random Akatsuki = new Random();
        String names[] = {"Deidara", "Itachi", "Nagato", "Tobi", "Hidan"};
        return (names[Akatsuki.nextInt(5)]);
    }

    public static PlayerModel setStats(String name, String rank, int level) {
        Random rand = new Random();
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

    public void fighting(PlayerModel fightRival) {
    }

    private void buildArena() {
        int wholeMap;

        wholeMap = this.width + 2;
        arena = new char[wholeMap][wholeMap];
        for (int y = 0; y < wholeMap; y++) {
            for (int x = 0; x < wholeMap; x++) {
                arena[y][x] = '*';
            }
        }

        arena[this.playerModel.getY() + 1][this.playerModel.getX() + 1] = 'H';
        for (PlayerModel tempEnemy : this.enemies) {
            arena[tempEnemy.getY() + 1][tempEnemy.getX() + 1] = 'E';
        }

        for (int y = 0; y < wholeMap; y++) {
            arena[y][0] = '$';
            arena[y][wholeMap - 1] = '$';
            if (y == 0 || (y == wholeMap - 1)) {
                for (int x = 1; x < (wholeMap - 1); x++) {
                    arena[y][x] = '$';
                }
            }
        }
    }

    public void movement(int option) {
        switch (option){
            case 1: //North
                this.playerModel.setY(this.playerModel.getY() - 1);
                break;
            case 2: //East
                this.playerModel.setX(this.playerModel.getX() + 1);
                break;
            case 3: //West
                this.playerModel.setX(this.playerModel.getX() - 1);
                break;
            case 4: //South
                this.playerModel.setY(this.playerModel.getY() + 1);
                break;
        }
    }

    public void	goBack() {
    }

    private void randomPlayerPosition(){

    }

    private void registerEnemy() {

    }

    private void  createEnemy(){

        }
}