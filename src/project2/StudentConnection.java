/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Kevin
 */
public class StudentConnection {

    private static final String USER_NAME = "pdc"; //your DB username
    private static final String PASSWORD = "123"; //your DB password
    private static final String URL = "jdbc:derby://localhost:1527/Student_info_DB; create=true";  //url of the DB host

    Connection conn;

//    public StudentConnection() {
//        establishConnection();
//    }

//    public static void main(String[] args) {
//        StudentConnection dbManager = new StudentConnection();
//        System.out.println(dbManager.getConnection());
//    }

    public Connection getConnection() {
        return this.conn;
    }

    public void establishConnection() {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + " Get Connected Successfully ....");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
