/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * This class will hold all the controls in the game...
 * @author Odigie Oseme Utibe | osemeodigie@yahoo.com | http://osemeodigie.com
 */
public class AyoGameControls {
    
    private Stage gameStage;
    
    // Properties of this object.....
    public AyoGameBoard gameBoard;
    public AIPlayer computerPlayer;
    public Media menuMusic;
    public Media gameMusic;
    public Media fxSound;
    public MediaPlayer mediaPlayer;
    public MediaPlayer mediaPlayer_Fx;
    
    public String playerOneName;
    public String playerTwoName;
    
    public int seedPerHouse;
    public int whoStartsFirst;  //  You or player-1: 0 | Computer or player-2: 1;
    public int animationSpeed;
    
    public boolean isMusic;
    public boolean isGameSound;
    public boolean isHumanplayer;
    
    

    public AyoGameControls() {
        
    }

    public AyoGameControls(Stage gameStage) {
        
        this.gameStage = gameStage;
        initializeWithDefaultSettings();
    }
    
    public final void initializeWithDefaultSettings(){
        playerOneName = "Player 1";
        playerTwoName = "Player 2";
        
        seedPerHouse = GameConstants.SEEDS_PER_BIN;
        whoStartsFirst = 0;
        animationSpeed = 5;
    
        isMusic = true;
        isGameSound = true;
        isHumanplayer = false;      
    }
    
    public void EndGameNCloseApp() {
        gameStage.close();
    }
    
}
