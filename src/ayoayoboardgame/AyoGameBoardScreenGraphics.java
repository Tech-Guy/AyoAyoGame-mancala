/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

import java.util.Optional;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author Odigie Oseme Utibe | osemeodigie@yahoo.com | http://osemeodigie.com
 */
public class AyoGameBoardScreenGraphics extends BorderPane {
    
    // This is the window panel were all the game board user controls will be added to...
    protected VBox topContainer, statusBar, centerWindowArea, centerBoxVertical;
    protected HBox centerBoxHorizontal;  // The center Horizontal Box...
    protected ToolBar playersDetailsToolBar;  //Creates a tool-bar to display the players details.
    protected AyoGameBoardGridGraphics gameGrid;
    protected Thread AnimatePlayThread;
    protected boolean isKilledThreads = false;
    protected Task AnimatePlayTurnTask;
    protected Alert gameEndedAlert, aboutGameAlert;
    protected Optional<ButtonType> gameEndedAlertResult;
    protected ButtonType gameEndedAlertMainMenuBtn;
    protected ButtonType gameEndedAlertPlayAgainBtn;
    protected ButtonType gameEndedAlertCancelBtn;
    
    private Menu fileMenu;
    private ToolBar menuToolBar;
    private MenuItem quitMenuBtn, goToMainMenuBtn, exitMenuBtn;
    private Button quitGameBtn, goToMainGameBtn, aboutGameBtn;
    protected boolean gameStopped = false, gamePaused = false;
    
    protected Text statusText, seedsInHand, player1_seeds_captured, player2_seeds_captured,
            player1_name, player2_name, player1_houses, player2_houses;
    
    protected HBox player_1_TopBox, player_2_TopBox;
    
    protected AyoGameManager gameManager;
    protected double WINDOW_HEIGHT;
    protected double WINDOW_WIDTH;
    protected double BOARD_GRID_HEIGHT = 450, BOARD_GRID_WIDTH = 1000;
    
    
    public AyoGameBoardScreenGraphics() {
        
        initialiseVars();
    }
    
    public AyoGameBoardScreenGraphics(AyoGameManager gameMgr) {
    
        gameManager = gameMgr;
        gameGrid = new AyoGameBoardGridGraphics(gameMgr);
        
        this.WINDOW_HEIGHT = gameMgr.WINDOW_HEIGHT;
        this.WINDOW_WIDTH = gameMgr.WINDOW_WIDTH;
        
        this.BOARD_GRID_HEIGHT = (WINDOW_HEIGHT * GameConstants.BOARD_HEIGHT_PERCENTAGE) - 150;
        this.BOARD_GRID_WIDTH = WINDOW_WIDTH * GameConstants.BOARD_WIDTH_PERCENTAGE;
        
        initialiseVars();
        
        player1_seeds_captured = new Text("0");
        player2_seeds_captured = new Text("0");
        statusText = new Text("A Program to play Mancala Games");
        gameGrid.initGameGrid();   // initialize the main game board grid... 

    }
    
    private void initialiseVars(){
        
        topContainer = new VBox();  //Creates a container to hold all Menu Objects.
        statusBar = new VBox();  //Creates a container to hold all status bar Objects
        centerWindowArea = new VBox(); // center view
        centerBoxVertical = new VBox();  // The center Vertical Box...
        centerBoxHorizontal = new HBox();  // The center Horizontal Box...
        playersDetailsToolBar = new ToolBar();  //Creates a tool-bar to display the players details...
        player_1_TopBox = new HBox(15);
        player_2_TopBox = new HBox(15);
        gameEndedAlert = new Alert(AlertType.CONFIRMATION);
        gameEndedAlertMainMenuBtn = new ButtonType("Go To MainMenu");
        gameEndedAlertPlayAgainBtn = new ButtonType("Play Again");
        gameEndedAlertCancelBtn = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
        gameEndedAlert.getButtonTypes().setAll(gameEndedAlertMainMenuBtn, gameEndedAlertPlayAgainBtn, gameEndedAlertCancelBtn);
        
        aboutGameAlert = new Alert(AlertType.INFORMATION);
        aboutGameAlert.setTitle("About this Simple Manacala Game");
        aboutGameAlert.setHeaderText("AyoAyo Manacala Game v 1.0 (Alpha) - by Odigie Oseme U.");
        aboutGameAlert.setContentText("This game was developed as a demo to increase "
                + "my understanding of Game Theory and Decision Trees.\n\n"
                + "The game uses a simple minimization-maximization algorithm(MinMax) "
                + "enhanced with a heuristic function(Alpha-beta pruning). "
                + "Its decision is based on the greedy algorithm. \n\n\n"
                + "Developed by: Odigie Oseme Utibe [in February 2015] \n"
                + "Email: osemeodigie@yahoo.com\n"
                + "Website: http://osemeodigie.com \n"
                + "Project Title: A program to play Mancala Games. \n"
                + "Current Version: 1.0 Alpha. \n"
                + "Music Asset: Epic Medieval Battle by Akashic Records. ");
    }
    

    /**
     * returns the main box graphics to be displayed at the center of the gameBoard Screen...
     * @return
     */
        protected Pane getMainGameBoardGraphics(){
        
        centerWindowArea.getChildren().clear();
        statusText.setText("Game Board initialised.. Game play in progress");
        
        centerBoxVertical.getChildren().clear();
       
        centerBoxVertical.setPadding(new Insets(50, 5, 5, 25));
       
        centerBoxVertical.setAlignment(Pos.CENTER);
        centerBoxVertical.getChildren().addAll(getPlayersScorePanel(), getSeedInHandBox(), getPlayer1Box(), gameGrid.getCurrentGameGrid(), getPlayer2Box());
        
        centerBoxHorizontal.setAlignment(Pos.CENTER);
        centerBoxHorizontal.getChildren().clear();
        
        centerBoxHorizontal.getChildren().addAll(centerBoxVertical);
        
        return centerBoxHorizontal;
    }

    /**
     * Draws the status bar at the bottom of the window
     * target id: "bottom-status-bar" from the css
     * @return 
     */
        protected double drawStatusBar(){
        
        statusBar.setStyle("-fx-background-color: gainsboro"); // set the style for he status bar
        statusBar.setId("bottom-status-bar");   // the id of the status bar..
        
        HBox centerBox = new HBox();
        centerBox.setAlignment(Pos.CENTER);
        
        centerBox.getChildren().addAll(statusText);
        
        statusBar.getChildren().clear();
        statusBar.getChildren().add(centerBox);
       
        this.setBottom(statusBar);
        
        return 40;
    }
    
    /**
     * Draw the Menu Bar at the Top of the window
     * @return 
     */
    protected double drawTopMenuBar(){
        
            // This adds the top menu icons to the borderPane
        MenuBar mainMenu = new MenuBar();  //Creates our main menu to hold our Sub-Menus.
        menuToolBar = new ToolBar();  //Creates our menu tool-bar to hold the buttons.
        
                //Declare sub-menus and add to main menu.
        fileMenu = new Menu("Ayo Game Options");
        quitMenuBtn = new MenuItem("Restart Current Game");
        quitMenuBtn.setOnAction((ActionEvent event) -> {
            
            this.endCurrentGame();
        });
        
        goToMainMenuBtn = new MenuItem("Go To The Main Menu");
        goToMainMenuBtn.setOnAction((ActionEvent event) -> {
            
            this.goToMainMenu();
        });
        
        exitMenuBtn = new MenuItem("Exit");
        exitMenuBtn.setOnAction((ActionEvent event) -> {
            
             // some alert box to confirm closing before I close the window
            this.exitGame();
        });
        fileMenu.getItems().addAll(quitMenuBtn,goToMainMenuBtn,exitMenuBtn);

        mainMenu.getMenus().addAll(fileMenu);
        topContainer.getChildren().clear();
        
        topContainer.getChildren().add(mainMenu);
         
        quitGameBtn = new Button("Restart This Game");
        quitGameBtn.setOnAction((ActionEvent event) -> {
            
            this.endCurrentGame();
        });
        
        goToMainGameBtn = new Button("Go To Main Menu");
        goToMainGameBtn.setOnAction((ActionEvent event) -> {
            
            this.goToMainMenu();
        });
                
        aboutGameBtn = new Button("About Game");
        aboutGameBtn.setOnAction((ActionEvent event) -> {
            aboutGameAlert.showAndWait();
        });
 
            //Set the icon/graphic for the ToolBar Buttons.
      //  pauseGameBtn.setGraphic(new ImageView("/pathToOpenFileBtnIcon.png"));
     //   quitGameBtn.setGraphic(new ImageView("/pathToSnapshotBtnIcon.png"));
     //   helpGameBtn.setGraphic(new ImageView("/pathToPrintBtnIcon.png"));
     //   aboutGameBtn.setGraphic(new ImageView("/pathToPrintBtnIcon.png"));

        //Add the Buttons to the ToolBar.
        menuToolBar.getItems().addAll(quitGameBtn, goToMainGameBtn, aboutGameBtn);
        topContainer.getChildren().add(menuToolBar);
        updateMenuState(this.gameStopped);
        
        this.setTop(topContainer);
        
        return 70;
    }
    
    /**
     * This draws the amount of seeds left in the current playing hand...
     */
    protected void DrawSeedsOnHandIndicator(){
        
        // This adds the Seeds on hand indicator row to the boarderPane
    }
    
    
    private void updateMenuState(boolean gameStopped){
        
        quitMenuBtn.setDisable(gameStopped);
        quitGameBtn.setDisable(gameStopped);
    }
    
    protected GridPane getPlayer1Box(){
        
        GridPane fullBox = new GridPane();
        fullBox.setPadding(new Insets(2,5,2,5));
        fullBox.setStyle("-fx-border-style: solid;"
	                + "-fx-border-width: 1;"
	                + "-fx-border-color: black");
        fullBox.setPrefWidth(BOARD_GRID_WIDTH);
        fullBox.setMinWidth(BOARD_GRID_WIDTH);
        fullBox.setMaxWidth(BOARD_GRID_WIDTH);
        
        Text labelText = new Text("Seeds Captured by Player 1("+gameManager.playerOneName+"):");
        labelText.getStyleClass().add("player-captured-label");
        player1_seeds_captured.setId("player-1-captured");
         
        HBox player1Box = new HBox(15);
        player1Box.getStyleClass().add("player-captured-box");
        player1Box.setAlignment(Pos.BASELINE_RIGHT);
        player1Box.setPadding(new Insets(5,15,5,10));
        player1Box.getChildren().addAll(labelText,player1_seeds_captured);

        fullBox.add(player1Box, 0, 0);
        
        ColumnConstraints twoColumns,twoColumns2;
        twoColumns = new ColumnConstraints();
        twoColumns.setPercentWidth(100/2.0); // divide into two places...
        twoColumns.setHalignment(HPos.LEFT);
        
        twoColumns2 = new ColumnConstraints();
        twoColumns2.setPercentWidth(100/2.0); // divide into two places...
        twoColumns2.setHalignment(HPos.RIGHT);
        fullBox.getColumnConstraints().addAll(twoColumns,twoColumns2);
        return fullBox;
    }
    
    protected GridPane getPlayer2Box(){
          
        GridPane fullBox = new GridPane();
        fullBox.setPadding(new Insets(2,5,2,5));
        fullBox.setStyle("-fx-border-style: solid;"
	                + "-fx-border-width: 1;"
	                + "-fx-border-color: black");
        fullBox.setPrefWidth(BOARD_GRID_WIDTH);
        fullBox.setMinWidth(BOARD_GRID_WIDTH);
        fullBox.setMaxWidth(BOARD_GRID_WIDTH);
        
        Text labelText = new Text("Seeds Captured by Player 2("+gameManager.playerTwoName +"):");
        labelText.getStyleClass().add("player-captured-label");
        player2_seeds_captured.setId("player-2-captured");
         
        HBox player2Box = new HBox(15);
        player2Box.getStyleClass().add("player-captured-box");
        player2Box.setAlignment(Pos.BASELINE_RIGHT);
        player2Box.setPadding(new Insets(5,35,5,10));
        player2Box.getChildren().addAll(labelText,player2_seeds_captured);

        fullBox.add(player2Box, 1, 0);
        
        ColumnConstraints twoColumns,twoColumns2;
        twoColumns = new ColumnConstraints();
        twoColumns.setPercentWidth(100/2.0); // divide into two places...
        twoColumns.setHalignment(HPos.LEFT);
        
        twoColumns2 = new ColumnConstraints();
        twoColumns2.setPercentWidth(100/2.0); // divide into two places...
        twoColumns2.setHalignment(HPos.RIGHT);
        fullBox.getColumnConstraints().addAll(twoColumns,twoColumns2);
        return fullBox;
    }
    
    protected GridPane getPlayersScorePanel(){
        
        GridPane fullBox = new GridPane();
        fullBox.setPadding(new Insets(2,5,2,5));
        fullBox.setStyle("-fx-border-style: solid;"
	                + "-fx-border-width: 1;"
	                + "-fx-border-color: black");
        fullBox.setPrefWidth(BOARD_GRID_WIDTH);
        fullBox.setMinWidth(BOARD_GRID_WIDTH);
        fullBox.setMaxWidth(BOARD_GRID_WIDTH);
        
        Text labelTopText1 = new Text("Player 1:"), labelBottomText1 = new Text("Houses Owned:"),
                labelTopText2 = new Text("Player 2:"), labelBottomText2 = new Text("Houses Owned:");
        labelTopText1.getStyleClass().add("player-name-label");
        labelTopText2.getStyleClass().add("player-name-label");
        labelBottomText1.getStyleClass().add("player-name-label");
        labelBottomText2.getStyleClass().add("player-name-label");
        
        player1_name = new Text(gameManager.playerOneName);
        player1_name.getStyleClass().add("player-names");
        player1_name.setId("player-1-name");
        
        player1_houses = new Text("6");
        player1_houses.getStyleClass().add("player-houses");
         
        
        player_1_TopBox.getStyleClass().add("player-seed-hand-box");
        player_1_TopBox.setAlignment(Pos.BASELINE_LEFT);
        player_1_TopBox.setPadding(new Insets(5,15,5,10));
        player_1_TopBox.getChildren().clear();
        player_1_TopBox.getChildren().addAll(labelTopText1,player1_name);
        
        HBox player_1_BottomBox = new HBox(15);
        player_1_BottomBox.getStyleClass().add("player-seed-hand-box");
        player_1_BottomBox.setAlignment(Pos.BASELINE_LEFT);
        player_1_BottomBox.setPadding(new Insets(5,15,5,10));
        player_1_BottomBox.getChildren().addAll(labelBottomText1,player1_houses);
         
        player2_name = new Text(gameManager.playerTwoName);
        player2_name.getStyleClass().add("player-names");
        player2_name.setId("player-2-name");
        
        player2_houses = new Text("6");
        player2_houses.getStyleClass().add("player-houses");
        
        
        player_2_TopBox.getStyleClass().add("player-seed-hand-box");
        player_2_TopBox.setAlignment(Pos.BASELINE_RIGHT);
        player_2_TopBox.setPadding(new Insets(5,15,5,10));
        player_2_TopBox.getChildren().clear();
        player_2_TopBox.getChildren().addAll(labelTopText2,player2_name);
        
        HBox player_2_BottomBox = new HBox(15);
        player_2_BottomBox.getStyleClass().add("player-seed-hand-box");
        player_2_BottomBox.setAlignment(Pos.BASELINE_RIGHT);
        player_2_BottomBox.setPadding(new Insets(5,15,5,10));
        player_2_BottomBox.getChildren().addAll(labelBottomText2,player2_houses);
        
        fullBox.add(player_1_TopBox, 0, 0);
        fullBox.add(player_1_BottomBox, 0, 1);
        fullBox.add(player_2_TopBox, 2, 0);
        fullBox.add(player_2_BottomBox, 2, 1);
        
        ColumnConstraints twoColumns,twoColumns2;
        twoColumns = new ColumnConstraints();
        twoColumns.setPercentWidth(100/3.0); // divide into three places...
        twoColumns.setHalignment(HPos.LEFT);
        
        twoColumns2 = new ColumnConstraints();
        twoColumns2.setPercentWidth(100/3.0); // divide into three places...
        twoColumns2.setHalignment(HPos.RIGHT);
        fullBox.getColumnConstraints().addAll(twoColumns,twoColumns2,twoColumns2);
        
        RowConstraints twoRows;
        twoRows = new RowConstraints();
        twoRows.setPercentHeight(100/2.0); // divide into two places...
        fullBox.getRowConstraints().addAll(twoRows,twoRows);
        
        return fullBox;
    }
    
    protected GridPane getSeedInHandBox(){
        
        GridPane fullBox = new GridPane();
        fullBox.setPadding(new Insets(2,5,2,5));
        fullBox.setStyle("-fx-border-style: solid;"
	                + "-fx-border-width: 1;"
	                + "-fx-border-color: black");
        fullBox.setPrefWidth(BOARD_GRID_WIDTH);
        fullBox.setMinWidth(BOARD_GRID_WIDTH);
        fullBox.setMaxWidth(BOARD_GRID_WIDTH);
        
        Text labelText = new Text("Seeds In Player's Hand:");
        labelText.getStyleClass().add("player-seed-hand-label");
        seedsInHand = new Text("0");
        seedsInHand.setId("player-seed-hand-amount");
         
        HBox seedsInHandBox = new HBox(15);
        seedsInHandBox.getStyleClass().add("player-seed-hand-box");
        seedsInHandBox.setAlignment(Pos.BASELINE_RIGHT);
        seedsInHandBox.setPadding(new Insets(5,15,5,10));
        seedsInHandBox.getChildren().addAll(labelText,seedsInHand);

        fullBox.add(seedsInHandBox, 1, 0);
        
        ColumnConstraints twoColumns,twoColumns2;
        twoColumns = new ColumnConstraints();
        twoColumns.setPercentWidth(100/3.0); // divide into three places...
        twoColumns.setHalignment(HPos.LEFT);
        
        twoColumns2 = new ColumnConstraints();
        twoColumns2.setPercentWidth(100/3.0); // divide into three places...
        twoColumns2.setHalignment(HPos.RIGHT);
        fullBox.getColumnConstraints().addAll(twoColumns,twoColumns2,twoColumns2);
        return fullBox;
    }   
    
    
    
    private void endCurrentGame(){
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Restart Current Ayo Game?");
        alert.setHeaderText("End and Restart the current Game?");
        alert.setContentText("Are you sure you want to end this game?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // ... user chose OK
            this.gameStopped = true;
            this.gamePaused = false;
            updateMenuState(true);
            killAllRunningThreads();
            gameManager.newGame();
        } else {
                // ... user chose CANCEL or closed the dialog
            this.gameStopped = false;
            this.gamePaused = false;
        }
    }
    
    private void goToMainMenu(){
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Go To MainMenu of this Manacala(AyoAyo) Game?");
        alert.setHeaderText("Go to MainMenu?");
        alert.setContentText("Are you sure you want to end this game and go back to the main menu?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // ... user chose OK
            this.gameStopped = true;
            this.gamePaused = true;
            killAllRunningThreads();
            this.gameManager.menuScreen();
        } else {
                // ... user chose CANCEL or closed the dialog
            this.gameStopped = false;
            this.gamePaused = false;
        }
    }
    
    private void exitGame(){
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Close Game and Exit?");
        alert.setHeaderText("Close and Exit the Game?");
        alert.setContentText("Are you sure you want to end this game and exit this application?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // ... user chose OK
            killAllRunningThreads();
            gameManager.EndGameNCloseApp();
        } else {
                // ... user chose CANCEL or closed the dialog
            this.gameStopped = false;
            this.gamePaused = false;
        }
    }
    
    protected void showBoardWinners(String player){
        
        if(player != null)
        {
            switch (player) {
                case "one":
                    statusText.setText("Player One has won this game!");
                    gameEndedAlert.setTitle("Player One Wins!");
                    gameEndedAlert.setHeaderText("Player One has Won");
                    gameEndedAlert.setContentText("Player One has won this game!\n"
                            + "Think you have got what it takes to win player One?\n"
                            + "Why not Play Again...");
                break;
                case "two":
                    statusText.setText("Player Two has won this game!");
                    gameEndedAlert.setTitle("Player Two Wins!");
                    gameEndedAlert.setHeaderText("Player Two has Won");
                    gameEndedAlert.setContentText("Player Two has won this game!\n"
                            + "Think you have got what it takes to win player Two?\n"
                            + "Why not Play Again...");
                break;
                case "tie":
                    statusText.setText("This game ended in a tie!");
                    gameEndedAlert.setTitle("It's a Tie!!!");
                    gameEndedAlert.setHeaderText("Ooops, it looks like a tie...");
                    gameEndedAlert.setContentText("Well... It looks like a tie game!\n"
                            + "Do you think you have got what it takes to break this tie?\n"
                            + "Why not Play Again...");
                break;
            }

            gameEndedAlertResult = gameEndedAlert.showAndWait();
            if (gameEndedAlertResult.get() == gameEndedAlertMainMenuBtn){
                // ... user chose "One"
                gameStopped = true;
                gamePaused = true;
                killAllRunningThreads();
                gameManager.menuScreen();
            } else if (gameEndedAlertResult.get() == gameEndedAlertPlayAgainBtn) {
                // ... user chose "Two"
                gameStopped = true;
                gamePaused = true;
                killAllRunningThreads();
                gameManager.newGame();
            }else {
                // ... user chose CANCEL or closed the dialog
            }
        }
    }
    
    protected void killAllRunningThreads(){
        isKilledThreads = true;
    }
}
