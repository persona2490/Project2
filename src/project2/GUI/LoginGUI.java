/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import project2.Event.GUI_Switching_Event;
import project2.design.Fonts;

/**
 * This class is responsible for calling the graphical interface that starts
 *After entering the correct account and password, click Login to enter the management GUI, click Register to enter the registration GUI,
 * @author Kevin
 */
public class LoginGUI extends JFrame {

    //define a layout
    FlowLayout flowLayout;
    //listener class definition
    GUI_Switching_Event loginEvent;
    //Label
    JLabel bgimage;
    JLabel title;
    JLabel account;
    JLabel passowrd;
    public static JTextField accountText;
    public static JTextField passwordText;
    JButton logButton;
    JButton RGButton;
//Define Font
    Fonts Fonts;

    //Set the width height of the frame
    static final int WIDTH = 500;
    static final int HEIGHT = 280;

    JPanel BGJPanel;
    JPanel TitleJPanel;
    JPanel LogJPanel;

    public LoginGUI() {
        System.out.println("Current interface: Login GUI");
        run();
        validate();
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    void run() {

        flowLayout = new FlowLayout(FlowLayout.CENTER);
        //BGJPanel

        BGJPanel = new JPanel();
        BGJPanel.setBounds(0, 0, WIDTH, HEIGHT);
        BGJPanel.setLayout(null);
        //TitleJPanel
        TitleJPanel = new JPanel();
        TitleJPanel.setBounds(0, 0, WIDTH, HEIGHT);
        TitleJPanel.setLayout(flowLayout);
        TitleJPanel.setOpaque(false);
        //LogPanel
        LogJPanel = new JPanel();
        LogJPanel.setBounds(100, 105, 300, 125);
        LogJPanel.setLayout(flowLayout);
        LogJPanel.setOpaque(false);
        LogJPanel.setBorder(BorderFactory.createTitledBorder(""));

        //Font Configuration
        Fonts = new Fonts();
        //Set the size of the current window
        Toolkit kit = Toolkit.getDefaultToolkit();//get object size	
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;//Get screen height and width
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        this.setBounds(x, y, WIDTH, HEIGHT);//show the window at center
        this.setTitle("Login");
        //Background
//        ImageIcon img = new ImageIcon("D:/STUDY/COMP603 Prpgram design/Project2/Project2/src/project2/img/1.jpg");
        ImageIcon img = new ImageIcon("src/Project2/img/1.jpg");

        bgimage = new JLabel(img);
        bgimage.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        //Tittle
        title = new JLabel("Student Information Management System");
        title.setFont(Fonts.title);

        //Account textfiled
        account = new JLabel("Username: ");
        account.setFont(Fonts.Info_label);
        account.setForeground(new Color(224, 57, 151));
        accountText = new JTextField(15);
        accountText.setFont(Fonts.accounttext);
        accountText.setForeground(new Color(224, 57, 151));
        //password label
        passowrd = new JLabel("Password: ");
        passowrd.setFont(Fonts.Info_label);
        passowrd.setForeground(new Color(224, 57, 151));
        passwordText = new JTextField(15);
        passwordText.setFont(Fonts.accounttext);
        passwordText.setForeground(new Color(224, 57, 151));
        //Login button
        logButton = new JButton("Login");
        logButton.setPreferredSize(new Dimension(80, 35));
        logButton.setFont(Fonts.login);
        logButton.setBackground(new Color(8, 189, 252));
        logButton.setForeground(new Color(224, 57, 151));

        //Register button
        RGButton = new JButton("Register");
        RGButton.setPreferredSize(new Dimension(85, 35));
        RGButton.setFont(Fonts.login);
        RGButton.setBackground(new Color(8, 189, 252));
        RGButton.setForeground(new Color(224, 57, 151));

        //Add 
        LogJPanel.add(account);
        LogJPanel.add(accountText);
        LogJPanel.add(passowrd);
        LogJPanel.add(passwordText);
        LogJPanel.add(RGButton);
        LogJPanel.add(logButton);

        TitleJPanel.add(title);

        BGJPanel.add(TitleJPanel);
        BGJPanel.add(LogJPanel);
        BGJPanel.add(bgimage);
        this.add(BGJPanel);
        allEvent();
        setAllTag();

    }
//  events 

    void allEvent() {
        loginEvent = new GUI_Switching_Event();
        RGButton.addActionListener(loginEvent);
        logButton.addActionListener(loginEvent);
    }

    public void setAllTag() {
        RGButton.setName("Reg");
        logButton.setName("Login");
    }
//make the current window disappear

    public void close() {
        this.dispose();
    }
}
