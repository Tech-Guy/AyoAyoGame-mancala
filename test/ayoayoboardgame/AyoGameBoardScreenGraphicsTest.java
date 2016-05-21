/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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
public class AyoGameBoardScreenGraphicsTest {
    
    public AyoGameBoardScreenGraphicsTest() {
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
     * Test of getMainGameBoardGraphics method, of class AyoGameBoardScreenGraphics.
     */
    @Test
    public void testGetMainGameBoardGraphics() {
        System.out.println("getMainGameBoardGraphics");
        AyoGameBoardScreenGraphics instance = new AyoGameBoardScreenGraphics();
        Pane expResult = null;
        Pane result = instance.getMainGameBoardGraphics();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawStatusBar method, of class AyoGameBoardScreenGraphics.
     */
    @Test
    public void testDrawStatusBar() {
        System.out.println("drawStatusBar");
        AyoGameBoardScreenGraphics instance = new AyoGameBoardScreenGraphics();
        double expResult = 0.0;
        double result = instance.drawStatusBar();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawTopMenuBar method, of class AyoGameBoardScreenGraphics.
     */
    @Test
    public void testDrawTopMenuBar() {
        System.out.println("drawTopMenuBar");
        AyoGameBoardScreenGraphics instance = new AyoGameBoardScreenGraphics();
        double expResult = 0.0;
        double result = instance.drawTopMenuBar();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DrawSeedsOnHandIndicator method, of class AyoGameBoardScreenGraphics.
     */
    @Test
    public void testDrawSeedsOnHandIndicator() {
        System.out.println("DrawSeedsOnHandIndicator");
        AyoGameBoardScreenGraphics instance = new AyoGameBoardScreenGraphics();
        instance.DrawSeedsOnHandIndicator();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayer1Box method, of class AyoGameBoardScreenGraphics.
     */
    @Test
    public void testGetPlayer1Box() {
        System.out.println("getPlayer1Box");
        AyoGameBoardScreenGraphics instance = new AyoGameBoardScreenGraphics();
        GridPane expResult = null;
        GridPane result = instance.getPlayer1Box();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayer2Box method, of class AyoGameBoardScreenGraphics.
     */
    @Test
    public void testGetPlayer2Box() {
        System.out.println("getPlayer2Box");
        AyoGameBoardScreenGraphics instance = new AyoGameBoardScreenGraphics();
        GridPane expResult = null;
        GridPane result = instance.getPlayer2Box();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayersScorePanel method, of class AyoGameBoardScreenGraphics.
     */
    @Test
    public void testGetPlayersScorePanel() {
        System.out.println("getPlayersScorePanel");
        AyoGameBoardScreenGraphics instance = new AyoGameBoardScreenGraphics();
        GridPane expResult = null;
        GridPane result = instance.getPlayersScorePanel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSeedInHandBox method, of class AyoGameBoardScreenGraphics.
     */
    @Test
    public void testGetSeedInHandBox() {
        System.out.println("getSeedInHandBox");
        AyoGameBoardScreenGraphics instance = new AyoGameBoardScreenGraphics();
        GridPane expResult = null;
        GridPane result = instance.getSeedInHandBox();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showBoardWinners method, of class AyoGameBoardScreenGraphics.
     */
    @Test
    public void testShowBoardWinners() {
        System.out.println("showBoardWinners");
        String player = "";
        AyoGameBoardScreenGraphics instance = new AyoGameBoardScreenGraphics();
        instance.showBoardWinners(player);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of killAllRunningThreads method, of class AyoGameBoardScreenGraphics.
     */
    @Test
    public void testKillAllRunningThreads() {
        System.out.println("killAllRunningThreads");
        AyoGameBoardScreenGraphics instance = new AyoGameBoardScreenGraphics();
        instance.killAllRunningThreads();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
