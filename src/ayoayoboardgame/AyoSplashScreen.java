/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

import javafx.animation.FadeTransition;
import javafx.collections.*;
import javafx.concurrent.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.util.Duration;

/**
 *
 * @author Odigie Oseme Utibe | osemeodigie@yahoo.com | http://osemeodigie.com
 */
public class AyoSplashScreen {
    
    private GridPane splashLayout;
    private ProgressBar loadProgress;
    private Label progressText;
    private final Stage splashStage, mainStage;
    private final Image SPLASH_IMAGE;
    
    public double SPLASH_WIDTH = 1000;
    public double SPLASH_HEIGHT = 500;
    
    private final AyoAyoBoardGame myGameApp;
    
    private ObservableList<String> progressMessages;

    public AyoSplashScreen(Stage PrimaryStage, Image SPLASH_IMAGE, ObservableList<String> progressMessages, AyoAyoBoardGame myGameApp) {
        
            // Define a new stage for the game...
        this.mainStage = new Stage();//(StageStyle.DECORATED);
            // define a splash screen stage...
        this.splashStage = PrimaryStage; 
                // The Splash Image to use
        this.SPLASH_IMAGE = SPLASH_IMAGE;
            // set all the message to be displayed as game loads...
        this.progressMessages = progressMessages;
        
            // set this splash screen application object, The object that implements this splash screen...
         this.myGameApp = myGameApp;
    }
    
    public void InitSplashScreen() {

        splashStage.initStyle(StageStyle.TRANSPARENT);
        splashStage.setMaximized(true);
        splashStage.setResizable(false);
        splashStage.setOpacity(0.0);
        splashStage.show();
        
        SPLASH_WIDTH = splashStage.getWidth()-14;
        SPLASH_HEIGHT = splashStage.getHeight()-14;

        ImageView splash = new ImageView(SPLASH_IMAGE);
        loadProgress = new ProgressBar();
        loadProgress.setPrefWidth(SPLASH_WIDTH * 0.6);
        
        progressText = new Label("Initializing the Ayo game . . .");
        progressText.setId("loading-status-text");
        progressText.setAlignment(Pos.CENTER);
        
        VBox splashLayoutBox = new VBox();
        splashLayoutBox.getChildren().addAll(splash, loadProgress, progressText);
        
        splashLayoutBox.setPrefSize(SPLASH_WIDTH, SPLASH_HEIGHT);
        splashLayoutBox.setMinSize(SPLASH_WIDTH, SPLASH_HEIGHT);
        splashLayoutBox.setMaxSize(SPLASH_WIDTH, SPLASH_HEIGHT);
            
        splashLayout = new GridPane();
        splashLayout.setAlignment(Pos.CENTER);
        splashLayout.setHgap(10);
        splashLayout.setVgap(10);
        splashLayout.setPadding(new Insets(25, 25, 25, 25));
        
        
        splashLayoutBox.setAlignment(Pos.CENTER); 
        splashLayout.add(splashLayoutBox,0,0);
        

        splashLayout.setStyle(
        "-fx-padding: 2; " +
        "-fx-background-color: cornsilk; " +
        "-fx-border-width:5; " +
        "-fx-border-color: " +
        "linear-gradient(" +
        "to bottom, " +
        "chocolate, " +
        "derive(chocolate, 50%)" +
        ");"
        );
        splashLayout.setEffect(new DropShadow());
        
    }
    
    final Task SplashScreenTask = new Task() {
        
        @Override
        protected String call() throws InterruptedException {
            
            updateMessage("Starting up Ayo Game . . .");
            for (int currentMsgIndex = 0; currentMsgIndex < progressMessages.size(); currentMsgIndex++) {
                
                long pauseTime = (long)((2200 * Math.random()) + (400 * Math.random()));
                
                Thread.sleep(pauseTime);
                updateProgress(currentMsgIndex + 1, progressMessages.size());
                String nextMessage = progressMessages.get(currentMsgIndex);
               
                updateMessage(nextMessage);
            }
            Thread.sleep(600);
            updateMessage("Initialization completed!");
            Thread.sleep(500);
            return "Initialization completed!";
        }
    };
    
    
    public void showSplashScreen() {

        progressText.textProperty().bind(SplashScreenTask.messageProperty());
        loadProgress.progressProperty().bind(SplashScreenTask.progressProperty());

        SplashScreenTask.stateProperty().addListener((observableValue, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                loadProgress.progressProperty().unbind();
                loadProgress.setProgress(1);
                splashStage.toFront();
                FadeTransition fadeSplash = new FadeTransition(Duration.seconds(1.1), splashLayout);
                fadeSplash.setFromValue(1.0);
                fadeSplash.setToValue(0.0);
                fadeSplash.setOnFinished(actionEvent -> splashStage.hide());
                fadeSplash.play();

                splashScreenComplete();
            } 
        });

        Scene splashScene = new Scene(splashLayout);
        splashScene.getStylesheets().add(GameAssets.SPLASH_SCREEN_STYLE);
   //     splashScene.setFill(Color.TRANSPARENT);
        splashStage.setScene(splashScene);
        splashStage.setOpacity(1);
        splashStage.show();
        
            // Start the splash screen process thread...
        new Thread(SplashScreenTask).start();
    }
    
    private void splashScreenComplete(){
        
        mainStage.setResizable(false);
        mainStage.setMaximized(true);
        mainStage.setMinWidth(SPLASH_WIDTH);
        mainStage.setMinHeight(SPLASH_HEIGHT);
        myGameApp.onSplashScreenCompleted(SPLASH_WIDTH, SPLASH_HEIGHT);
    }
    
    public Stage GetMainStage(){
        
        return this.mainStage;
    }   
}
    

