/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Odigie Oseme Utibe | osemeodigie@yahoo.com | http://osemeodigie.com
 */
public class AIPlayer {
    
    public String Name;
    public int PlayerRow;
    public boolean Thinking;
    public AyoGameBoard AIGameBoard;   // a public GameBoard object for the AI to use...
    private Map<String, AIPlayerTypes> playerTypes;
    
    private int depthToUse;
    private String playerType;
    private String thinkingText;
    private AyoGameManager gameManager;
    
    public AIPlayer(AyoGameManager gameManager){
        
        this.gameManager = gameManager;
       initializePlayer("beginner");
    }
    
    /**
     * Creates a new AI player
     * @param gameManager
     * @param AIName
     */
    public AIPlayer(AyoGameManager gameManager, String AIName){
          
        this.gameManager = gameManager;
        initializePlayer(AIName);
    }
    
    private void initializePlayer(String playerType){
        
            // Begineer : Normal : Hard : Very Hard
        playerType = playerType.toUpperCase();
            
         // Create a Map...       
        playerTypes = new HashMap<>();
        playerTypes.put("BEGINNER", new AIPlayerTypes("FEMI",1));   // Begineer
        playerTypes.put("INTERMIDATE", new AIPlayerTypes("KAYODE",5));  // Normal
        playerTypes.put("HARD", new AIPlayerTypes("MR. SHOLA",8));  // Hard
        playerTypes.put("VETERAN", new AIPlayerTypes("BABA IJEBU",11)); // Very Hard 
             
        PlayerRow = GameConstants.TOP_ROW;  // use the top row for the AI player...
        Thinking = false;  // initial thinking state...
        
        if(playerTypes.containsKey(playerType)){
            depthToUse = playerTypes.get(playerType).AIDepth;
            Name = playerTypes.get(playerType).PlayerName;
            this.playerType = playerType;
        }
        else{
                // Default values for the AI player...
            depthToUse = playerTypes.get("BEGINNER").AIDepth;
            Name = playerTypes.get("BEGINNER").PlayerName;
            this.playerType = "BEGINNER";
        }
        initThinkingText();  // initalize the thinking speech bubble...
    }
    
    public void setPlayerType(String playerType){
        
        playerType = playerType.toUpperCase();
        
        if(playerTypes.containsKey(playerType)){
            depthToUse = playerTypes.get(playerType).AIDepth;
            Name = playerTypes.get(playerType).PlayerName;
            this.playerType = playerType;
        }
        else{
                // Default values for the AI player...
            depthToUse = playerTypes.get("BEGINNER").AIDepth;
            Name = playerTypes.get("BEGINNER").PlayerName;
            this.playerType = "BEGINNER";
        }
    }
    
    public int getAIDepth(){
        return this.depthToUse;
    }
    
                // used to duplicate the a 2 dimensional array like the game board :)
    private int[][] GetGameBoardDuplicate(int[][] GameBoard){
        // define an array to hold the copied game board..
        int[][] result = new int[2][8];  
        for (int i = 0; i < 2; i++) {
            System.arraycopy(GameBoard[i], 0, result[i], 0, 8);
        }
        return result;
    }
    
    public void animateComputerTurn(AyoGameBoard bd){
        
            // get the best possible move...
            // the play it as the computer...
        AIGameBoard = new AyoGameBoard();
        AIGameBoard.SetGameBoard(GetGameBoardDuplicate(bd.GetGameBoard()));
        AIGameBoard.initial_seeds_in_bin = gameManager.seedPerHouse;
        int best_bin = bestMove();
        bd.AnimatePlayTurn(0, best_bin-1);
    }
    
    public int bestMove() {

        int bestMove = 1;
        AyoGameBoard duplicateGameBoard = AIGameBoard;
        duplicateGameBoard.SetGameBoard(GetGameBoardDuplicate(AIGameBoard.GetGameBoard()));
        
        float currentMaximumScore = MiniMaxFunction(1, duplicateGameBoard, new Player(), new Player());
        
        for (int j = 2; j <= 6; j++) {
            AyoGameBoard duplicateGameBoard1 = AIGameBoard;
            duplicateGameBoard1.SetGameBoard(GetGameBoardDuplicate(AIGameBoard.GetGameBoard()));
            
            float f = MiniMaxFunction(j, duplicateGameBoard1, new Player(),new Player());

            // the Math random here is used to simulate a more realistic game play when there
            // is more than one choices (graph node) that give the same maximum score...
            if (f > currentMaximumScore || (f == currentMaximumScore && (Math.random() < .5))) {
                currentMaximumScore = f;  // The maximum score so far...
                bestMove = j;  // The best move so far that maximizes the AI's score...
            }
        }

            // We must have picked up an empty bin by mistake.... :-(
                // and there are a lot of empty bins so we look for the first non-empty one we can find :-)
        if (currentMaximumScore == GameConstants.EMPTY_BIN) {

            for (int j = 1; j <= 6; j++) {
                AyoGameBoard duplicateGameBoard2 = AIGameBoard;
                duplicateGameBoard2.SetGameBoard(GetGameBoardDuplicate(AIGameBoard.GetGameBoard()));
                if (duplicateGameBoard2.GetGameBoard()[this.PlayerRow][j] > 0) {
                    return j;
                }
            }
        }
        return bestMove;
    }


            // This uses the standard minMax algorithm to search through the game tree....
                // This is based on the Greedy Algorithm method of searching through a graph...
    // Could optimize this later...
    public float MiniMaxFunction(int selectedBin, AyoGameBoard GameBoard, Player player1, Player player2) {

        int player = GameBoard.GetGameBoard()[0][7];  // get the current player's turn....

        if (GameBoard.IsBinEmpty(player, selectedBin)) {
                return GameConstants.EMPTY_BIN;  // We cannot grab an empty bin...
        }
        float gm = GameBoard.PlayTurn(player, selectedBin);
       
        if (GameBoard.CheckBoardForWinners(false) != GameConstants.GAME_CONTINUES) {
            
            // looks like we have a winner, return the winner/draw, else keep playing...
           return (float)GameBoard.CheckBoardForWinners(false);  
        }
                    // check if the turn of player has changed...
                // This is used to decide whether to maximize the score or to minimize it...
        boolean change = (GameBoard.GetGameBoard()[0][7] == player);
        player = GameBoard.GetGameBoard()[0][7];

        Player nextPlayer1;
        Player nextPlayer2;
        if (change) {
            nextPlayer1 = new Player();
            nextPlayer2 = player1;
        }
        else {
               // maintain the player's turns...
            nextPlayer1 = player1;
            nextPlayer2 = player2;
        }

        int depth = GameBoard.GetGameBoard()[1][7];
            // If loop at final search depth, then calculate the 
            // max score that the current AI player will get...
        if (depth == 0) {
            return GameBoard.GetGameBoard()[this.PlayerRow][0] - GameBoard.GetGameBoard()[1-this.PlayerRow][0];
        }
            // human player, then minimize the AI Player's score...
        if (player != this.PlayerRow) {
               
            AyoGameBoard duplicateGameBoard = GameBoard;
            duplicateGameBoard.SetGameBoard(GetGameBoardDuplicate(GameBoard.GetGameBoard()));
            float currentMinimumScore = MiniMaxFunction(1, duplicateGameBoard, nextPlayer1, nextPlayer2);
            for (int i = 2; i <= 6; i++) {
                if (change) {
                    nextPlayer1 = new Player();
                }
                AyoGameBoard duplicateGameBoard1 = GameBoard;
                duplicateGameBoard1.SetGameBoard(GetGameBoardDuplicate(GameBoard.GetGameBoard()));
                float f = MiniMaxFunction(i, duplicateGameBoard1, nextPlayer1, nextPlayer2);
                    // Minimize the minimum player 2 score and make sure the value is not an empty bin
                if((player2.minValue > f) && (f > GameConstants.EMPTY_BIN)){
                    return f;
                }
                
                    // Minimize the Maximum player 1 score and make sure the value is not an empty bin
                if ((player1.maxValue > f) && (f > GameConstants.EMPTY_BIN)) {
                    player1.maxValue = f;
                }

                if (((f < currentMinimumScore) && (f > 20 + GameConstants.EMPTY_BIN)) 
                        || (currentMinimumScore <= GameConstants.EMPTY_BIN + 10)) {
                    currentMinimumScore = f;
                }
            }
            if (currentMinimumScore == GameConstants.EMPTY_BIN) {
                    // There must be an error somewhere in the minMax method...
                        // We mistakenly picked an empty bin...
                 return GameConstants.EMPTY_BIN;  // We cannot grab an empty bin...
            }
            return currentMinimumScore;
        } 
        else {  // AIPlayer, maximize the AI's scores...
            
            AyoGameBoard duplicateGameBoard = GameBoard;
            duplicateGameBoard.SetGameBoard(GetGameBoardDuplicate(GameBoard.GetGameBoard()));
            float currentMaximumScore = MiniMaxFunction(1, duplicateGameBoard, nextPlayer1, nextPlayer2);
            for (int i = 2; i <= 6; i++) {
                    if (change) {
                            nextPlayer1 = new Player();
                    }
                    AyoGameBoard duplicateGameBoard1 = GameBoard;
                    duplicateGameBoard1.SetGameBoard(GetGameBoardDuplicate(GameBoard.GetGameBoard()));
                    float f = MiniMaxFunction(i, duplicateGameBoard1, nextPlayer1, nextPlayer2);
                    if((player2.maxValue < f) && (f > GameConstants.EMPTY_BIN)){
                            return f;
                    }
                    if ((player1.minValue < f) && (f > GameConstants.EMPTY_BIN)) {
                            player1.minValue = f;
                    }


                    if (f > currentMaximumScore) {
                            currentMaximumScore = f;
                    }
            }
            if (currentMaximumScore == GameConstants.EMPTY_BIN) {

                // There must be an error somewhere in the minMax method...
                    // We mistakenly picked an empty bin...
                 return GameConstants.EMPTY_BIN;  // We cannot grab an empty bin...
            }
            return currentMaximumScore;
        }
    }
    
            // The method that gets the final greedy algorithm heuristic value for the minMax function....
            // deprecated...
    public int MaxScoreObtainableFromPlay(AyoGameBoard GameBoard){
         
        return GameBoard.GetGameBoard()[this.PlayerRow][0] - GameBoard.GetGameBoard()[1-this.PlayerRow][0];    
    }
    
    /**
     * This returns the player type of this AI player...
     * @return playerType
     */
    public String getPlayerType(){
        return playerType;
    }
    
    public void SetThinkingText(String newText){
        
        this.thinkingText = newText;
    }
    
    private void initThinkingText(){
        switch(this.Name){
            
            default:
            case "FEMI":
                this.thinkingText = "";
            break;
                
            case "KAYODE":
                this.thinkingText = "";      
            break;
                
            case "IYA BOSE":
                this.thinkingText = "";      
            break;
                 
            case "BABA IJEBU":
                this.thinkingText = "";      
            break;   
        }  
        
    }
    
    
}
