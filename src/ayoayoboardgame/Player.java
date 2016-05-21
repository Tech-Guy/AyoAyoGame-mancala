/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

/**
 *
 * @author Odigie Oseme Utibe | osemeodigie@yahoo.com | http://osemeodigie.com
 */
public class Player {
    
        // Properties: default value before the MiniMax algorithm takes effect...
    public String Name = "Tech Guy";  // default name to use if none is provided...
    public int PlayerRow = GameConstants.BOTTOM_ROW;  // use the bottom row for the First Human player...
    public boolean isTurn = false;
    public float minValue = GameConstants.PLAYER_MIN_VALUE;
    public float maxValue = GameConstants.PLAYER_MAX_VALUE;
    public float currentScore; 
    
    public Player(){

    }
   
    
}
