/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

import javafx.stage.Stage;

/**
 *
 * @author Odigie Oseme Utibe | osemeodigie@yahoo.com | http://osemeodigie.com
 */
public class GameConstants {
    
    public static final float EMPTY_BIN = -9000;
    
        // The Rows you want the AIPlayer and the Human player to use to use...
    public static final int TOP_ROW = 0;
    public static final int BOTTOM_ROW = 1;
    
        // The number of seeds per bin at game start up...
    public static final int SEEDS_PER_BIN = 4;  // standard Ayo seeds per bin at start up is 4
    public static final double SEEDS_DIAMETER = 30;
    
        // Player's initial max and min values...
    public static final float PLAYER_MIN_VALUE = -7000;
    public static final float PLAYER_MAX_VALUE = -7000;

        // Constants for the game play...
    public static final int PLAYER_1_WINS = 101;
    public static final int PLAYER_2_WINS = 102;
    public static final int PLAYERS_TIE = 100;
    public static final int GAME_CONTINUES = -2000;
    
    
    // These are dynamically edited at run time by the game...
    public static Stage primaryStage;
    
    // These set the default size of the ratio of the game board to the user's window...
    public static double BOARD_HEIGHT_PERCENTAGE = 0.65;
    public static double BOARD_WIDTH_PERCENTAGE = 0.75;
    public static double BIN_PERCENTAGE_USAGE = 0.80;
    
    
}
