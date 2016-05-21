/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

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
public class AyoGameBoardGridGraphicsTest {
    
    public AyoGameBoardGridGraphicsTest() {
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
     * Test of getInitialGameGrid method, of class AyoGameBoardGridGraphics.
     */
    @Test
    public void testGetInitialGameGrid() {
        System.out.println("getInitialGameGrid");
        AyoGameBoardGridGraphics instance = null;
        AyoGameBoardGridGraphics expResult = null;
        AyoGameBoardGridGraphics result = instance.getInitialGameGrid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentGameGrid method, of class AyoGameBoardGridGraphics.
     */
    @Test
    public void testGetCurrentGameGrid() {
        System.out.println("getCurrentGameGrid");
        AyoGameBoardGridGraphics instance = null;
        AyoGameBoardGridGraphics expResult = null;
        AyoGameBoardGridGraphics result = instance.getCurrentGameGrid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initGameGrid method, of class AyoGameBoardGridGraphics.
     */
    @Test
    public void testInitGameGrid() {
        System.out.println("initGameGrid");
        AyoGameBoardGridGraphics instance = null;
        instance.initGameGrid();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of EmptyAllBins method, of class AyoGameBoardGridGraphics.
     */
    @Test
    public void testEmptyAllBins() {
        System.out.println("EmptyAllBins");
        AyoGameBoardGridGraphics instance = null;
        instance.EmptyAllBins();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of EnableBins method, of class AyoGameBoardGridGraphics.
     */
    @Test
    public void testEnableBins() {
        System.out.println("EnableBins");
        int player = 0;
        AyoGameBoardGridGraphics instance = null;
        instance.EnableBins(player);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DisableAllBins method, of class AyoGameBoardGridGraphics.
     */
    @Test
    public void testDisableAllBins() {
        System.out.println("DisableAllBins");
        boolean state = false;
        AyoGameBoardGridGraphics instance = null;
        instance.DisableAllBins(state);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
