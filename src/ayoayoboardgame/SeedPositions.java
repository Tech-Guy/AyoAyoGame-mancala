/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Odigie Oseme Utibe | osemeodigie@yahoo.com | http://osemeodigie.com
 */
public class SeedPositions {

    private List<Point> seedsPoints;
    
    public int totalSeeds;
    public List<Point> currentPoints;
    public double CanvasWidth, CanvasHeight, seedsDiameter;
    
    /**
     * The Seed Position object constructor...
     */
    public SeedPositions() {
        
        seedsPoints = new ArrayList<>();
        currentPoints = new ArrayList<>();
    }
    
    public List<Point> getPositions(){
        
        return this.getPositions(totalSeeds, false);
    }
    
    public List<Point> getPositions(int seeds, boolean random){
        
        List<Point> result = new ArrayList<>();
        if(seeds <= 5){
           
            switch(seeds){

                case 1:
                if(currentPoints.size() == 1){
                   result = currentPoints;
                }
                else{
                    result = get_1_seed_position(random);
                    currentPoints = result;
                }
                break;

                case 2:
                if(currentPoints.size() == 2){
                   result = currentPoints;
                }
                else{
                    result = get_2_seeds_positions(random);
                    currentPoints = result;
                }
                break;

                case 3:
                if(currentPoints.size() == 3){
                   result = currentPoints;
                }
                else{
                    result = get_3_seeds_positions(random);
                    currentPoints = result;
                }
                break;

                case 4:
                if(currentPoints.size() == 4){
                   result = currentPoints;
                }
                else{
                    result = get_4_seeds_positions(random);
                    currentPoints = result;
                }
                break;

                case 5:
                if(currentPoints.size() == 5){
                   result = currentPoints;
                }
                else{
                    result = get_5_seeds_positions(random);
                    currentPoints = result;
                }
                break;
            }
        }
        else{
          
            if(currentPoints.isEmpty()){
                
                result.addAll(get_5_seeds_positions(random));
                result.addAll(getPositions(seeds-5,true));
                currentPoints = result;
            }
            else{
                
                if(seeds == currentPoints.size()){
                    result = currentPoints;  
                }
                else if(seeds < currentPoints.size()){
                    
                    int diff = currentPoints.size() - seeds;
                    for(int cnt = 0; cnt < diff; cnt++){
                        
                        currentPoints.remove((currentPoints.size() - cnt));
                    }
                    result = currentPoints;
                }
                else if(seeds > currentPoints.size()){
                    
                    int diff = seeds - currentPoints.size();
                    for(int cnt = 0; cnt < diff; cnt++){
                        
                        currentPoints.add(get_rand_seed_position());
                    }
                    result = currentPoints;
                }
            }
              
        }
        return result;  
    }
    
    /**
     * Will get the position to draw the seeds.. with some maths random thrown into the mix
     * @param random
     * @return seedsPoints
     */
    protected List<Point> get_1_seed_position(boolean random){
        
        int x,y;
        seedsPoints.clear();    // removes all positions from the list...
        x = (int)((CanvasWidth - seedsDiameter)/2);
        y = (int)((CanvasHeight - seedsDiameter)/2);
        
        if(random){
            x += (Math.random()* CanvasWidth * 0.1);
            y += (Math.random()* CanvasHeight * 0.1);
        }
        
        seedsPoints.add(new Point(x,y));
        
        return seedsPoints; 
    }
    
    /**
     * Will get the position to draw the seeds.. with some maths random thrown into the mix
     * @param random
     * @return seedsPoints
     */
    protected List<Point> get_2_seeds_positions(boolean random){
        
        int x,y;
        seedsPoints.clear();    // removes all positions from the list...
        x = (int)((CanvasWidth - ((seedsDiameter*2)+15))/2);
        y = (int)((CanvasHeight - seedsDiameter)/2);
        seedsPoints.add(new Point(x,y));
        x += seedsDiameter+15;
        seedsPoints.add(new Point(x,y)); 
        
        if(random){
            seedsPoints.stream().map((seedsPoint) -> {
                seedsPoint.x += Math.random()* CanvasWidth * 0.1;
                return seedsPoint;
            }).forEach((seedsPoint) -> {
                seedsPoint.y += Math.random()* CanvasHeight * 0.1;
            });
        }
        
        return seedsPoints; 
    }
    
    /**
     * Will get the position to draw the seeds.. with some maths random thrown into the mix
     * @param random
     * @return seedsPoints
     */
    protected List<Point> get_3_seeds_positions(boolean random){
        
        int x,y;
        seedsPoints.clear();    // removes all positions from the list...
        x = (int)((CanvasWidth - ((seedsDiameter*2)+15))/2);
        y = (int)((CanvasHeight - ((seedsDiameter*2)+15))/2);
        seedsPoints.add(new Point(x,y));
        x += seedsDiameter+15;
        seedsPoints.add(new Point(x,y)); 
        x = (int)((CanvasWidth - seedsDiameter)/2);
        y += seedsDiameter+15;
        seedsPoints.add(new Point(x,y)); 
        
        if(random){
            seedsPoints.stream().map((seedsPoint) -> {
                seedsPoint.x += Math.random()* CanvasWidth * 0.1;
                return seedsPoint;
            }).forEach((seedsPoint) -> {
                seedsPoint.y += Math.random()* CanvasHeight * 0.1;
            });
        }
        return seedsPoints; 
    }
    
    /**
     * Will get the position to draw the seeds.. with some maths random thrown into the mix
     * @param random
     * @return seedsPoints
     */
    protected List<Point> get_4_seeds_positions(boolean random){
        
        int x,y;
        seedsPoints.clear();    // removes all positions from the list...
        x = (int)((CanvasWidth - ((seedsDiameter*2)+15))/2);
        y = (int)((CanvasHeight - ((seedsDiameter*2)+15))/2);
        seedsPoints.add(new Point(x,y));
        x += seedsDiameter+15;
        seedsPoints.add(new Point(x,y)); 
        y += seedsDiameter+15;
        seedsPoints.add(new Point(x,y));
        x -= seedsDiameter+15;
        seedsPoints.add(new Point(x,y)); 
        
        if(random){
            seedsPoints.stream().map((seedsPoint) -> {
                seedsPoint.x += Math.random()* CanvasWidth * 0.1;
                return seedsPoint;
            }).forEach((seedsPoint) -> {
                seedsPoint.y += Math.random()* CanvasHeight * 0.1;
            });
        }
        return seedsPoints; 
    }
    
    /**
     * Will get the position to draw the seeds.. with some maths random thrown into the mix
     * @param random
     * @return seedsPoints
     */
    protected List<Point> get_5_seeds_positions(boolean random){
        
        int x,y;
        seedsPoints.clear();    // removes all positions from the list...
        x = (int)((CanvasWidth - seedsDiameter)/2);
        y = (int)((CanvasHeight - seedsDiameter)/2);
        seedsPoints.add(new Point(x,y));

        x = (int)((CanvasWidth - ((seedsDiameter*2.2)+20))/2);
        y = (int)((CanvasHeight - ((seedsDiameter*2.2)+20))/2);

        seedsPoints.add(new Point(x,y));
        x += (seedsDiameter*1.2)+20;
        seedsPoints.add(new Point(x,y)); 
        y += (seedsDiameter*1.2)+20;
        seedsPoints.add(new Point(x,y));
        x -= (seedsDiameter*1.2)+20;
        seedsPoints.add(new Point(x,y)); 
        
        if(random){
            seedsPoints.stream().map((seedsPoint) -> {
                seedsPoint.x += Math.random()* CanvasWidth * 0.1;
                return seedsPoint;
            }).forEach((seedsPoint) -> {
                seedsPoint.y += Math.random()* CanvasHeight * 0.1;
            });
        }
        return seedsPoints; 
    }
    
        /**
     * Will get the position to draw the seeds.. with some maths random thrown into the mix
     * @return seedsPoints
     */
    protected Point get_rand_seed_position(){
        
        int x,y;
            // Randomise the x and y position within a set square radius...
        x = (int)(Math.random()* CanvasWidth*.9);
        y = (int)(Math.random()* CanvasHeight*.9);
        
        if((x + seedsDiameter) > CanvasWidth){
            x -= seedsDiameter;
        }
        
        if((y + seedsDiameter) > CanvasHeight){
            y -= seedsDiameter;
        }
        return new Point(x,y); 
    }
    
    /**
     * Removes all the seeds positions from the ArrayList...
     */
    public void ClearSeedPositions(){
        
        seedsPoints.clear();
        seedsPoints = new ArrayList<>();
    }
    
}
