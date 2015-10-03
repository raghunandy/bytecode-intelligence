package bcintell.bc.intell.core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import bcintell.bc.intell.core.BCELUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Raghu
 */
public class BCELUtilTest {
    
    public BCELUtilTest() {
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
     * Test of checkExample method, of class BCELUtil.
     */
    @Test
    public void testCheckExample() throws Exception {
        System.out.println("Inspect Methods");
        String absPathOfClass = "D:\\TTU\\bytecode-intelligence\\bc-intell-package-analyzer\\inputs\\EmailSenderFacade.class";
        BCELUtil.inspectMethods(absPathOfClass);
        
    }

    
}
