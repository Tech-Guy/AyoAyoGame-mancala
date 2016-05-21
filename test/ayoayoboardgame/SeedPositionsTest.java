/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

import java.awt.Point;
import java.util.List;
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
public class SeedPositionsTest {
    
    public SeedPositionsTest() {
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
     * Test of getPositions method, of class SeedPositions.
     */
    @Test
    public void testGetPositions_0args() {
        System.out.println("getPositions");
        SeedPositions instance = new SeedPositions();
        List<Point> expResult = null;
        List<Point> result = instance.getPositions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPositions method, of class SeedPositions.
     */
    @Test
    public void testGetPositions_int_boolean() {
        System.out.println("getPositions");
        int seeds = 0;
        boolean random = false;
        SeedPositions instance = new SeedPositions();
        List<Point> expResult = null;
        List<Point> result = instance.getPositions(seeds, random);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get_1_seed_position method, of class SeedPositions.
     */
    @Test
    public void testGet_1_seed_position() {
        System.out.println("get_1_seed_position");
        boolean random = false;
        SeedPositions instance = new SeedPositions();
        List<Point> expResult = null;
        List<Point> result = instance.get_1_seed_position(random);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get_2_seeds_positions method, of class SeedPositions.
     */
    @Test
    public void testGet_2_seeds_positions() {
        System.out.println("get_2_seeds_positions");
        boolean random = false;
        SeedPositions instance = new SeedPositions();
        List<Point> expResult = null;
        List<Point> result = instance.get_2_seeds_positions(random);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get_3_seeds_positions method, of class SeedPositions.
     */
    @Test
    public void testGet_3_seeds_positions() {
        System.out.println("get_3_seeds_positions");
        boolean random = false;
        SeedPositions instance = new SeedPositions();
        List<Point> expResult = null;
        List<Point> result = instance.get_3_seeds_positions(random);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get_4_seeds_positions method, of class SeedPositions.
     */
    @Test
    public void testGet_4_seeds_positions() {
        System.out.println("get_4_seeds_positions");
        boolean random = false;
        SeedPositions instance = new SeedPositions();
        List<Point> expResult = null;
        List<Point> result = instance.get_4_seeds_positions(random);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get_5_seeds_positions method, of class SeedPositions.
     */
    @Test
    public void testGet_5_seeds_positions() {
        System.out.println("get_5_seeds_positions");
        boolean random = false;
        SeedPositions instance = new SeedPositions();
        List<Point> expResult = null;
        List<Point> result = instance.get_5_seeds_positions(random);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get_rand_seed_position method, of class SeedPositions.
     */
    @Test
    public void testGet_rand_seed_position() {
        System.out.println("get_rand_seed_position");
        SeedPositions instance = new SeedPositions();
        Point expResult = null;
        Point result = instance.get_rand_seed_position();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ClearSeedPositions method, of class SeedPositions.
     */
    @Test
    public void testClearSeedPositions() {
        System.out.println("ClearSeedPositions");
        SeedPositions instance = new SeedPositions();
        instance.ClearSeedPositions();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
