package com.view;

import com.controller.PlayerController;
import com.model.PlayerModel;
import java.util.List;

public abstract class PlayerGuiView extends Player_View implements Display {

    public void selectPlayer(List<PlayerModel> players)
    {

    }

    public void createPlayer(PlayerModel playerModel)
    {

    }

    public int  choosePlayer(PlayerController controller)
    {

        return 0;
    }
}