/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcintell.extractjar;

import java.io.File;
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
public class ExtractJarTest {
    
    public ExtractJarTest() {
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
     * Test of extractJar method, of class ExtractJar.
     */
    @Test
    public void testExtractJar() throws Exception {
        System.out.println("extractJar");
        String jarFile = "../project-inception/target/project-inception-0.1.jar";
        System.out.println("Current Path:"+new File(".").getAbsolutePath());
        System.out.println("Input Jar Abs Path:"+new File(jarFile).getAbsolutePath());
        System.out.println("Extracted To: "+ExtractJar.extractJar(jarFile));
        
        
    }
    
}
