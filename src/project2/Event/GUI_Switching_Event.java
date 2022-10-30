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
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import project2.DB.DataBase;
import project2.GUI.EndPage;
import project2.GUI.LoginGUI;
import project2.GUI.ManageGUI;
import project2.GUI.PasswordChangeGui;
import project2.GUI.RUN;
import project2.GUI.RegisterGUI;

/**
 *This class is mainly responsible for switching between GUIs under specific events
 * @author Kevin
 */
public class GUI_Switching_Event implements ActionListener {
// Define the database
    DataBase conn;
    ResultSet rs;
    PreparedStatement ps = null;
    Statement state;
//GUi Conponet
    JMenuItem item;
    JButton JButton;
  
    RegisterGUI registerGUI;
    LoginGUI LoginGUI;
    
    static String Account;//capture the entered user account
    static ManageGUI operate;
    static PasswordChangeGui passwordChangeGui;
    static EndPage EndPage;

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JButton = (JButton) e.getSource();
            if (JButton.getName().equals("Login")) {
                System.out.println("User Click Login Button.");
                
                if (IFMatch()) {//if password match account, return true
                    System.out.println("User "+Account+" Login in Successfully!");
                    RUN.LogSurface.close();
                    operate = new ManageGUI();
                } else {
                    System.out.println("Login Fail!");
                    JOptionPane.showMessageDialog(null, "Login Fail");
                }
            }
            if (JButton.getName().equals("Reg")) {
                System.out.println("User Click Register Button.");
                registerGUI = new RegisterGUI();
            }
            if (JButton.getName().equals("Exit")) {
                System.out.println("User Click Exit Button.");
                System.out.println("Thanks for you using!");
                System.exit(0);
            }
            if (JButton.getName().equals("changeown")) {
                System.out.println("User Click Change Button.");
                
                String Npassword = PasswordChangeGui.passwordtext.getText();
                ChangePassword(Account, Npassword);
                
                JOptionPane.showMessageDialog(null, "Change Successfully, Please re sign in again", "", JOptionPane.WARNING_MESSAGE);
                //Close OperateGUI 
                operate.dispose();
                passwordChangeGui.dispose();
                RUN.main(null);
            }

        } catch (Exception e1) {
            try {
                item = (JMenuItem) e.getSource();
                if ("PasswordChange".equals(item.getName())) {
                    System.out.println("User start to change password! ");
                    passwordChangeGui = new PasswordChangeGui();
                }
                if ("Exit".equals(item.getName())) {
                    System.out.println("User finish managing student inforamtion. ");
                    operate.dispose();
                    EndPage = new EndPage();
                }

                if ("Log out".equals(item.getName())) {
                    System.out.println(Account+" log out. ");
                    operate.dispose();
//                    Run.run();
                    RUN.main(null);
                }
            } catch (Exception e2) {
                System.out.println("Invalid Function! ");
            }

        }
    }
// Determine whether the account password matches

    public boolean IFMatch() throws SQLException {
        String sqlCheck = "SELECT * FROM ACCOUNT WHERE ACCOUNT = ? AND PASSWORD = ?";
        String account = LoginGUI.accountText.getText();
        String password = LoginGUI.passwordText.getText();
        if (account.equals("")) {
            System.out.println("Warnning!");
            System.out.println("Account Field cannot be empty");
            JOptionPane.showMessageDialog(null, "Account Field cannot be empty", "Login  imformation", JOptionPane.WARNING_MESSAGE);
        } else if (password.equals("")) {
            System.out.println("Warnning!");
            System.out.println("Password Field cannot be empty");
            JOptionPane.showMessageDialog(null, "Password Field cannot be empty", "Login imformation", JOptionPane.WARNING_MESSAGE);
        } else {
            Account = account;
            conn = new DataBase();//Read data from the database
            ps = conn.getConnection().prepareStatement(sqlCheck);
            ps.setString(1, account);//The first value returned is the account 
            ps.setString(2, password);//The second value returned is the password
            rs = ps.executeQuery();
        }
        return rs.next();
    }
// Change the password of the already logged in account

    private void ChangePassword(String account, String password) {
        try {
            conn = new DataBase();
            state = conn.getConnection().createStatement();
            String sqlChange = "UPDATE Account  SET  password = '" + password + "' WHERE ACCOUNT = '" + account + "'";
            state.execute(sqlChange);
//            ps = conn.getConnection().prepareStatement(sqlChange);
//            ps.setString(1, account);
//            ps.setString(2, password);
//            ps.executeUpdate();
            System.out.println("Change Successfully!");
            System.out.println("Account: " + account + " Your new password is: " + password);
            state.close();
            conn.closeConnections();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

}
