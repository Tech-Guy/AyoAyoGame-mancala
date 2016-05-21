/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

import java.awt.Point;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.layout.Pane;

/**
 *
 * @author Odigie Oseme Utibe | osemeodigie@yahoo.com | http://osemeodigie.com
 */
public class AyoGameBoard extends AyoGameBoardScreenGraphics {
    
    
    private int[][] AyoGameBoard;  // This is the main game board array... It is a 2D array
    
    public int[] playerScores;
    public int currentAIDepth, turnOfPlayer, initial_seeds_in_bin;
    
    private double topContainerHeight,statusBarHeight;
    
        // This creates a new game board...
    public AyoGameBoard()
    {
            // create a new int 2D array to hold all the game board variables...
        AyoGameBoard = new int[2][8];
        playerScores = new int[2];  // hold the scores of the players.. 
    }
    
    public AyoGameBoard(AyoGameManager gameMgr, boolean getGraphics)
    {
        super(gameMgr);
            // create a new int 2D array to hold all the game board variables...
        AyoGameBoard = new int[2][8];
        playerScores = new int[2];  // hold the scores of the players...
        initial_seeds_in_bin = gameMgr.seedPerHouse;
    }
    
    public void InitializeThisGameBoard(boolean getGraphics){
        
        AyoGameBoard = new int[2][8];
        playerScores = new int[2];  // hold the scores of the players..
        if(getGraphics){
            initGameBoardGraphics();
        }
        initGameBoard4NewGame();
    }
    
    private void initGameBoardGraphics(){
        
        this.setCenter(centerWindowArea);  // Draw in the center area of the screen...
        topContainerHeight = drawTopMenuBar();   // Draw the Menu Bar at the Top of the window...
        statusBarHeight = drawStatusBar();  // Draw the status bar at the bottom of the window...
    }
    
        // This method only plays a turn based on whose turn it is to play...
        // The player's turn is saved right into the gameBoard Array...
    public float PlayTurn(int selected_bin_row, int selected_bin_col)
    {
            // The player turn data is held in the last column
                //of the top row in the array...
        int player = AyoGameBoard[0][7];
        turnOfPlayer = player;
        int seedsInHand = AyoGameBoard[selected_bin_row][selected_bin_col];
        AyoGameBoard[selected_bin_row][selected_bin_col] = 0;  // empty the grabbed bin...
        
        if (seedsInHand == 0){
            // Cannot pick up an empty bin... // Error must have occured!
            return GameConstants.EMPTY_BIN;
        }
        while (seedsInHand > 0) {
            Point p = nextHole(selected_bin_row, selected_bin_col, player);
            selected_bin_row = p.x;
            selected_bin_col = p.y;
            seedsInHand--;  // decrement the seed in the player's hand...
            AyoGameBoard[selected_bin_row][selected_bin_col]++;  // add one seed to the bin..
                
                // if the starting seeds are found in a bin and the player is not dropping the last seed...
           if (AyoGameBoard[selected_bin_row][selected_bin_col] == initial_seeds_in_bin && (seedsInHand > 0)) {

                    // copy the content of that bin to the owner's score bin..
                AyoGameBoard[selected_bin_row][0] += AyoGameBoard[selected_bin_row][selected_bin_col];
                AyoGameBoard[selected_bin_row][selected_bin_col] = 0; // empty the bin...
                UpdatePlayerScores();  // this might not be needed here.. will slow the algorithm down.
            }
        }
        
        // Decrement the Search Depth Level (used by the AI player to "look ahead"...
        AyoGameBoard[1][7]--;
        currentAIDepth = AyoGameBoard[1][7];
            // If the player's hand landed in a bin that is not empty
            // continue again, else check if he landed in a bin that has the starting seeds and claim the seeds...
        if (AyoGameBoard[selected_bin_row][selected_bin_col] == initial_seeds_in_bin ) {
            AyoGameBoard[player][0] += AyoGameBoard[selected_bin_row][selected_bin_col];
            AyoGameBoard[selected_bin_row][selected_bin_col] = 0; // empty the claimed bin..
                // switch player's turn...
            AyoGameBoard[0][7] = 1 - AyoGameBoard[0][7];
            turnOfPlayer = AyoGameBoard[0][7];
            UpdatePlayerScores();
        }
        else if ((AyoGameBoard[selected_bin_row][selected_bin_col] > 1) && (AyoGameBoard[selected_bin_row][selected_bin_col] != initial_seeds_in_bin)) {
            PlayTurn(selected_bin_row, selected_bin_col);
        }
        else if(AyoGameBoard[selected_bin_row][selected_bin_col] == 1)
        {
                // switch player's turn...
            AyoGameBoard[0][7] = 1 - AyoGameBoard[0][7];
            turnOfPlayer = AyoGameBoard[0][7];
            UpdatePlayerScores();
        }
        return (float)1.0;  // completed playing the turn...
    }
    
    /**
     * Not yet implemented the History Manager...
     * @param turns
     */
    public void UndoPlayTurn(int turns)
    {
        // Will create a game History Manager to manage the Undo/Redo Move functionality
        
    }
    
        // This checks the current game board for winners/losers/draws if any...
    public int CheckBoardForWinners(boolean isGraphics)
    {
        boolean isPlayerOneBinsEmpty = false;
        boolean isPlayerTwoBinsEmpty = false;
        
                // Check if any of player1 or player2 bins are empty...
            
        if(IsBinEmpty(0, 1) && IsBinEmpty(0, 2) && IsBinEmpty(0, 3) && IsBinEmpty(0, 4) &&
                IsBinEmpty(0, 5) && IsBinEmpty(0, 6)){
            isPlayerOneBinsEmpty = true;
        }
        if(IsBinEmpty(1, 1) && IsBinEmpty(1, 2) && IsBinEmpty(1, 3) && IsBinEmpty(1, 4) &&
                IsBinEmpty(1, 5) && IsBinEmpty(1, 6)){
            isPlayerTwoBinsEmpty = true;
        }

        int ayoSeedsLeft = (initial_seeds_in_bin * 12) - playerScores[0] - playerScores[1];
        
        if ((!isPlayerOneBinsEmpty && !isPlayerTwoBinsEmpty) || (ayoSeedsLeft > initial_seeds_in_bin)) {
            return GameConstants.GAME_CONTINUES;
        }
        else
        {
            if (isPlayerOneBinsEmpty && !isPlayerTwoBinsEmpty && (ayoSeedsLeft == initial_seeds_in_bin)) {
                    // The remaining (starting seeds) ayo seeds are claimed by the player that has them in his/her bins...
                AyoGameBoard[1][0] += ayoSeedsLeft;
                clearBinsOnBoard(); // game has ended so clear the playing bins on this ayo board...
                if(isGraphics){
                   gameGrid.EmptyAllBins();
                   UpdatePlayerScores(isGraphics);
                //   showBoardWinners("two");
                }
                else{
                    UpdatePlayerScores();
                }
            }
            else if (!isPlayerOneBinsEmpty && isPlayerTwoBinsEmpty && (ayoSeedsLeft == initial_seeds_in_bin)) {
                    // The remaining 4 ayo seeds are claimed by the player that has them in his/her bins...
                AyoGameBoard[0][0] += ayoSeedsLeft;
                clearBinsOnBoard(); // game has ended so clear the playing bins on this ayo board...
                if(isGraphics){
                    gameGrid.EmptyAllBins();                   
                    UpdatePlayerScores(isGraphics);
                //    showBoardWinners("two");
                }
                else{
                    UpdatePlayerScores();
                }
            }
            
            
            if(playerScores[0] < playerScores[1]){
             //   showBoardWinners("two");
                return GameConstants.PLAYER_2_WINS;  // player 2 wins...
            }
            else if(playerScores[0] == playerScores[1]){
              //  showBoardWinners("tie");
                return GameConstants.PLAYERS_TIE;  // players draw... It is a tie game...
            }
            else {
              //  showBoardWinners("one");
                return GameConstants.PLAYER_1_WINS;  // player 1 wins...
            }
        }
    }
    
        // This is used to play(drop ayo seeds correctly) through the game board...
    private Point nextHole(int i, int j, int player)
    {        
        ////////////// This simulates an anti-clockwise movement of the player's hand//////////////////
        if (i == 0) 
            j--;  // if hand is at the top row of the game board then go left 
        else
            j++;  // if hand is at the bottom row, go right...
        ///////////////////////////////////////////////////////////////////////////////////////////
        
        
             // If the player's hand reached the last bin on the left 
                // then go down to the bottom row and continue right...
        if (j <= 0) 
        {
            j = 1;
            i = 1;
        }

        // If the player's hand reached the last bin on the right 
            // then go up to the top row and continue left...
        if (j > 6) 
        {
            j = 6;
            i = 0;
        }
        return new Point(i, j);
    }
    
        // This is used to play(drop ayo seeds correctly) through the game board...
    private Point nextHole(int i, int j, int player, boolean isGraphics)
    {        
        ////////////// This simulates an anti-clockwise movement of the player's hand//////////////////
        if (i == 0) 
            j--;  // if hand is at the top row of the game board then go left 
        else
            j++;  // if hand is at the bottom row, go right...
        ///////////////////////////////////////////////////////////////////////////////////////////
        
        
             // If the player's hand reached the last bin on the left 
                // then go down to the bottom row and continue right...
        if (j < 0) 
        {
            j = 0;
            i = 1;
        }

        // If the player's hand reached the last bin on the right 
            // then go up to the top row and continue left...
        if (j > 5) 
        {
            j = 5;
            i = 0;
        }
        return new Point(i, j);
    }
    
        // Used to empty the players bins on this Ayo Board...
    private void clearBinsOnBoard()
    {
        for (int j = 1; j <= 6; j++) {
            AyoGameBoard[0][j] = 0;  // set all the top row bins to zero...
            AyoGameBoard[1][j] = 0;  // set all the bottom row bins to zero...
        }
    }
    
    public void UpdatePlayerScores()
    {
        playerScores[0] = AyoGameBoard[0][0];
        playerScores[1] = AyoGameBoard[1][0];
            // Do some other stuff here...
    }
    
    public void UpdatePlayerScores(boolean isGraphics)
    {
        playerScores[0] = AyoGameBoard[0][0];
        playerScores[1] = AyoGameBoard[1][0];
            // Do some other stuff here...
        player1_seeds_captured.setText(""+playerScores[0]);
        player2_seeds_captured.setText(""+playerScores[1]);
    }
    
        // Return the Ayo Game Board Array...
    public int[][] GetGameBoard(){
    
        return AyoGameBoard;
    }
    
        // Sets the Ayo Game Board Array to this one...
    public void SetGameBoard(int[][] newGameBoard){
    
       AyoGameBoard = newGameBoard;
    }
    
    public boolean IsBinEmpty(int player, int selectedHole){
        
         return (AyoGameBoard[player][selectedHole] == 0);
        
    }
    
    /**
     * This method creates the game play animation....
     * The Animation is managed by a task object that is run in a thread...
     * @param selectedBin
     */
    int selectedBin_Row, selectedBin_Col,
            selectedBin_g_Row, selectedBin_g_Col;
    long animationPauseTime = 400;
    public void AnimatePlayTurn(int selected_bin_row, int selected_bin_col){
        
        selectedBin_Row = selected_bin_row;
        selectedBin_Col = selected_bin_col+1;
        selectedBin_g_Row = selected_bin_row;
        selectedBin_g_Col = selected_bin_col;
        
        AnimatePlayTurnTask = new Task<Void>() {

            @Override
            protected Void call() throws InterruptedException {

                if(isKilledThreads)
                    this.cancel();
                
                gameGrid.DisableAllBins(true);
                    // The player's turn data is held in the last column
                        //of the top row in the array...
                int player = AyoGameBoard[0][7];
                turnOfPlayer = player;
                int seeds_in_hand = AyoGameBoard[selectedBin_Row][selectedBin_Col];
                             
                if (seeds_in_hand == 0){
                        // Cannot pick up an empty bin... // Error must have occured!
                    gameGrid.DisableAllBins(false);
                    this.cancel();  // Stop this thread from executing...   
                }else{
                    AyoGameBoard[selectedBin_Row][selectedBin_Col] = 0;  // empty the grabbed bin...
                    gameGrid.AyoBins[selectedBin_Row][selectedBin_g_Col].EmptyThisBin();
                    if(gameManager.isGameSound){
                        Platform.runLater(() -> {
                            gameManager.mediaPlayer_Fx.stop();
                            gameManager.mediaPlayer_Fx.play();
                        });
                    }
                    Thread.sleep(animationPauseTime); // pause for sometime...
                }
                while (seeds_in_hand > 0 && !isKilledThreads) {
                    
                    if (isCancelled()){
                        gameGrid.DisableAllBins(false);
                        gameGrid.EnableBins(player);
                        break;
                    }
                    Point p = nextHole(selectedBin_Row, selectedBin_Col, player);
                    Point p_graphics = nextHole(selectedBin_Row, selectedBin_g_Col, player, true);
                    
                    selectedBin_Row = p.x;
                    selectedBin_Col = p.y;
                    selectedBin_g_Row = p_graphics.x;
                    selectedBin_g_Col = p_graphics.y;
                    seeds_in_hand--;  // decrement the seed in the player's hand...
                    seedsInHand.setText(""+seeds_in_hand);
                    Thread.sleep(animationPauseTime); // pause for sometime...
                    AyoGameBoard[selectedBin_Row][selectedBin_Col]++;  // add one seed to the bin..
                    gameGrid.AyoBins[selectedBin_g_Row][selectedBin_g_Col].AddOneAyoSeed();
                    if(gameManager.isGameSound){
                        Platform.runLater(() -> {
                            gameManager.mediaPlayer_Fx.stop();
                            gameManager.mediaPlayer_Fx.play();
                        });
                    }
                    Thread.sleep(animationPauseTime); // pause for sometime...

                        // if (the starting seeds) seeds are found in a bin and the player is not dropping the last seed...
                   if (AyoGameBoard[selectedBin_Row][selectedBin_Col] == initial_seeds_in_bin && (seeds_in_hand > 0)) {

                                // copy the content of that bin to the owner's score bin..
                        AyoGameBoard[selectedBin_Row][0] += AyoGameBoard[selectedBin_Row][selectedBin_Col];
                        AyoGameBoard[selectedBin_Row][selectedBin_Col] = 0; // empty the bin...
                        Thread.sleep(600);
                        gameGrid.AyoBins[selectedBin_g_Row][selectedBin_g_Col].EmptyThisBin();
                        if(gameManager.isGameSound){
                            Platform.runLater(() -> {
                                gameManager.mediaPlayer_Fx.stop();
                                gameManager.mediaPlayer_Fx.play();
                            });
                        }
                        UpdatePlayerScores(true);  // this might not be needed here.. will slow the algorithm down.
                    }
                }
                AyoGameBoard[1][7] = gameManager.computerPlayer.getAIDepth();
                    // If the player's hand landed in a bin that is not empty
                    // continue again, else check if he landed in a bin that has (the starting seeds) seeds and claim the seeds...
                
                if (AyoGameBoard[selectedBin_Row][selectedBin_Col] == initial_seeds_in_bin ) {
                    AyoGameBoard[player][0] += AyoGameBoard[selectedBin_Row][selectedBin_Col];
                    AyoGameBoard[selectedBin_Row][selectedBin_Col] = 0; // empty the claimed bin..
                    gameGrid.AyoBins[selectedBin_g_Row][selectedBin_g_Col].EmptyThisBin();
                    if(gameManager.isGameSound){
                        Platform.runLater(() -> {
                            gameManager.mediaPlayer_Fx.stop();
                            gameManager.mediaPlayer_Fx.play();
                        });
                    }
                        // switch player's turn...
                    AyoGameBoard[0][7] = 1 - AyoGameBoard[0][7];
                    turnOfPlayer = AyoGameBoard[0][7];
                    Thread.sleep(200);

                    UpdatePlayerScores(true);                    
                    int isWinnerStatus = CheckBoardForWinners(true);

                    if(isWinnerStatus == GameConstants.GAME_CONTINUES){

                        Thread.sleep(200);
                        if(AyoGameBoard[0][7] == 0){
                            player_1_TopBox.getStyleClass().add("active-player-highlight");
                            player_2_TopBox.getStyleClass().remove("active-player-highlight");
                        }
                        else{
                            player_1_TopBox.getStyleClass().remove("active-player-highlight");
                            player_2_TopBox.getStyleClass().add("active-player-highlight");
                        }
                        turnOfPlayer = AyoGameBoard[0][7];

                        Thread.sleep(300);
                        gameGrid.DisableAllBins(false);
                        gameGrid.EnableBins(AyoGameBoard[0][7]);
                            // Its the computer's turn to play...
                        if((!gameManager.isHumanplayer) && (AyoGameBoard[0][7] == 0) && !isCancelled()){
                            cancel();

                            Platform.runLater(() -> {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException ex) {

                                }
                                gameManager.computerPlayer.animateComputerTurn(getThisBoard());
                                cancel();

                            });
                            cancel();
                        }
                    }
                    else{
                            // Disable all the Bins...
                        gameGrid.DisableAllBins(true);
                        // Display Winner and clear the game board...
                        if(isWinnerStatus == GameConstants.PLAYER_1_WINS){
                            Platform.runLater(() -> {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException ex) {

                                }
                                showBoardWinners("one");
                                cancel();
                            });   
                        }
                        else if(isWinnerStatus == GameConstants.PLAYER_2_WINS){
                            Platform.runLater(() -> {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException ex) {

                                }
                                showBoardWinners("two");
                                cancel();
                            });
                        }
                        else if(isWinnerStatus == GameConstants.PLAYERS_TIE){
                            Platform.runLater(() -> {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException ex) {

                                }
                                showBoardWinners("tie");
                                cancel();
                            });
                        }
                    }             
                }
                else if ((AyoGameBoard[selectedBin_Row][selectedBin_Col] > 1) && (AyoGameBoard[selectedBin_Row][selectedBin_Col] != initial_seeds_in_bin)) {
                    Thread.sleep(400);
                    AnimatePlayTurn(selectedBin_g_Row, selectedBin_g_Col);
                    cancel();
                }
                else if(AyoGameBoard[selectedBin_Row][selectedBin_Col] == 1)
                {

                    UpdatePlayerScores(true);                    
                    int isWinnerStatus = CheckBoardForWinners(true);

                    if(isWinnerStatus == GameConstants.GAME_CONTINUES){
                        
                            // switch player's turn...
                        AyoGameBoard[0][7] = 1 - AyoGameBoard[0][7];
                        Thread.sleep(200);
                        if(AyoGameBoard[0][7] == 0){
                            player_1_TopBox.getStyleClass().add("active-player-highlight");
                            player_2_TopBox.getStyleClass().remove("active-player-highlight");
                        }
                        else{
                            player_1_TopBox.getStyleClass().remove("active-player-highlight");
                            player_2_TopBox.getStyleClass().add("active-player-highlight");
                        }
                        turnOfPlayer = AyoGameBoard[0][7];

                        Thread.sleep(300);
                        gameGrid.DisableAllBins(false);
                        gameGrid.EnableBins(AyoGameBoard[0][7]);
                            // Its the computer's turn to play...
                        if((!gameManager.isHumanplayer) && (AyoGameBoard[0][7] == 0) && !isCancelled()){
                            cancel();

                            Platform.runLater(() -> {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException ex) {

                                }
                                gameManager.computerPlayer.animateComputerTurn(getThisBoard());
                                cancel();

                            });
                            cancel();
                        }
                    }
                    else{
                            // Disable all the Bins...
                        gameGrid.DisableAllBins(true);
                        // Display Winner and clear the game board...
                        if(isWinnerStatus == GameConstants.PLAYER_1_WINS){
                            Platform.runLater(() -> {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException ex) {

                                }
                                showBoardWinners("one");
                                cancel();
                            });   
                        }
                        else if(isWinnerStatus == GameConstants.PLAYER_2_WINS){
                            Platform.runLater(() -> {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException ex) {

                                }
                                showBoardWinners("two");
                                cancel();
                            });
                        }
                        else if(isWinnerStatus == GameConstants.PLAYERS_TIE){
                            Platform.runLater(() -> {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException ex) {

                                }
                                showBoardWinners("tie");
                                cancel();
                            });
                        }
                    }
                }
                return null;
            }
        };
        
                    // Start the thread to animate a playing turn...
        AnimatePlayThread = new Thread(AnimatePlayTurnTask);
        AnimatePlayThread.setDaemon(true);
        AnimatePlayThread.start();
    }
    
    private AyoGameBoard getThisBoard(){
        return this;
    }
           
    

    /**
     * Returns a BorderPane(window) with a beautifully drawn game board into it
     * @return
     */
    public Pane GetDrawnGameBoard(){
        centerWindowArea.getStyleClass().add("main-game-board-window");
        
        centerBoxVertical.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT - topContainerHeight - statusBarHeight);
        centerBoxVertical.setMinSize(WINDOW_WIDTH, WINDOW_HEIGHT - topContainerHeight - statusBarHeight);
        centerBoxVertical.setMaxSize(WINDOW_WIDTH, WINDOW_HEIGHT - topContainerHeight - statusBarHeight);
        centerWindowArea.getChildren().add(getMainGameBoardGraphics());

        return this;
    }

    /**
     * Used to set the visual theme of the game board...
     * I haven't written this method yet
     */
    public void SetBoardTheme(){
        
        
    }
    
    private void initGameBoard4NewGame(){
        
        initial_seeds_in_bin = gameManager.seedPerHouse;
        isKilledThreads = false;
        
        for (int j = 1; j <= 6; j++) {
                // initialize all the bins to the starting seeds per bin...
            AyoGameBoard[0][j] = gameManager.seedPerHouse;  
            AyoGameBoard[1][j] = gameManager.seedPerHouse;
        }
        AyoGameBoard[0][0] = 0;  
        AyoGameBoard[1][0] = 0;
        AyoGameBoard[0][7] = gameManager.whoStartsFirst;
        AyoGameBoard[1][7] = gameManager.computerPlayer.getAIDepth();
        gameGrid.EnableBins(gameManager.whoStartsFirst);
        UpdatePlayerScores();
        player1_seeds_captured.setText(""+playerScores[0]);
        player2_seeds_captured.setText(""+playerScores[1]);
        player_1_TopBox.getStyleClass().add("player-type-box");
        player_2_TopBox.getStyleClass().add("player-type-box");
        if(AyoGameBoard[0][7] == 0){
            player_1_TopBox.getStyleClass().add("active-player-highlight");
            player_2_TopBox.getStyleClass().remove("active-player-highlight");
        }
        else{
            player_1_TopBox.getStyleClass().remove("active-player-highlight");
            player_2_TopBox.getStyleClass().add("active-player-highlight");   
        }
        
        if((gameManager.whoStartsFirst == 0) && (!gameManager.isHumanplayer)){

            computerStartTurn();
        } 
    }
    
    
    private void computerStartTurn(){

        Task computerStartTurnTask = new Task<Void>() {

            @Override
            protected Void call() throws InterruptedException {

                Thread.sleep(3000);
                    Platform.runLater(() -> {
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException ex) {

                        }
                        gameManager.computerPlayer.animateComputerTurn(getThisBoard());
                    });
                cancel();
                return null;
            }
        };
            // Start the thread to animate a playing turn...
        Thread computerStartTurnThread = new Thread(computerStartTurnTask);
        computerStartTurnThread.setDaemon(true);
        computerStartTurnThread.start();
    }
   
}
