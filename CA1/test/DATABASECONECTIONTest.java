/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import jdbcexample.DATABASECONECTION;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author farleyreis
 */
public class DATABASECONECTIONTest {
    
    public DATABASECONECTIONTest() {
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
     * Test of vertify method, of class DATABASECONECTION.
     */
    @Test
    public void testVertify() {
        System.out.println("vertify");
        String uname = "";
        String pwd = "";
        DATABASECONECTION instance = new DATABASECONECTION();
        Boolean expResult = null;
        Boolean result = instance.vertify(uname, pwd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
