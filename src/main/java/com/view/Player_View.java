package com.view;

import com.controller.PlayerController;
import com.model.PlayerModel;

import java.util.ArrayList;
import java.util.List;

public abstract class Player_View {

    public abstract void    createPlayer();
    public abstract void     choosePlayer(ArrayList<PlayerModel> players);
    public abstract void    selectPlayer(List<PlayerModel> players);
    public abstract void    startMenu(PlayerController controller);
}