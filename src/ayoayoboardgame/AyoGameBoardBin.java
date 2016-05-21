/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This is used to set the graphics object of the bins in the AyogameBoard grid
 * @author Odigie Oseme Utibe | osemeodigie@yahoo.com | http://osemeodigie.com
 */
public class AyoGameBoardBin extends Canvas {
    
    private final GraphicsContext gc;
    public AyoGameBoardSeed AyoSeedsInBin;

    /**
     * Constructor
     * @param width
     * @param height
     */
    public AyoGameBoardBin(double width, double height) {
        super(width,height);
        widthProperty().addListener(evt -> redraw());
        heightProperty().addListener(evt -> redraw());
        gc = getGraphicsContext2D();
        AyoSeedsInBin = new AyoGameBoardSeed(gc);
        
        initBin();
    }
    
    private void initBin(){
        
        redraw();
    }
    
    private void redraw() {
        
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.setFill(Color.TRANSPARENT);
        
    //    gc.setFill(Color.BLUE);
     //   gc.fillRect(0,0,getWidth(),getHeight());
        AyoSeedsInBin.ReDrawSeeds();
    }
    
    /**
     * Used to set the amount of Ayo seeds you want in this Bin
     * @param seeds
     */
    public void SetAyoSeeds(int seeds){
        
        AyoSeedsInBin.currentAyoSeedsInHole = seeds;
        redraw(); // redraw the ayo seeds
    }
    
    /**
     * This adds a new seed to this bin..
     */
    public void AddOneAyoSeed(){
        
        AyoSeedsInBin.AddNewSeed();
        redraw(); // redraw the ayo seeds
    }
    
    /**
     * This removes all the Ayo seeds from this Bin
     */
    public void EmptyThisBin(){
        
        AyoSeedsInBin.ClearSeeds();
        redraw();
    }
    
    /**
     * Returns an instance of this graphics object... 
     * might use it to externally draw seeds into this bin...
     * @return GraphicsContext
     */
    public GraphicsContext GetGraphicsContext(){
        
        return this.gc;
    }

    @Override
    public boolean isResizable() {
        return true;
    }
    
}
