/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2.DB;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Kevin
 */
abstract class AbstractDB {

    protected final DataBase studentDB;
    protected final Connection conn;
    protected Statement state;

    public AbstractDB() {
        studentDB = new DataBase();
        conn = studentDB.getConnection();
    }
     abstract void createUserTable();
     abstract void createStudentTable();
     abstract void checkExistedTable(String name);
     abstract void closeConnection();

}
