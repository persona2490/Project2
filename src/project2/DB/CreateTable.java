/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2.DB;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Kevin
 */
public class CreateTable {

    private final StudentDataBase studentDB;
    private final Connection conn;
    private Statement state;

    public CreateTable() {
        studentDB = new StudentDataBase();
        conn = studentDB.getConnection();
    }
    public static void main(String[] args) {
        CreateTable = new CreateTable();
    }

    public void createUserTable() {
        try {
            this.state = conn.createStatement();
//            checkExistedTable("Account");
//            this.state.addBatch("CREATE  TABLE BOOK  (BOOKID  INT,   TITLE   VARCHAR(50),   CATEGORY   VARCHAR(20),   PRICE   FLOAT)");
            this.state.addBatch("CREATE  TABLE ACCOUNT  (ACCOUNT   VARCHAR(50),   PASSWORD   VARCHAR(50))");
            this.state.addBatch("INSERT INTO ACCOUNT VALUES('wsy123','wsy123')");
            this.state.executeBatch();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void checkExistedTable(String name) {
        try {
            DatabaseMetaData dbmd = this.conn.getMetaData();
            String[] types = {"TABLE"};
            state = this.conn.createStatement();
            ResultSet rs = dbmd.getTables(null, null, null, types);
            while (rs.next()) {
                String table_name = rs.getString("TABLE_NAME");
                System.out.println(table_name);
                if (table_name.equalsIgnoreCase(name)) {
                    state.executeUpdate("Drop table " + name);
                    System.out.println("Table " + name + " has been deleted.");
                    break;
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void closeConnection() {
        this.studentDB.closeConnections();
    }
}
