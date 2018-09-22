package com.view;

import com.controller.PlayerController;
import com.model.PlayerModel;

import java.util.List;

public abstract class Player_View {

    public abstract void    createPlayer();
    public abstract int     choosePlayer(PlayerController controller);
    public abstract void    selectPlayer(List<PlayerModel> players);
    public abstract void    startMenu(PlayerController controller);
}