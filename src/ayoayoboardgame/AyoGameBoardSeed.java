/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Odigie Oseme Utibe | osemeodigie@yahoo.com | http://osemeodigie.com
 */
public class AyoGameBoardSeed {
    
    // Properties of the Ayo seeds object...
    private final GraphicsContext gc;
    private final SeedPositions Pos;
    
    public int currentAyoSeedsInHole;
        
    private final double CanvasWidth, CanvasHeight;
    
    
    public AyoGameBoardSeed(GraphicsContext gc){
        
        this.gc = gc;
        currentAyoSeedsInHole = 0;
        CanvasWidth = gc.getCanvas().getWidth() * (GameConstants.BIN_PERCENTAGE_USAGE);
        CanvasHeight = gc.getCanvas().getHeight() * (GameConstants.BIN_PERCENTAGE_USAGE);
        
        Pos = new SeedPositions();
        Pos.CanvasHeight = CanvasHeight;
        Pos.CanvasWidth = CanvasWidth;
        Pos.seedsDiameter = GameConstants.SEEDS_DIAMETER;
    }
    
    public AyoGameBoardSeed(GraphicsContext gc, int numberOfSeeds){
        
        this.gc = gc;
        currentAyoSeedsInHole = numberOfSeeds;
        CanvasWidth = gc.getCanvas().getWidth() * (GameConstants.BIN_PERCENTAGE_USAGE);
        CanvasHeight = gc.getCanvas().getHeight() * (GameConstants.BIN_PERCENTAGE_USAGE);
        
        Pos = new SeedPositions();
        Pos.CanvasHeight = CanvasHeight;
        Pos.CanvasWidth = CanvasWidth;
        Pos.seedsDiameter = GameConstants.SEEDS_DIAMETER;
    }
    
        // Were I draw the Ayo Seeds into the Canvas(Bins)
    private void drawSeeds(){
        
        Pos.getPositions().stream().forEach((seedsPoint) -> {
        //    gc.setFill(Color.BLACK);    // The Ayo seeds are drawn here...
        //    gc.fillOval(seedsPoint.x, seedsPoint.y, Pos.seedsDiameter, Pos.seedsDiameter);
            gc.drawImage(GameAssets.AYO_SEED_IMAGE, seedsPoint.x, seedsPoint.y);
        });
        
            // If the seeds in the bin is more than 5, then draw an indicator to inform the players
                // how much seeds are in the bin...
        if(Pos.totalSeeds > 5){
            
            double x = (CanvasWidth - 40) * 0.5;
            double y = (CanvasHeight - 40) * 0.5;
            gc.setFill(new Color(0.5,0.5,0.5,0.6));
            gc.fillRoundRect(x, y, 40, 40, 7, 7);
            gc.setFill(Color.WHITE);
            gc.setLineWidth(4);
            gc.setTextBaseline(VPos.BOTTOM);
            
            Font total = new Font("Arial", 30);
            gc.setFont(total);
            String text = ""+Pos.totalSeeds+"";
            if(Pos.totalSeeds > 9){
                gc.fillText(text, (x+2), (y+35));
            }
            else{
                gc.fillText(text, (x+15), (y+35));
            }
        }
    }
    
    /**
     * This method draws the seeds passed to it on the canvas...
     * @param seeds
     */
    public void DrawSeeds(int seeds){
        
        // draw the seeds into the currently selected bin...
        currentAyoSeedsInHole = seeds;
        Pos.totalSeeds = currentAyoSeedsInHole;
        this.drawSeeds();
    }
    
    /**
     * This Redraws the seeds previously set to this object at their current locations
     * And any new seeds detected will be drawn at their new location...
     */
    public void ReDrawSeeds(){
        
            // Repaint the Bin... then draw the seeds here...
        Pos.totalSeeds = currentAyoSeedsInHole;
        this.drawSeeds();
    }
    
    /**
     * Clears the canvas. I.E reDraws an empty bin...
     */
    public void ClearSeeds(){
        
        // empty the arrays and draw a clear rectangle on the convas to erase everything previously drawn...
        currentAyoSeedsInHole = 0;
        Pos.ClearSeedPositions();
        gc.setFill(Color.TRANSPARENT);
        gc.fillRect(0,0,CanvasWidth,CanvasHeight);
        gc.clearRect(0,0,CanvasWidth,CanvasHeight);
    }
    
    /**
     * This method adds a new Ayo seed to the list and
     * Must call ReDraw() after calling this method to draw the updated list of ayo seeds...
     */
    public void AddNewSeed(){
        
        currentAyoSeedsInHole ++;
    }
    
    
}
