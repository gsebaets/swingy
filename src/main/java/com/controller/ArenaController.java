package main.java.com.controller;

import main.java.com.model.PlayerModel;
import main.java.com.view.ArenaView;

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

    private void setStats(PlayerModel tempHero) {
        Random rand = new Random();

        tempHero.setLevel(rand.nextInt(playerModel.getLevel() + 2) + 1);
        tempHero.setHitPoints(100);
        switch (tempHero.getClassP()) {
            case "Hokage":
                tempHero.setExperience(300);
                tempHero.setAttack(25);
                tempHero.setDefence(25);
                break;

            case "Anbu":
                tempHero.setExperience(250);
                tempHero.setAttack(15);
                tempHero.setDefence(10);
                break;

            case "Jonin":
                tempHero.setExperience(150);
                tempHero.setAttack(5);
                tempHero.setDefence(5);
                break;
        }
        tempHero.setExperience(tempHero.getExperience() * tempHero.getLevel());
        tempHero.setAttack(tempHero.getAttack() * tempHero.getLevel());
        tempHero.setDefence(tempHero.getDefence() * (tempHero.getLevel() / 2));
    }

    public void fighting(PlayerModel fightRival) {
        String prepFight;
        PlayerModel play1;
        PlayerModel play-2;

        //COLLISION detection
        enemyModel = fightRival;
        prepFight = this.playerModel.getName() + "BATTLING" + fightRival.getName() + "\n";
        prepFight += "############################################";
        this.arenaView.prepFight(prepFight);
        fightController. new PlayerController(this.playerModel, fightRival, this.arenaView, this);
        fightController.fighting();
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

    public void movement(int option)
    {
        switch (option){
            case 1: //North
                this.playerModel.setY(this.playerModel.getY() + 1);
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
}