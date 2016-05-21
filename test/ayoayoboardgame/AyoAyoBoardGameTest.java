/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robotics
 */
public class AyoAyoBoardGameTest {
    
    public AyoAyoBoardGameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of start method, of class AyoAyoBoardGame.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Stage primaryStage = null;
        AyoAyoBoardGame instance = new AyoAyoBoardGame();
        instance.start(primaryStage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onSplashScreenCompleted method, of class AyoAyoBoardGame.
     */
    @Test
    public void testOnSplashScreenCompleted() {
        System.out.println("onSplashScreenCompleted");
        double SCREEN_WIDTH = 0.0;
        double SCREEN_HEIGHT = 0.0;
        AyoAyoBoardGame instance = new AyoAyoBoardGame();
        instance.onSplashScreenCompleted(SCREEN_WIDTH, SCREEN_HEIGHT);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class AyoAyoBoardGame.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        AyoAyoBoardGame.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
