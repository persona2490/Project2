/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package project2.GUI;

import javax.swing.JTable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kevin
 */
public class OperateTest {
    
    public OperateTest() {
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
     * Test of run method, of class OperateGUI.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        ManageGUI instance = new ManageGUI();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of table method, of class OperateGUI.
     */
    @Test
    public void testTable() {
        System.out.println("table");
        ManageGUI instance = new ManageGUI();
        instance.table();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getTable method, of class Operate.
     */


    /**
     * Test of setAllTag method, of class OperateGUI.
     */
    @Test
    public void testSetAllTag() {
        System.out.println("setAllTag");
        ManageGUI instance = new ManageGUI();
        instance.setAllTag();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
