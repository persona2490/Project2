/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import project2.DB.StudentDataBase;
import project2.GUI.OS1;

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

        String passwordText = OS1.AgeText.getText();
        String confirmTxt = OS1.IDText.getText();
        //判断确认密码是否一致
        //账号不能为空
        //密码不能为空
        //确认密码不能为空
        if (OS1.NameText.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Account Field cannot be empty", "Register imformation", JOptionPane.WARNING_MESSAGE);
        } else if (OS1.AgeText.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Password Field cannot be empty", "Register imformation", JOptionPane.WARNING_MESSAGE);
        } else if ((OS1.IDText.getText().equals(""))) {
            JOptionPane.showMessageDialog(null, "Comfirm Field cannot be empty", "Register imformation", JOptionPane.WARNING_MESSAGE);
        } else if (passwordText.equals(confirmTxt) == false) {
            JOptionPane.showMessageDialog(null, "Comfirm Field is not same with Password", "Register imformation", JOptionPane.WARNING_MESSAGE);
        } else {
            String account = OS1.NameText.getText();
            //密码
            String password = OS1.AgeText.getText();
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


//判断确认密码是否一致
//账号不能为空
//密码不能为空
//确认密码不能为空

