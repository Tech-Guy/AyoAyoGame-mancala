/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

import javafx.scene.canvas.GraphicsContext;
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
public class AyoGameBoardBinTest {
    
    public AyoGameBoardBinTest() {
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
     * Test of SetAyoSeeds method, of class AyoGameBoardBin.
     */
    @Test
    public void testSetAyoSeeds() {
        System.out.println("SetAyoSeeds");
        int seeds = 0;
        AyoGameBoardBin instance = null;
        instance.SetAyoSeeds(seeds);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AddOneAyoSeed method, of class AyoGameBoardBin.
     */
    @Test
    public void testAddOneAyoSeed() {
        System.out.println("AddOneAyoSeed");
        AyoGameBoardBin instance = null;
        instance.AddOneAyoSeed();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of EmptyThisBin method, of class AyoGameBoardBin.
     */
    @Test
    public void testEmptyThisBin() {
        System.out.println("EmptyThisBin");
        AyoGameBoardBin instance = null;
        instance.EmptyThisBin();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetGraphicsContext method, of class AyoGameBoardBin.
     */
    @Test
    public void testGetGraphicsContext() {
        System.out.println("GetGraphicsContext");
        AyoGameBoardBin instance = null;
        GraphicsContext expResult = null;
        GraphicsContext result = instance.GetGraphicsContext();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isResizable method, of class AyoGameBoardBin.
     */
    @Test
    public void testIsResizable() {
        System.out.println("isResizable");
        AyoGameBoardBin instance = null;
        boolean expResult = false;
        boolean result = instance.isResizable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
