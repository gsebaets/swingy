package com.controller;

import com.model.*;
import com.view.*;

import java.util.List;

public class PlayerController {

    private PlayerModel playerModel;
    private ArenaController arenaController;
    private List<PlayerModel> enemies;
    private Player_View display;


    public PlayerController(Display view) {
        this.display = (Player_View)view;
    }

    public PlayerController(PlayerModel playerModel) {
        this.playerModel = playerModel;
    }

    public void registerHero() {

    }

    public void fightingSimulation(){

    }

    private int attacking(PlayerModel tempPlayer){
        int attackPoint;
        String attackReport;

        attackPoint = tempPlayer.getAttack();
        attackReport = tempPlayer.getName() + " Strikes with " + tempPlayer.getAttack() + " Damage.";
        return (attackPoint);
    }

    public void adding_XP(PlayerModel heroWon, PlayerModel enemyLost){
        int XP_total;
        int Attack_total;
        int nextStage;
    }

    public void gettingHit(PlayerModel tempPlayer, int attackPoint){

    }

    public int loadPlayer(){

        return (1);
    }

    public int choosePlayer(){
        return (1);
    }

    public void newPlayer(){

    }

    public void startMenu() {
        this.display.startMenu(this);
    }

    public void updatePlayerChoice(int option) {
        if (option == 1) {
            this.display.createPlayer();
        }
        else if (option == 2) {
           // this.display.choosePlayer();

        }
    }
}