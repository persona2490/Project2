/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2.Event;

import project2.Interface.UpdateMethod;
import project2.Interface.DeleteMethod;
import project2.Interface.AddMethod;
import project2.Interface.ReadMethod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import project2.DB.DataBase;
import project2.GUI.ManageGUI;
import project2.GUI.PasswordChangeGui;

/**
 *This class is responsible for adding, deleting, Read and Updaemethods(CRUD)
 * Manage student information and make it visible to users
 * @author Kevin
 */
public class Modify_Info_Event implements ActionListener, ReadMethod, AddMethod, DeleteMethod, UpdateMethod {

    JMenuItem item;
    JButton Button;
    DataBase conn;
    ResultSet rs;
    PreparedStatement ps = null;
    Statement statement;
    PasswordChangeGui passwordChangeGui;

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            item = (JMenuItem) e.getSource();
            if ("SeeAllUser".equals(item.getName())) {
                System.out.println("Viewing all users···");
                SeeAllUser();
            }

        } catch (Exception e1) {
            try {
                Button = (JButton) e.getSource();
                if ("create".equals(Button.getName())) {
                    System.out.println("Adding a student information ···");
                    AddInfo();//call add method
                }
                if ("delete".equals(Button.getName())) {
                    System.out.println("Deleting a student information ···");
                    DeleteInfo();//call delete method
                }
                if ("update".equals(Button.getName())) {
                    System.out.println("Updating a student information ···");
                    UpdateInfo();//call update method
                }
                if ("read".equals(Button.getName())) {
                    System.out.println("Searching a student information ···");
                    ReadInfo();//call search method
                }
                if ("readAll".equals(Button.getName())) {
                    System.out.println("Reading all information ··· ");
                    ReadAll();//call ReadAll method

                }
                if ("reset".equals(Button.getName())) {
                    System.out.println("All reset");
                    Reset();
                }
            } catch (Exception e2) {
            }
        }
    }

    @Override
    public void SeeAllUser() {
        String sql = "SELECT * FROM ACCOUNT";

        try {
            ManageGUI.resultArea.setText("");
            conn = new DataBase();
            rs = conn.queryDB(sql);
            while (rs.next()) {
                String account = rs.getString(1);
                String password = rs.getString(2);

                System.out.print("Account" + "\t" + account + "\t");
                System.out.print("Password" + "\t" + password + "\n");
                String info = ManageGUI.resultArea.getText() + "Username: " + account + "\t" + "Password: " + password + "\n";
                ManageGUI.resultArea.setText(info);
            }
            rs.close();
            conn.closeConnections();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void AddInfo() {
        ManageGUI.model.setNumRows(0);
//    private void AddMethod(String name, String gender, int age, String major, String ID) {
        String name = ManageGUI.NameText.getText();
        boolean male = ManageGUI.male.isSelected();
        boolean female = ManageGUI.female.isSelected();

        String gender;
        String age = ManageGUI.AgeText.getText();
        String major = ManageGUI.MajorText.getText();
        String ID = ManageGUI.IDText.getText();
        //Text File cant be empty
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
                gender = ManageGUI.male.getText();
            } else {
                gender = ManageGUI.female.getText();
            }
            try {
                Integer.parseInt(age);

                try {
                    //1.Get onection
                    conn = new DataBase();
                    statement = conn.getConnection().createStatement();
                    //2.Define SQL
                    String sql = "INSERT INTO STUDENT VALUES ('" + name + "', '" + gender + "','" + age + "','" + major + "','" + ID + "')";
                    statement.execute(sql);
                    System.out.println("ID:" + ID + "Student ADD Successfully");
                    JOptionPane.showMessageDialog(null, ID + " ADD Successfully", "ADDimformation", JOptionPane.WARNING_MESSAGE);
                    conn.closeConnections();

                    String column[] = new String[5];
                    column[0] = name;
                    column[1] = gender;
                    column[2] = age;
                    column[3] = major;
                    column[4] = ID;
                    ManageGUI.model.addRow(column);

                } catch (SQLException e) {

                    JOptionPane.showMessageDialog(null, "ID " + ID + " has existed", "ADD imformation", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null, "AGE Shoule Be A INTEGER", "AGE Warnning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    @Override
    public void ReadAll() {
        ManageGUI.model.setNumRows(0);
        String sql = "SELECT * FROM STUDENT";
        try {
            conn = new DataBase();
//            ps = conn.getConnection().prepareStatement(sql);
            rs = conn.queryDB(sql);
            System.out.print("Name" + "\t" + "\t" + "Gender" + "\t" + "\t" + "Age " + "\t" + "\t" + "Major" + "\t" + "\t" + "ID" + "\n");
            while (rs.next()) {
                String name = rs.getString(1);
                String gender = rs.getString(2);
                String age = rs.getString(3);
                String major = rs.getString(4);
                String ID = rs.getString(5);
                System.out.print(name + "\t" + "\t" + gender + "\t" + "\t" + age + "\t" + "\t" + major + "\t" + "\t" + ID + "\n");
//                System.out.print("Account" + "\t" + name + "\t");
//                System.out.print("Password" + "\t" + gender + "\t");
//                System.out.print("Age " + "\t" + age + "\t");
//                System.out.print("Major" + "\t" + major + "\t");
//                System.out.print("ID" + "\t" + ID + "\n");

                String column[] = new String[5];
                column[0] = name;
                column[1] = gender;
                column[2] = age;
                column[3] = major;
                column[4] = ID;
                ManageGUI.model.addRow(column);
            }
            rs.close();
            conn.closeConnections();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void ReadInfo() {
        ManageGUI.model.setNumRows(0);
        String SearchID = ManageGUI.ReadsectionText.getText();
        if (SearchID.equals("")) {
            JOptionPane.showMessageDialog(null, "SearchBar Cant Be Emepty", "ID Warnning", JOptionPane.WARNING_MESSAGE);
            System.out.println("ID cant be emepty! ");
        } else {
            try {

                conn = new DataBase();
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
                ManageGUI.model.addRow(column);

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

    @Override
    public void DeleteInfo() {
        String ID = ManageGUI.ReadsectionText.getText();
        if (ID.equals("")) {
            JOptionPane.showMessageDialog(null, "SearchBar Cant Be Emepty", "ID Warnning", JOptionPane.WARNING_MESSAGE);
            System.out.println("ID cant be emepty! ");
        } else {
            try {
                conn = new DataBase();
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

    @Override
    public void UpdateInfo() {
        String SearchID = ManageGUI.ReadsectionText.getText();
        String name = ManageGUI.NameText.getText();
        boolean male = ManageGUI.male.isSelected();
        boolean female = ManageGUI.female.isSelected();

        String gender;
        String age = ManageGUI.AgeText.getText();
        String major = ManageGUI.MajorText.getText();
        String ID = ManageGUI.IDText.getText();
        //Text File cant be empty
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
                gender = ManageGUI.male.getText();
            } else {
                gender = ManageGUI.female.getText();
            }
            try {
                //1.Get conection
                conn = new DataBase();
                statement = conn.getConnection().createStatement();
                //2.Define SQL
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
            ManageGUI.model.addRow(column);

        }

    }
// This methos is used to Search info according to ID

    public void Reset() {
        ManageGUI.NameText.setText("");
        ManageGUI.AgeText.setText("");
        ManageGUI.MajorText.setText("");
        ManageGUI.IDText.setText("");
        ManageGUI.genderGroup.clearSelection();
//        OperateGUI.female.setSelected(false);

    }
}
