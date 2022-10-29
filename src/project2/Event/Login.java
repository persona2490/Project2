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
import project2.GUI.LoginGUI;
import project2.GUI.OperateGUI;
import project2.GUI.PasswordChangeGui;
import project2.GUI.RUN;
import project2.GUI.RegisterGUI;

/**
 *
 * @author Kevin
 */
public class Login implements ActionListener {

    DataBase conn;
    ResultSet rs;
    PreparedStatement ps = null;
    Statement state;

    JMenuItem item;
    JButton JButton;
    static String Account;
     LoginGUI LoginGUI;
    RegisterGUI registerGUI;
    static OperateGUI operate;
    static PasswordChangeGui passwordChangeGui;

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JButton = (JButton) e.getSource();
            if (JButton.getName().equals("Login")) {

                if (IFMatch()) {
                    RUN.LogSurface.close();
                    operate = new OperateGUI();

                } else {
                    JOptionPane.showMessageDialog(null, "Login Fail");
                }

            }
            if (JButton.getName().equals("Reg")) {
                registerGUI = new RegisterGUI();

            }
            if (JButton.getName().equals("changeown")) {
                String Npassword = PasswordChangeGui.passwordtext.getText();
                System.out.println(Npassword);
                ChangePassword(Account, Npassword);

                JOptionPane.showMessageDialog(null, "Change Successfully, Please re sign in again", "", JOptionPane.WARNING_MESSAGE);
                //Close OperateGUI GUI
                operate.dispose();
                passwordChangeGui.dispose();
                RUN.main(null);
            }

        } catch (Exception e1) {
            try {
                item = (JMenuItem) e.getSource();
                if ("itemB".equals(item.getName())) {
                    passwordChangeGui = new PasswordChangeGui();
                }
            } catch (Exception e2) {
            }

        }
    }

    public boolean IFMatch() throws SQLException {
        String sqlCheck = "SELECT * FROM ACCOUNT WHERE ACCOUNT = ? AND PASSWORD = ?";
        String account = LoginGUI.accountText.getText();
        String password = LoginGUI.passwordText.getText();
        this.Account = account;
        conn = new DataBase();
        ps = conn.getConnection().prepareStatement(sqlCheck);
        ps.setString(1, account);
        ps.setString(2, password);
        rs = ps.executeQuery();

        return rs.next();

    }

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
            System.out.println(account + password);
//
            state.close();
            conn.closeConnections();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

}
