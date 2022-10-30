/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2.GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import project2.Event.GUI_Switching_Event;

/**
 * This class is responsible for calling password change gui
 * @author Kevin
 */
public class PasswordChangeGui extends JFrame {

    FlowLayout flowlayout;//define a layout
    final int WIDTH = 300;//Set the width of the frame
    final int HEIGHT = 200;//Set the height of the frame
    //a label, a textfiled  and a button
    JLabel password;
    public static JPasswordField passwordtext;
    JButton changeown;
    //define a listener event   
    ActionListener lintener_1;

    public PasswordChangeGui() {
        System.out.println("Current interface: password change GUI");
        run();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        validate();

    }

    void run() {
        //Set the size of the current window
        Toolkit kit = Toolkit.getDefaultToolkit();//get object size	
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;//Get screen height and width
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        this.setBounds(x, y, WIDTH, HEIGHT);
        flowlayout = new FlowLayout(FlowLayout.CENTER);
        this.setLayout(flowlayout);//set layout

        password = new JLabel("Password ");
        passwordtext = new JPasswordField(15);
        changeown = new JButton("Change");
        //

        changeown.setName("changeown");
        lintener_1 = new GUI_Switching_Event();
        changeown.addActionListener(lintener_1);
        this.setTitle("PasswordChange");

        this.add(password);
        this.add(passwordtext);
        this.add(changeown);

    }
}
