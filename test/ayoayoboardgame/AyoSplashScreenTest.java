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
 * @author Fowode Oluseye Adegoke
 */
public class AyoSplashScreenTest {
    
    public AyoSplashScreenTest() {
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
     * Test of InitSplashScreen method, of class AyoSplashScreen.
     */
    @Test
    public void testInitSplashScreen() {
        System.out.println("InitSplashScreen");
        AyoSplashScreen instance = null;
        instance.InitSplashScreen();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showSplashScreen method, of class AyoSplashScreen.
     */
    @Test
    public void testShowSplashScreen() {
        System.out.println("showSplashScreen");
        AyoSplashScreen instance = null;
        instance.showSplashScreen();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetMainStage method, of class AyoSplashScreen.
     */
    @Test
    public void testGetMainStage() {
        System.out.println("GetMainStage");
        AyoSplashScreen instance = null;
        Stage expResult = null;
        Stage result = instance.GetMainStage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
