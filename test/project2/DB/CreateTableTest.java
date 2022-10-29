/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package project2.DB;

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
public class CreateTableTest {
    
    public CreateTableTest() {
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
     * Test of main method, of class CreateTable.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CreateTable.main(args);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of createUserTable method, of class CreateTable.
     */
    @Test
    public void testCreateUserTable() {
        System.out.println("createUserTable");
        CreateTable instance = new CreateTable();
        instance.createUserTable();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of createStudentTable method, of class CreateTable.
     */
    @Test
    public void testCreateStudentTable() {
        System.out.println("createStudentTable");
        CreateTable instance = new CreateTable();
        instance.createStudentTable();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of checkExistedTable method, of class CreateTable.
     */
    @Test
    public void testCheckExistedTable() {
        System.out.println("checkExistedTable");
        String name = "";
        CreateTable instance = new CreateTable();
        instance.checkExistedTable(name);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of closeConnection method, of class CreateTable.
     */
    @Test
    public void testCloseConnection() {
        System.out.println("closeConnection");
        CreateTable instance = new CreateTable();
        instance.closeConnection();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
