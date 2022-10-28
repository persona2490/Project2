/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2.Event;

import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.security.auth.login.AccountException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import project2.DB.StudentDataBase;
import project2.GUI.LoginGUI;
import project2.GUI.Operate;
import project2.GUI.PasswordChangeGui;
import project2.GUI.RegisterGUI;

/**
 *
 * @author Kevin
 */
public class Login implements ActionListener {

    StudentDataBase conn;
    ResultSet rs;
    JButton JButton;
    PreparedStatement ps = null;
    static String Account;
    Statement state;
    LoginGUI LoginGUI;
    RegisterGUI registerGUI;

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JButton = (JButton) e.getSource();
            if (JButton.getName().equals("Login")) {

                if (IFMatch()) {
                    Operate operate = new Operate();

                } else {
                    JOptionPane.showMessageDialog(null, "Login Fail");
                }

            }
            if (JButton.getName().equals("Reg")) {
                registerGUI = new RegisterGUI();
//                LoginGUI.setVisible(false);
                
//                 LoginGUI.dispatchEvent(new WindowEvent(LoginGUI,WindowEvent.WINDOW_CLOSING) );
            }
            if (JButton.getName() == "changeown") {
                String Npassword = PasswordChangeGui.passwordtext.getText();
                System.out.println(Npassword);
                ChangePassword(Account, Npassword);

                JOptionPane.showMessageDialog(null, "Change Successfully", "", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }

        } catch (SQLException e1) {
        }
    }

    public boolean IFMatch() throws SQLException {
        String sqlCheck = "SELECT * FROM ACCOUNT WHERE ACCOUNT = ? AND PASSWORD = ?";
        String account = LoginGUI.accountText.getText();
        String password = LoginGUI.passwordText.getText();
        this.Account = account;
        conn = new StudentDataBase();
        ps = conn.getConnection().prepareStatement(sqlCheck);
        ps.setString(1, account);
        ps.setString(2, password);
        rs = ps.executeQuery();
        return rs.next();

    }

    private void ChangePassword(String account, String password) {

        try {
            conn = new StudentDataBase();
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
