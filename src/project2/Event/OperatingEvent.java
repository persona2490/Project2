/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2.Event;

import com.sun.xml.internal.bind.v2.model.core.ID;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import project2.DB.StudentDataBase;
import project2.GUI.Operate;
import project2.GUI.PasswordChangeGui;

/**
 *
 * @author Kevin
 */
public class OperatingEvent implements ActionListener {

    JMenuItem item;
    JButton Button;
    StudentDataBase conn;
    ResultSet rs;
    PreparedStatement ps = null;
    Statement statement;
    PasswordChangeGui passwordChangeGui;

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            item = (JMenuItem) e.getSource();
            if ("itemA".equals(item.getName())) {
                System.out.println("正在查看所有用户···");
                SeeAllUser();
            }
            if ("itemB".equals(item.getName())) {
                passwordChangeGui = new PasswordChangeGui();
            }

        } catch (Exception e1) {
            try {
                Button = (JButton) e.getSource();
                if ("create".equals(Button.getName())) {
                    System.out.println("正在添加单个信息");
                    AddInfo();
                } //DELETE Button
                if ("delete".equals(Button.getName())) {
                    System.out.println("正在删除单个信息");
                    DeleteInfo();
                }
                if ("update".equals(Button.getName())) {
                    System.out.println("正在更新单个信息");
                    UpdateInfo();
                }
                if ("read".equals(Button.getName())) {
                    System.out.println("正在查看单个信息");
                    ReadInfo();
                }
                if ("readAll".equals(Button.getName())) {
                    System.out.println("正在查看全部信息");
                    ReadAll();

                }
            } catch (Exception e2) {
            }
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

                System.out.print("Account" + "\t" + account);
                System.out.print("Password" + "\t" + password + "\n");
                String info = Operate.resultArea.getText() + account + "\t" + password + "\n";
                Operate.resultArea.setText(info);
            }
            rs.close();
            conn.closeConnections();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private void AddInfo() {
        Operate.model.setNumRows(0);
//    private void AddInfo(String name, String gender, int age, String major, String ID) {
        String name = Operate.NameText.getText();
        boolean male = Operate.male.isSelected();
        boolean female = Operate.female.isSelected();

        String gender;
        String age = Operate.AgeText.getText();
        String major = Operate.MajorText.getText();
        String ID = Operate.IDText.getText();
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name Cant Be Emepty", "Name Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (male == false && female == false) {
            JOptionPane.showMessageDialog(null, "Please Select a Gender", "Gender Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (male == true && female == true) {
            JOptionPane.showMessageDialog(null, "Please Select Only 1 Gender", "Gender Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (age.equals("")) {
            JOptionPane.showMessageDialog(null, "Age Cant Be Emepty", "Age Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (major.equals("")) {
            JOptionPane.showMessageDialog(null, "Major Cant Be Emepty", "Major Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (ID.equals("")) {
            JOptionPane.showMessageDialog(null, "ID Cant Be Emepty", "ID Warnning", JOptionPane.WARNING_MESSAGE);
        } else {
            if (male == true) {
                gender = Operate.male.getText();
            } else {
                gender = Operate.female.getText();
            }
            try {
                //1.获取conection
                conn = new StudentDataBase();
                statement = conn.getConnection().createStatement();
                //2.定义SQL
                String sql = "INSERT INTO STUDENT VALUES ('" + name + "', '" + gender + "','" + age + "','" + major + "','" + ID + "')";
                statement.execute(sql);
                System.out.println("ADD Successfully");
                JOptionPane.showMessageDialog(null, "ADD Successfully", "ADDimformation", JOptionPane.WARNING_MESSAGE);
                conn.closeConnections();

                String column[] = new String[5];
                column[0] = name;
                column[1] = gender;
                column[2] = age;
                column[3] = major;
                column[4] = ID;
                Operate.model.addRow(column);

            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, "ID has existed", "ADD imformation", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void DeleteInfo() {
        String ID = Operate.ReadsectionText.getText();
        if (ID.equals("")) {
            JOptionPane.showMessageDialog(null, "SearchBar Cant Be Emepty", "ID Warnning", JOptionPane.WARNING_MESSAGE);
            System.out.println("ID cant be emepty! ");
        } else {
            try {
                conn = new StudentDataBase();
                statement = conn.getConnection().createStatement();
                String sql = "DELETE FROM STUDENT WHERE ID= '" + ID + "'";
                if (statement.executeUpdate(sql) == 1) {
                    JOptionPane.showMessageDialog(null, "DELETE " + ID + " Successfully", "ID imformation", JOptionPane.WARNING_MESSAGE);
                    System.out.println("DELETE " + ID + " Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Student ID: " + ID + " Doesn't Found", "ID imformation", JOptionPane.WARNING_MESSAGE);
                }
                statement.close();
                conn.closeConnections();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Student ID: " + ID + " Doesn't Found", "ID imformation", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void UpdateInfo() {
        String SearchID = Operate.ReadsectionText.getText();
        String name = Operate.NameText.getText();
        boolean male = Operate.male.isSelected();
        boolean female = Operate.female.isSelected();

        String gender;
        String age = Operate.AgeText.getText();
        String major = Operate.MajorText.getText();
        String ID = Operate.IDText.getText();

        if (SearchID.equals("")) {
            JOptionPane.showMessageDialog(null, "SearchBar Cant Be Emepty", "Name Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name Cant Be Emepty", "Name Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (male == false && female == false) {
            JOptionPane.showMessageDialog(null, "Please Select a Gender", "Gender Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (age.equals("")) {
            JOptionPane.showMessageDialog(null, "Age Cant Be Emepty", "Age Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (major.equals("")) {
            JOptionPane.showMessageDialog(null, "Major Cant Be Emepty", "Major Warnning", JOptionPane.WARNING_MESSAGE);
        } else if (ID.equals("")) {
            JOptionPane.showMessageDialog(null, "ID Cant Be Emepty", "ID Warnning", JOptionPane.WARNING_MESSAGE);
        } else {
            if (male == true) {
                gender = Operate.male.getText();
            } else {
                gender = Operate.female.getText();
            }
            try {
                //1.获取conection
                conn = new StudentDataBase();
                statement = conn.getConnection().createStatement();
                //2.定义SQL
                String sql = "UPDATE STUDENT SET NAME ='" + name + "',GENDER = '" + gender + "',AGE = '" + age + "',MAJOR = '" + major + "',ID = '" + ID + "'WHERE ID = '" + SearchID + "'";
                if (statement.executeUpdate(sql) == 1) {
                    JOptionPane.showMessageDialog(null, "UPDATE " + ID + " Successfully", "ID imformation", JOptionPane.WARNING_MESSAGE);
                    System.out.println("UPDATE " + ID + " Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "ID: " + SearchID + " Doesn't Found", "ID imformation", JOptionPane.WARNING_MESSAGE);
                }
                statement.close();
                conn.closeConnections();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            String column[] = new String[5];
            column[0] = name;
            column[1] = gender;
            column[2] = age;
            column[3] = major;
            column[4] = ID;
            Operate.model.addRow(column);

        }

    }
// This methos is used to Search info according to ID

    private void ReadInfo() {
        Operate.model.setNumRows(0);
        String SearchID = Operate.ReadsectionText.getText();
        if (SearchID.equals("")) {
            JOptionPane.showMessageDialog(null, "SearchBar Cant Be Emepty", "ID Warnning", JOptionPane.WARNING_MESSAGE);
            System.out.println("ID cant be emepty! ");
        } else {
            try {

                conn = new StudentDataBase();
//            ps = conn.getConnection().prepareStatement(sql);
                String sql = "select* from STUDENT WHERE ID= '" + SearchID + "'";
                rs = conn.queryDB(sql);
//                statement = conn.getConnection().createStatement();
//                if (statement.executeUpdate(sql) == 1) {
//                    System.out.println("DELETE " + SearchID + " Successfully");
                    rs.next();
                    String name = rs.getString(1);
                    String gender = rs.getString(2);
                    String age = rs.getString(3);
                    String major = rs.getString(4);
                    String ID = rs.getString(5);

                    String column[] = new String[5];
                    column[0] = name;
                    column[1] = gender;
                    column[2] = age;
                    column[3] = major;
                    column[4] = ID;
                    Operate.model.addRow(column);

                    System.out.print("Account" + "\t" + name + "\t");
                    System.out.print("Password" + "\t" + gender + "\t");
                    System.out.print("Age " + "\t" + age + "\t");
                    System.out.print("Major" + "\t" + major + "\t");
                    System.out.print("ID" + "\t" + ID + "\n");

//                } else {
//                    JOptionPane.showMessageDialog(null, "Student ID: " + SearchID + " Doesn't Found", "ID imformation", JOptionPane.WARNING_MESSAGE);
//                }
                statement.close();
                conn.closeConnections();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Student ID: " + SearchID + " Doesn't Found", "ID imformation", JOptionPane.WARNING_MESSAGE);
            }
        }

    }

    private void ReadAll() {
        Operate.model.setNumRows(0);
        String sql = "SELECT * FROM STUDENT";
        try {
            conn = new StudentDataBase();
//            ps = conn.getConnection().prepareStatement(sql);
            rs = conn.queryDB(sql);
            while (rs.next()) {
                String name = rs.getString(1);
                String gender = rs.getString(2);
                String age = rs.getString(3);
                String major = rs.getString(4);
                String ID = rs.getString(5);

                System.out.print("Account" + "\t" + name + "\t");
                System.out.print("Password" + "\t" + gender + "\t");
                System.out.print("Age " + "\t" + age + "\t");
                System.out.print("Major" + "\t" + major + "\t");
                System.out.print("ID" + "\t" + ID + "\n");

                String column[] = new String[5];
                column[0] = name;
                column[1] = gender;
                column[2] = age;
                column[3] = major;
                column[4] = ID;
                Operate.model.addRow(column);
            }
            rs.close();
            conn.closeConnections();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
