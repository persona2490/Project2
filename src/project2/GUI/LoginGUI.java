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

import project2.Event.Login;
import project2.design.Fonts;

/**
 *
 * @author Kevin //调用登录窗口
 */
public class LoginGUI extends JFrame {

    FlowLayout flowLayout;
    //监听类定义

    Login loginEvent;

    //Label
    JLabel bgimage;
    JLabel title;
    JLabel account;
    JLabel passowrd;
    public static JTextField accountText;
    public static JTextField passwordText;
    JButton logButton;
    JButton RGButton;

    //窗口数值
    static final int WIDTH = 500;
    static final int HEIGHT = 280;

    JPanel BGJPanel;
    JPanel TitleJPanel;
    JPanel LogJPanel;

    public LoginGUI() {
        run();
        validate();
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    void run() {
        //定义一个布局
        flowLayout = new FlowLayout(FlowLayout.CENTER);
        //创建BGJPanel
//       BGJPanel = new javax.swing.JPanel();
        BGJPanel = new JPanel();
        BGJPanel.setBounds(0, 0, WIDTH, HEIGHT);
        BGJPanel.setLayout(null);
        //创建TitleJPanel
        TitleJPanel = new JPanel();
        TitleJPanel.setBounds(0, 0, WIDTH, HEIGHT);
        TitleJPanel.setLayout(flowLayout);
        TitleJPanel.setOpaque(false);
        //LogPanel
        LogJPanel = new JPanel();
        LogJPanel.setBounds(100, 105, 300, 125);
        LogJPanel.setLayout(flowLayout);
        LogJPanel.setOpaque(false);
        LogJPanel.setBorder(BorderFactory.createTitledBorder("基本"));

        //Font Configuration
        Fonts Fonts = new Fonts();       
        //窗口大小
        Toolkit kit = Toolkit.getDefaultToolkit();//获取对象大小
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        this.setBounds(x, y, WIDTH, HEIGHT);
        this.setTitle("Login");
        //Background
//        ImageIcon img = new ImageIcon("D:/STUDY/COMP603 Prpgram design/Project2/Project2/src/project2/img/1.jpg");
        ImageIcon img = new ImageIcon("src/Project2/img/1.jpg");

        bgimage = new JLabel(img);
        bgimage.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        //Tittle
        title = new JLabel("Student Information Management System");
        title.setFont(Fonts.title);

        //添加账号和密码，还有编辑框
        //账号文本框
        account = new JLabel("Username: ");
        account.setFont(Fonts.account);
        account.setForeground(new Color(224, 57, 151));
        accountText = new JTextField(15);
        accountText.setFont(Fonts.accounttext);
        accountText.setForeground(new Color(224, 57, 151));

        //密码标签
        passowrd = new JLabel("Password: ");
        passowrd.setFont(Fonts.account);
        passowrd.setForeground(new Color(224, 57, 151));
        passwordText = new JTextField(15);
        passwordText.setFont(Fonts.accounttext);
        passwordText.setForeground(new Color(224, 57, 151));
        //登录按钮
        logButton = new JButton("Login");
        logButton.setPreferredSize(new Dimension(80, 35));
        logButton.setFont(Fonts.login);
        logButton.setBackground(new Color(8, 189, 252));
        logButton.setForeground(new Color(224, 57, 151));
        logButton.setName("Login");
        //注册按钮
        RGButton = new JButton("Register");
        RGButton.setPreferredSize(new Dimension(85, 35));
        RGButton.setFont(Fonts.login);
        RGButton.setBackground(new Color(8, 189, 252));
        RGButton.setForeground(new Color(224, 57, 151));
        RGButton.setName("Reg");
        //添加
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

    }

    void allEvent() {
        loginEvent = new Login();
        RGButton.addActionListener(loginEvent);
        logButton.addActionListener(loginEvent);
    }
//让当前窗口消失
    public void close() {
        this.dispose();
   }
}
