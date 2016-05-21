/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

/**
 *
 * @author Odigie Oseme Utibe | osemeodigie@yahoo.com | http://osemeodigie.com
 */
public class AyoAyoBoardGame extends Application implements ISplashScreen {
    
    public Stage gameStage;
    public AyoGameManager gameManager;
    public AyoSplashScreen ayoSplashScreen;
    
    @Override
    public void start(Stage primaryStage) {
    
        ObservableList<String> application_states = FXCollections.observableArrayList(
                                "Initializing game . . .", "Loading game resources . . .",
                                "Game resources loaded.", "Setting up game environment . . .", 
                                "Game Environment set up complete.",
                                "Initializing the main game environment . . .", 
                                "Main Game environment initialization complete.", 
                                "Rendering game window . . .", "Rendering game menu controls . . .",
                                "Setting up game board themes . . .",
                                "Game board themes loaded.",
                                "Creating AI players . . ."
                                );
         
        ayoSplashScreen = new AyoSplashScreen(primaryStage, GameAssets.SPLASH_IMAGE, application_states, this);
        ayoSplashScreen.InitSplashScreen();
        ayoSplashScreen.showSplashScreen();
    }
    
    @Override
    public void onSplashScreenCompleted(double SCREEN_WIDTH, double SCREEN_HEIGHT){
        
        gameStage = ayoSplashScreen.GetMainStage();
        
        gameStage.setTitle("AyoAyo Board Game");
        gameManager = new AyoGameManager(gameStage, SCREEN_WIDTH, SCREEN_HEIGHT);
        
                // Go to the main game menu...
        gameManager.menuScreen();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(AyoAyoBoardGame.class);  // launch the AyoAyoBoardGame...
    }
    
}