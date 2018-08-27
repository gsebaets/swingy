package main.java.com.controller;

import main.java.com.model.*;

import java.util.List;

public class PlayerController {

    private PlayerModel playerModel;
    private ArenaController arenaController;
    private List<PlayerModel> enemies;


    public PlayerController(PlayerModel playerModel) {
        this.playerModel = playerModel;
    }

    public void registerEnemy(PlayerModel enemy) {
        this.enemies.add(enemy);
    }


    public boolean moveUp() {
        if (this.playerModel.getY() > 1) {
            this.playerModel.setY(this.playerModel.getY() - 1);
            return (true);
        }
        else {
            return (false);
        }
    }

    public boolean movedown() {
        if (this.playerModel.getY() > 1) {
            this.playerModel.setY(this.playerModel.getY() + 1);
            return (true);
        }
        else {
            return (false);
        }
    }

    public boolean moveLeft() {
        if (this.playerModel.getX() > 1) {
            this.playerModel.setX(this.playerModel.getX() - 1);
            return (true);
        }
        else {
            return (false);
        }
    }

    public boolean moveRight() {
        if (this.playerModel.getX() > 1) {
            this.playerModel.setX(this.playerModel.getX() + 1);
            return (true);
        }
        else {
            return (false);
        }
    }

    public boolean checkCollision() {
        for (PlayerModel tempEnemy : enemies) {
            if (this.playerModel.getX() == tempEnemy.getX() &&
                    this.playerModel.getY() == tempEnemy.getY()) {
                return (true);
            }
        }
        return (false);
    }
}
