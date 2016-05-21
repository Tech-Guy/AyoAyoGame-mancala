/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

import javafx.scene.Scene;
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
public class AyoGameManagerTest {
    
    public AyoGameManagerTest() {
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
     * Test of menuScreen method, of class AyoGameManager.
     */
    @Test
    public void testMenuScreen() {
        System.out.println("menuScreen");
        AyoGameManager instance = null;
        instance.menuScreen();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computerPlayerMenuScreen method, of class AyoGameManager.
     */
    @Test
    public void testComputerPlayerMenuScreen() {
        System.out.println("computerPlayerMenuScreen");
        AyoGameManager instance = null;
        instance.computerPlayerMenuScreen();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiPlayerMenuScreen method, of class AyoGameManager.
     */
    @Test
    public void testMultiPlayerMenuScreen() {
        System.out.println("multiPlayerMenuScreen");
        AyoGameManager instance = null;
        instance.multiPlayerMenuScreen();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of optionsMenuScreen method, of class AyoGameManager.
     */
    @Test
    public void testOptionsMenuScreen() {
        System.out.println("optionsMenuScreen");
        AyoGameManager instance = null;
        instance.optionsMenuScreen();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of howToPlayMenuScreen method, of class AyoGameManager.
     */
    @Test
    public void testHowToPlayMenuScreen() {
        System.out.println("howToPlayMenuScreen");
        AyoGameManager instance = null;
        instance.howToPlayMenuScreen();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newGame method, of class AyoGameManager.
     */
    @Test
    public void testNewGame() {
        System.out.println("newGame");
        AyoGameManager instance = null;
        instance.newGame();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGameBoard method, of class AyoGameManager.
     */
    @Test
    public void testGetGameBoard() {
        System.out.println("getGameBoard");
        AyoGameManager instance = null;
        AyoGameBoard expResult = null;
        AyoGameBoard result = instance.getGameBoard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGameScene method, of class AyoGameManager.
     */
    @Test
    public void testGetGameScene() {
        System.out.println("getGameScene");
        AyoGameManager instance = null;
        Scene expResult = null;
        Scene result = instance.getGameScene();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
