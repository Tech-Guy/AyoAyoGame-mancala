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
public class AIPlayerTest {
    
    public AIPlayerTest() {
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
     * Test of setPlayerType method, of class AIPlayer.
     */
    @Test
    public void testSetPlayerType() {
        System.out.println("setPlayerType");
        String playerType = "";
        AIPlayer instance = null;
        instance.setPlayerType(playerType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAIDepth method, of class AIPlayer.
     */
    @Test
    public void testGetAIDepth() {
        System.out.println("getAIDepth");
        AIPlayer instance = null;
        int expResult = 0;
        int result = instance.getAIDepth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of animateComputerTurn method, of class AIPlayer.
     */
    @Test
    public void testAnimateComputerTurn() {
        System.out.println("animateComputerTurn");
        AyoGameBoard bd = null;
        AIPlayer instance = null;
        instance.animateComputerTurn(bd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bestMove method, of class AIPlayer.
     */
    @Test
    public void testBestMove() {
        System.out.println("bestMove");
        AIPlayer instance = null;
        int expResult = 0;
        int result = instance.bestMove();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MiniMaxFunction method, of class AIPlayer.
     */
    @Test
    public void testMiniMaxFunction() {
        System.out.println("MiniMaxFunction");
        int selectedBin = 0;
        AyoGameBoard GameBoard = null;
        Player player1 = null;
        Player player2 = null;
        AIPlayer instance = null;
        float expResult = 0.0F;
        float result = instance.MiniMaxFunction(selectedBin, GameBoard, player1, player2);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MaxScoreObtainableFromPlay method, of class AIPlayer.
     */
    @Test
    public void testMaxScoreObtainableFromPlay() {
        System.out.println("MaxScoreObtainableFromPlay");
        AyoGameBoard GameBoard = null;
        AIPlayer instance = null;
        int expResult = 0;
        int result = instance.MaxScoreObtainableFromPlay(GameBoard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerType method, of class AIPlayer.
     */
    @Test
    public void testGetPlayerType() {
        System.out.println("getPlayerType");
        AIPlayer instance = null;
        String expResult = "";
        String result = instance.getPlayerType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetThinkingText method, of class AIPlayer.
     */
    @Test
    public void testSetThinkingText() {
        System.out.println("SetThinkingText");
        String newText = "";
        AIPlayer instance = null;
        instance.SetThinkingText(newText);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
