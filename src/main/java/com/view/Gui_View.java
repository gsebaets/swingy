package main.java.com.view;

import main.java.com.controller.PlayerController;
import main.java.com.model.PlayerModel;
import java.util.List;

public abstract class Gui_View extends Player_View implements Display {

    public void createPlayer(PlayerModel playerModel)
    {

    }

    public int  choosePlayer(PlayerController controller)
    {
        return 0;
    }

    public void selectPlayer(List<PlayerModel> players)
    {

    }
}
