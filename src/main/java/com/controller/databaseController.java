package com.controller;

import com.model.PlayerModel;
import com.sun.xml.internal.bind.v2.TODO;

import java.sql.*;
import java.util.ArrayList;

public class databaseController {

    private static void closeDBConnection(Connection connection, Statement statement)

    {

        try

        {

            if (statement != null)

                statement.close();

            if (connection != null)

                connection.close();

        }

        catch (SQLException ex)

        {

            ex.printStackTrace();

        }

    }

    private static Connection getConnection()

    {

        Connection conn = null;

        try

        {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3308", "root", "password");
            //TODO Server setup ;

        }

        catch (ClassNotFoundException ex)

        {

            ex.printStackTrace();

        }

        catch (SQLException ex)

        {

            ex.printStackTrace();

        }

        return (conn);

    }

    public static void createDB()

    {

        Connection connection = null;

        Statement statement = null;

        try

        {

            connection = getConnection();

            statement = connection.createStatement();

            String createDB = "create database if not exists swingy";

            statement.executeUpdate(createDB);

        }

        catch (SQLException ex)

        {

            ex.printStackTrace();

        }

        finally

        {

            closeDBConnection(connection, statement);

        }

    }

    public static void initDB()

    {

        Connection connection = null;

        Statement statement = null;

        try

        {

            connection = getConnection();

            statement = connection.createStatement();

            String createHeroTable =

                    "CREATE TABLE if not exists `swingy`.`players` (" +

                            "`name` TEXT NOT NULL , " +

                            "`class` TEXT NOT NULL , " +

                            "`level` INT NOT NULL , " +

                            "`experience` INT NOT NULL , " +

                            "`attack` INT NOT NULL , " +

                            "`defence` INT NOT NULL , " +

                            "`hitPoints` INT NOT NULL);"

                    ;

            statement.executeUpdate(createHeroTable);

        }

        catch (SQLException ex)

        {

            ex.printStackTrace();

        }

        finally

        {

            closeDBConnection(connection, statement);

        }

    }

    public static ArrayList<PlayerModel> getPlayers()

    {

        int level, exp, atk, def, hp;

        String classP, name;

        Connection connection = null;

        Statement statement = null;

        ArrayList<PlayerModel> players = new ArrayList<>();

        try

        {

            connection = getConnection();

            statement = connection.createStatement();

            String selectPlayers = "select *" +

                    "from `swingy`.`players`";

            ResultSet results = statement.executeQuery(selectPlayers);

            while(results.next())

            {

                name = results.getString("name");

                classP = results.getString("class");

                level = results.getInt("level");

                exp = results.getInt("exp");

                atk = results.getInt("atk");

                def = results.getInt("def");

                hp = results.getInt("hp");


                PlayerModel  player = new PlayerModel(name, classP, level, exp, atk, def, hp);

                players.add(player);
            }

        }

        catch (SQLException ex)

        {

            ex.printStackTrace();

        }

        finally

        {

            closeDBConnection(connection, statement);

        }

        return (players);

    }

    public static boolean playerSaved(PlayerModel player)

    {

        boolean saved = false;

        Connection connection = null;

        Statement statement = null;

        try

        {

            connection = getConnection();

            statement = connection.createStatement();

            String select = String.format("SELECT * FROM `swingy`.`players` WHERE (`name` = '%s' AND `ClassP` = '%s' AND " +

                            "`level` = %d AND `experience` = %d AND `attack` = %d AND `defence` = %d AND `hitPoints` = %d) " ,

                    player.getName(),

                    player.getClassP(),

                    player.getLevel(),

                    player.getExperience(),

                    player.getAttack(),

                    player.getDefence(),

                    player.getHitPoints()

            );

            ResultSet results = statement.executeQuery(select);

            saved = results.next();

        }

        catch (SQLException ex)

        {

            ex.printStackTrace();

        }

        finally

        {

            closeDBConnection(connection, statement);

        }

        return (saved);

    }

    public static void savePLayer(PlayerModel player)

    {

        Connection connection = null;

        Statement statement = null;

        try

        {

            if (playerSaved(player) == false)

            {

                connection = getConnection();

                statement = connection.createStatement();

                String insertHero = String.format("INSERT INTO `swingy`.`players` (`name`, `classP`, `level`, `experience`," +

                                " `attack`, `defence`, `hitPoints`) " +

                                " VALUES ('%s', '%s', %d, %d, %d, %d, %d)",

                        player.getName(),

                        player.getClassP(),

                        player.getLevel(),

                        player.getExperience(),

                        player.getAttack(),

                        player.getDefence(),

                        player.getHitPoints()

                );

                statement.executeUpdate(insertHero);

            }

        }

        catch (SQLException ex)

        {

            ex.printStackTrace();

        }

        finally

        {

            closeDBConnection(connection, statement);

        }

    }
}
