/*
 * This is the GameBoardGrid object... 
 * The game board grid represents the main board playing area.. I.E. The bins on the Ayo Board... 
 */
package ayoayoboardgame;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author Odigie Oseme Utibe | osemeodigie@yahoo.com | http://osemeodigie.com
 */
public class AyoGameBoardGridGraphics extends GridPane {
    
    private double WINDOW_HEIGHT = 950, WINDOW_WIDTH = 1200;
    private double BOARD_GRID_HEIGHT = 450, BOARD_GRID_WIDTH = 1000;
    
    private final AyoGameManager gameManager;
    
    protected AyoGameBoardBin[][] AyoBins;
    
    public AyoGameBoardGridGraphics(AyoGameManager gameMgr){
    
        gameManager = gameMgr;
        this.WINDOW_HEIGHT = gameMgr.WINDOW_HEIGHT;
        this.WINDOW_WIDTH = gameMgr.WINDOW_WIDTH;
        
        this.BOARD_GRID_HEIGHT = (WINDOW_HEIGHT * GameConstants.BOARD_HEIGHT_PERCENTAGE) - 150;
        this.BOARD_GRID_WIDTH = WINDOW_WIDTH * GameConstants.BOARD_WIDTH_PERCENTAGE;
        
        this.AyoBins = new AyoGameBoardBin[2][6];
    }
    
    /**
     * Set this object back to its initial state and return it...
     * @return
     */
    public AyoGameBoardGridGraphics getInitialGameGrid(){
        
        initGameGrid();
        return this;
    }
    
    /**
     * Returns this object as it is...
     * @return
     */
    public AyoGameBoardGridGraphics getCurrentGameGrid(){
        
        return this;
    }
    
    /**
     * This will set this game grid to its initial configuration...
     */
    public void initGameGrid(){
        
        if(!getChildren().isEmpty())
            getChildren().clear(); // remove all previous edits...
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                
                AyoBins[i][j] = new AyoGameBoardBin((BOARD_GRID_WIDTH*0.14), (BOARD_GRID_HEIGHT*0.4));
                AyoBins[i][j].getStyleClass().add("grid-canvas");
                AyoBins[i][j].setCursor(Cursor.HAND);
                add(AyoBins[i][j], j, i);
                    // Initialise the game board to the initial starting seeds...
                AyoBins[i][j].SetAyoSeeds(gameManager.seedPerHouse);
                addBinClickEvent(AyoBins[i][j], i, j);

            }
            // After top row maybe do something here... later...
        }
        
        getChildren().stream().map((n) -> {
            // Check whether the grid cell content is a control or pane and style accordily
            if (n instanceof Control){
                Control c = (Control)n;
                c.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                c.getStyleClass().add("grid-canvas-box");
            }
            return n;
        }).filter((n) -> (n instanceof Pane)).map((n) -> (Pane)n).map((c) -> {
            c.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            return c;
        }).forEach((c) -> {
            c.getStyleClass().add("grid-canvas-box");
        });
            
        // Style the grid so that the cells have spaces b/w them
        getStyleClass().add("game-board");  // add the css class name to this board grid
    
        setPrefSize(BOARD_GRID_WIDTH, BOARD_GRID_HEIGHT);
        setMinSize(BOARD_GRID_WIDTH, BOARD_GRID_HEIGHT);
        setMaxSize(BOARD_GRID_WIDTH, BOARD_GRID_HEIGHT);

    //    this.setGridLinesVisible(true);  // for debugging...
        setAlignment(Pos.CENTER);
        
            // Make grid lines have same width by turning off pixel snapping...
        setSnapToPixel(false);

            // Make sure that the grid will fill the available area (I want to use a canvas as the bin...
          // Set a column constraint to make sure we fit the six columns as accurately as possible...
        ColumnConstraints sixColumns = new ColumnConstraints();
        sixColumns.setPercentWidth(100/6.0); // divide into six places...
        sixColumns.setHalignment(HPos.CENTER);
        getColumnConstraints().addAll(sixColumns,sixColumns,sixColumns,sixColumns,sixColumns,sixColumns);

        // Set a row constraint to make sure we fit the two rows as accurately as possible...
        RowConstraints twoRows = new RowConstraints();
        twoRows.setPercentHeight(100/2.0); // divide into two places...
        twoRows.setValignment(VPos.CENTER);
        getRowConstraints().addAll(twoRows,twoRows);
    }
    
       // Add Mouse Event Handler to all the Ayo Bins...
    private void addBinClickEvent(AyoGameBoardBin bd, int current_row, int current_col){
        bd.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent t) -> {
            if (bd.AyoSeedsInBin.currentAyoSeedsInHole != 0){
                gameManager.getGameBoard().AnimatePlayTurn(current_row, current_col);  
            }
        });
    }
   
    public void EmptyAllBins(){
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                AyoBins[i][j].EmptyThisBin();
            }
        }
    }
    
    public void EnableBins(int player){
        
        for (int j = 0; j < 6; j++) {
            AyoBins[1-player][j].setDisable(true);
            AyoBins[player][j].setDisable(false);
        }
    }
    
    public void DisableAllBins(boolean state){
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                AyoBins[i][j].setDisable(state);
            }
        }
    }
        
      
    
}
