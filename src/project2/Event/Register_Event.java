/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import project2.DB.DataBase;
import project2.GUI.RegisterGUI;

/**
 * This class is responsible for creating user accounts
 *
 * @author Kevin
 */
public class Register_Event implements ActionListener {

    JButton Button;
    Connection conn;

    DataBase StudentDataBase;
    private Statement state;

    @Override
    public void actionPerformed(ActionEvent e) {

        Button = (JButton) e.getSource();
        if ("reg".equals(Button.getName()));
        {
            RegButton();
        }
    }

    void RegButton() {

        String account = RegisterGUI.accountText.getText();
        String passwordText = RegisterGUI.passwordText.getText();
        String confirmTxt = RegisterGUI.confirmTxt.getText();
        // Determine whether the confirmation password is the same
        //Account cannot be empty
        //password can not be blank
        //confirm password can not be blank
        if (account.equals("")) {
            System.out.println("Account Field cannot be empty");
            JOptionPane.showMessageDialog(null, "Account Field cannot be empty", "Register imformation", JOptionPane.WARNING_MESSAGE);
        } else if (passwordText.equals("")) {
            System.out.println("Password Field cannot be empty");
            JOptionPane.showMessageDialog(null, "Password Field cannot be empty", "Register imformation", JOptionPane.WARNING_MESSAGE);
        } else if ((confirmTxt.equals(""))) {
            System.out.println("Confirm Field cannot be empty");
            JOptionPane.showMessageDialog(null, "Comfirm Field cannot be empty", "Register imformation", JOptionPane.WARNING_MESSAGE);
        } else if (passwordText.equals(confirmTxt) == false) {
            System.out.println("Comfirm Field is not same with Password");
            JOptionPane.showMessageDialog(null, "Comfirm Field is not same with Password", "Register imformation", JOptionPane.WARNING_MESSAGE);
        } else {

            try {
                //1.get conection
                StudentDataBase = new DataBase();
                state = StudentDataBase.getConnection().createStatement();
                //2.Define SQL
                String sql = "INSERT INTO ACCOUNT VALUES ('" + account + "','" + passwordText + "')";
                state.execute(sql);
                System.out.println("Register Successfully");
                JOptionPane.showMessageDialog(null, "Register Successfully", "Register imformation", JOptionPane.WARNING_MESSAGE);
                StudentDataBase.closeConnections();
            } catch (SQLException e) {
                System.out.println("Account has existed");
                JOptionPane.showMessageDialog(null, "Account has existed", "Register imformation", JOptionPane.WARNING_MESSAGE);;
            }
        }
    }
}
