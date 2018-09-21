package main.java.com.view;

import main.java.com.controller.PlayerController;
import main.java.com.model.PlayerModel;

import java.util.List;

public abstract class Player_View {

    public abstract void    createPlayer();
    public abstract int     choosePlayer(PlayerController controller);
    public abstract void    selectPlayer(List<PlayerModel> players);
    public abstract void    startMenu(PlayerController controller);
}