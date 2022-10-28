/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JMenuItem;
import project2.DB.StudentDataBase;
import project2.GUI.Operate;
import project2.GUI.PasswordChangeGui;

/**
 *
 * @author Kevin
 */
public class OperatingEvent implements ActionListener {

    JMenuItem item;
    StudentDataBase conn;
    ResultSet rs;
    PreparedStatement ps = null;

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            item = (JMenuItem) e.getSource();
            if ("itemA".equals(item.getName())) {
                SeeAllUser();
            }
            if ("itemB".equals(item.getName())) {
                PasswordChangeGui passwordChangeGui = new PasswordChangeGui();

            }
        } catch (Exception e1) {
        }

    }

    public void SeeAllUser() {
        String sql = "SELECT * FROM ACCOUNT";

        try {
            conn = new StudentDataBase();
//            ps = conn.getConnection().prepareStatement(sql);
            rs = conn.queryDB(sql);
            while (rs.next()) {
                String account = rs.getString(1);
                String password = rs.getString(2);

                System.out.println("account" + "\t" + account);
                System.out.println("account" + "\t" + password);
                String info = Operate.resultArea.getText() + account + "\t" + password + "\n";
                Operate.resultArea.setText(info);
            }
            rs.close();
            conn.closeConnections();

        } catch (SQLException e) {
        }

    }

}
