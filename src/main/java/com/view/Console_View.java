package main.java.com.view;

import main.java.com.controller.PlayerController;
import main.java.com.model.PlayerModel;
import java.util.List;

public abstract class Console_View extends Player_View implements Display {

    private String name;
    private String ClassP;
    private int level;
    private int experience;
    private int attack;
    private int defence;
    private int hitPoints;

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
