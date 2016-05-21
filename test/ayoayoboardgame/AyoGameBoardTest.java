/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

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
public class AyoGameBoardTest {
    
    public AyoGameBoardTest() {
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
     * Test of InitializeThisGameBoard method, of class AyoGameBoard.
     */
    @Test
    public void testInitializeThisGameBoard() {
        System.out.println("InitializeThisGameBoard");
        boolean getGraphics = false;
        AyoGameBoard instance = new AyoGameBoard();
        instance.InitializeThisGameBoard(getGraphics);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PlayTurn method, of class AyoGameBoard.
     */
    @Test
    public void testPlayTurn() {
        System.out.println("PlayTurn");
        int selected_bin_row = 0;
        int selected_bin_col = 0;
        AyoGameBoard instance = new AyoGameBoard();
        float expResult = 0.0F;
        float result = instance.PlayTurn(selected_bin_row, selected_bin_col);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UndoPlayTurn method, of class AyoGameBoard.
     */
    @Test
    public void testUndoPlayTurn() {
        System.out.println("UndoPlayTurn");
        int turns = 0;
        AyoGameBoard instance = new AyoGameBoard();
        instance.UndoPlayTurn(turns);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckBoardForWinners method, of class AyoGameBoard.
     */
    @Test
    public void testCheckBoardForWinners() {
        System.out.println("CheckBoardForWinners");
        boolean isGraphics = false;
        AyoGameBoard instance = new AyoGameBoard();
        int expResult = 0;
        int result = instance.CheckBoardForWinners(isGraphics);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UpdatePlayerScores method, of class AyoGameBoard.
     */
    @Test
    public void testUpdatePlayerScores_0args() {
        System.out.println("UpdatePlayerScores");
        AyoGameBoard instance = new AyoGameBoard();
        instance.UpdatePlayerScores();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UpdatePlayerScores method, of class AyoGameBoard.
     */
    @Test
    public void testUpdatePlayerScores_boolean() {
        System.out.println("UpdatePlayerScores");
        boolean isGraphics = false;
        AyoGameBoard instance = new AyoGameBoard();
        instance.UpdatePlayerScores(isGraphics);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetGameBoard method, of class AyoGameBoard.
     */
    @Test
    public void testGetGameBoard() {
        System.out.println("GetGameBoard");
        AyoGameBoard instance = new AyoGameBoard();
        int[][] expResult = null;
        int[][] result = instance.GetGameBoard();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetGameBoard method, of class AyoGameBoard.
     */
    @Test
    public void testSetGameBoard() {
        System.out.println("SetGameBoard");
        int[][] newGameBoard = null;
        AyoGameBoard instance = new AyoGameBoard();
        instance.SetGameBoard(newGameBoard);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of IsBinEmpty method, of class AyoGameBoard.
     */
    @Test
    public void testIsBinEmpty() {
        System.out.println("IsBinEmpty");
        int player = 0;
        int selectedHole = 0;
        AyoGameBoard instance = new AyoGameBoard();
        boolean expResult = false;
        boolean result = instance.IsBinEmpty(player, selectedHole);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AnimatePlayTurn method, of class AyoGameBoard.
     */
    @Test
    public void testAnimatePlayTurn() {
        System.out.println("AnimatePlayTurn");
        int selected_bin_row = 0;
        int selected_bin_col = 0;
        AyoGameBoard instance = new AyoGameBoard();
        instance.AnimatePlayTurn(selected_bin_row, selected_bin_col);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetDrawnGameBoard method, of class AyoGameBoard.
     */
    @Test
    public void testGetDrawnGameBoard() {
        System.out.println("GetDrawnGameBoard");
        AyoGameBoard instance = new AyoGameBoard();
        Pane expResult = null;
        Pane result = instance.GetDrawnGameBoard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetBoardTheme method, of class AyoGameBoard.
     */
    @Test
    public void testSetBoardTheme() {
        System.out.println("SetBoardTheme");
        AyoGameBoard instance = new AyoGameBoard();
        instance.SetBoardTheme();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
