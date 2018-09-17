package main.java.com.controller;

import main.java.com.model.*;
import main.java.com.view.PlayerConsoleView;

import java.util.List;

public class PlayerController {

    private PlayerModel playerModel;
    private ArenaController arenaController;
    private List<PlayerModel> enemies;


    public PlayerController(PlayerModel playerModel) {
        this.playerModel = playerModel;
    }

    public void registerHero()

    public void registerEnemy(PlayerModel enemy) {
        this.enemies.add(enemy);
    }

    public void fightingSimulation(){

    }

    private int attacking(PlayerModel tempPlayer){
        int attackPoint;
        String attackReport;

        attackPoint = tempPlayer.getAttack();
        attackReport = tempPlayer.getName() + " Strikes with " + tempPlayer.getAttack() + " Damage.";
        this.arenaView.fightUpdate(attackReport);
        return (attackPoint);
    }

    public void adding_XP(PlayerModel heroWon, PlayerModel enemyLost){

    }

    public void gettingHit(PlayerModel tempPlayer, int attackPoint){

    }

    public int loadPlayer(){
        int option;

        if ((option = this.playerView.loadPlayer(this)) == 1){
            this.newPlayer();
        }
        else if(option == 2){
            this.choosePlayer();
        }
        else if (playerView instanceof PlayerConsoleView){
            System.out.println("EXITING");
        }
        return (3);
    }

    public void newPlayer(){
    }
}