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
import project2.DB.StudentDataBase;
import project2.GUI.RegisterGUI;

/**
 *
 * @author Kevin
 */
public class Register implements ActionListener {

    JButton source;
    Connection conn;

    StudentDataBase StudentDataBase;
    private Statement state;

    @Override
    public void actionPerformed(ActionEvent e) {

        source = (JButton) e.getSource();
        if ("reg".equals(source.getName()));
        {
            RegButton();
        }

    }

    //connect db
    void RegButton() {
        //get Age

        String passwordText = RegisterGUI.passwordText.getText();
        String confirmTxt = RegisterGUI.confirmTxt.getText();
        //判断确认密码是否一致
        //账号不能为空
        //密码不能为空
        //确认密码不能为空
        if (RegisterGUI.accountText.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Account Field cannot be empty", "Register imformation", JOptionPane.WARNING_MESSAGE);
        } else if (RegisterGUI.passwordText.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Password Field cannot be empty", "Register imformation", JOptionPane.WARNING_MESSAGE);
        } else if ((RegisterGUI.confirmTxt.getText().equals(""))) {
            JOptionPane.showMessageDialog(null, "Comfirm Field cannot be empty", "Register imformation", JOptionPane.WARNING_MESSAGE);
        } else if (passwordText.equals(confirmTxt) == false) {
            JOptionPane.showMessageDialog(null, "Comfirm Field is not same with Password", "Register imformation", JOptionPane.WARNING_MESSAGE);
        } else {
            String account = RegisterGUI.accountText.getText();
            //密码
            String password = RegisterGUI.passwordText.getText();
            try {
                //1.获取conection
                StudentDataBase = new StudentDataBase();
                state = StudentDataBase.getConnection().createStatement();
                //2.定义SQL
                String sql = "INSERT INTO ACCOUNT VALUES ('" + account + "','" + password + "')";
                state.execute(sql);
                System.out.println("Register Successfully");
                 JOptionPane.showMessageDialog(null, "Register Successfully", "Register imformation", JOptionPane.WARNING_MESSAGE);
                StudentDataBase.closeConnections();
            } catch (SQLException e) {
                 JOptionPane.showMessageDialog(null, "Account has existed", "Register imformation", JOptionPane.WARNING_MESSAGE);;
            }

        }

    }
}


