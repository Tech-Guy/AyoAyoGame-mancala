/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

import javafx.scene.control.TextField;
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
public class MenuScreenTest {
    
    public MenuScreenTest() {
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
     * Test of getMainMenuScreen method, of class MenuScreen.
     */
    @Test
    public void testGetMainMenuScreen() {
        System.out.println("getMainMenuScreen");
        MenuScreen instance = null;
        Pane expResult = null;
        Pane result = instance.getMainMenuScreen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComputerPlayerMenuScreen method, of class MenuScreen.
     */
    @Test
    public void testGetComputerPlayerMenuScreen() {
        System.out.println("getComputerPlayerMenuScreen");
        MenuScreen instance = null;
        Pane expResult = null;
        Pane result = instance.getComputerPlayerMenuScreen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMultiPlayerMenuScreen method, of class MenuScreen.
     */
    @Test
    public void testGetMultiPlayerMenuScreen() {
        System.out.println("getMultiPlayerMenuScreen");
        MenuScreen instance = null;
        Pane expResult = null;
        Pane result = instance.getMultiPlayerMenuScreen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOptionsMenuScreen method, of class MenuScreen.
     */
    @Test
    public void testGetOptionsMenuScreen() {
        System.out.println("getOptionsMenuScreen");
        MenuScreen instance = null;
        Pane expResult = null;
        Pane result = instance.getOptionsMenuScreen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHowToPlayMenuScreen method, of class MenuScreen.
     */
    @Test
    public void testGetHowToPlayMenuScreen() {
        System.out.println("getHowToPlayMenuScreen");
        MenuScreen instance = null;
        Pane expResult = null;
        Pane result = instance.getHowToPlayMenuScreen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTextFieldLimiter method, of class MenuScreen.
     */
    @Test
    public void testAddTextFieldLimiter() {
        System.out.println("addTextFieldLimiter");
        TextField textField = null;
        int maxLength = 0;
        MenuScreen.addTextFieldLimiter(textField, maxLength);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
