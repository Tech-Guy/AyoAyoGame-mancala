/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Odigie Oseme Utibe | osemeodigie@yahoo.com | http://osemeodigie.com
 */
public final class AyoGameManager extends AyoGameControls {

    public Stage gameStage;
    public double WINDOW_WIDTH, WINDOW_HEIGHT;
    private Scene gameScene;
    private final MenuScreen menu;
    
    public Pane currentPane;

  
    public AyoGameManager(Stage gameStage, double SPLASH_WIDTH, double SPLASH_HEIGHT) {
        super(gameStage);
        this.gameStage = gameStage;
        this.WINDOW_WIDTH = SPLASH_WIDTH;
        this.WINDOW_HEIGHT = SPLASH_HEIGHT;
        isHumanplayer = false;
        menu = new MenuScreen(this);
        super.gameBoard = new AyoGameBoard(this, true);
        super.computerPlayer = new AIPlayer(this);
        super.menuMusic = new Media((AyoAyoBoardGame.class.getResource(GameAssets.MENU_MUSIC).toExternalForm()));
        super.gameMusic = new Media((AyoAyoBoardGame.class.getResource(GameAssets.GAME_MUSIC).toExternalForm()));
    //    super.mediaPlayer = new MediaPlayer(gameMusic);
        super.fxSound = new Media((AyoAyoBoardGame.class.getResource(GameAssets.GAME_FX_SOUND).toExternalForm()));
    
        super.mediaPlayer_Fx = new MediaPlayer(fxSound);
        super.mediaPlayer_Fx.setVolume(0.77);
    }
    
    /**
     * This shows the main menu screen...
     */
    public void menuScreen(){
             
        if(mediaPlayer != null){
            
            if(mediaPlayer.getMedia() == gameMusic){
                mediaPlayer.stop(); 
                super.mediaPlayer = new MediaPlayer(menuMusic);
                super.mediaPlayer.setVolume(0.83);
                mediaPlayer.setOnEndOfMedia(() -> {
                    mediaPlayer.seek(Duration.ZERO);
                });
                if(isMusic){
                    mediaPlayer.play();
                }
            }
            else if(mediaPlayer.getMedia() == menuMusic){

            }
        }
        else if(mediaPlayer == null){
            super.mediaPlayer = new MediaPlayer(menuMusic);
            super.mediaPlayer.setVolume(0.83);
            mediaPlayer.setOnEndOfMedia(() -> {
                mediaPlayer.seek(Duration.ZERO);
            });
            if(isMusic){
                mediaPlayer.play();
            } 
        }
        currentPane = menu.getMainMenuScreen();
        
        if (gameScene == null) {
            gameScene = new Scene(currentPane);
        } 
        else {
            gameScene.setRoot(currentPane);
        }
        gameScene.getStylesheets().add(GameAssets.MENU_STYLE);
        setScreenChangeAnimation();
        
    }
    
    /**
     * Shows the single player vs computer screen
     */
        public void computerPlayerMenuScreen(){
        
        currentPane = menu.getComputerPlayerMenuScreen();
        gameScene.setRoot(currentPane);
        
        gameScene.getStylesheets().add(GameAssets.MENU_STYLE);
        setScreenChangeAnimation();
    }
    
    /**
     * Shows the Multi-player menu screen...
     */
    public void multiPlayerMenuScreen(){
        
        currentPane = menu.getMultiPlayerMenuScreen();
        gameScene.setRoot(currentPane);
        
        gameScene.getStylesheets().add(GameAssets.MENU_STYLE);
        setScreenChangeAnimation();
    }
    
    /**
     * Shows the Multi-player menu screen...
     */
    public void optionsMenuScreen(){
        
        currentPane = menu.getOptionsMenuScreen();
        gameScene.setRoot(currentPane);
        
        gameScene.getStylesheets().add(GameAssets.MENU_STYLE);
        setScreenChangeAnimation();
    }
    
    /**
     * Shows the Multi-player menu screen...
     */
    public void howToPlayMenuScreen(){
        
        currentPane = menu.getHowToPlayMenuScreen();
        gameScene.setRoot(currentPane);
        
        gameScene.getStylesheets().add(GameAssets.MENU_STYLE);
        setScreenChangeAnimation();
    }
    
    public void newGame() {
        
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }
        
        mediaPlayer = new MediaPlayer(gameMusic);
        mediaPlayer.setVolume(0.40);
        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.seek(Duration.ZERO);
        });
        if(isMusic){
            mediaPlayer.play();
        }
        if(!gameBoard.centerWindowArea.getChildren().isEmpty()){            
           super.gameBoard = new AyoGameBoard(this, true);
        }
        gameBoard.InitializeThisGameBoard(true);
        currentPane = gameBoard.GetDrawnGameBoard();
        
        if (gameScene == null) {
            
            gameScene = new Scene(currentPane);
        } 
        else {
            
            gameScene.setRoot(currentPane);
        }
        gameScene.getStylesheets().add(GameAssets.MAIN_GAME_STYLE);
        setScreenChangeAnimation();
    }

    public AyoGameBoard getGameBoard() {
      return gameBoard;
    }

    public Scene getGameScene() {
      return gameScene;
    }
    
    private void setScreenChangeAnimation(){
        
    /*    FadeTransition fadeScreen = new FadeTransition(Duration.seconds(2.9));
      
        fadeScreen.setFromValue(0.0);
        fadeScreen.setToValue(1.0);
        fadeScreen.setOnFinished(actionEvent -> { */
            gameStage.setScene(this.gameScene);
            gameStage.show();
    //    });
     //   fadeScreen.play();
    }
    
}
