/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2.GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import project2.Event.Register;
import project2.design.Fonts;

/**
 *
 * @author Kevin
 */
public class RegisterGUI extends JFrame {

    FlowLayout flowLayout;

    //Label
    JLabel bgimage;//background
    JLabel Title;
    JLabel register;
    //输入文本框
    JLabel account;
    public static JTextField accountText;
    JLabel password;
    public static JTextField passwordText;
    JLabel confirm;
    public static JTextField confirmTxt;
    JButton reg;

//定义Listener
    ActionListener listener1;

//定义Panel
    JPanel jPanel_1;//底层
    JPanel TitlePanel;
    JPanel MidPanel;

    //窗口变量
    static final int WIDTH = 500;
    final int HEIGHT = 515;

    public RegisterGUI() {
        run();
        validate();
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    void run() {
        flowLayout = new FlowLayout(FlowLayout.CENTER);

        Toolkit kit = Toolkit.getDefaultToolkit();//获取对象大小
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        this.setBounds(x, y, WIDTH, HEIGHT);
        this.setTitle("Register");
        //Panel 1
        jPanel_1 = new JPanel();
        jPanel_1.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jPanel_1.setLayout(null);
        jPanel_1.setOpaque(false);
        //背景图片
        ImageIcon img = new ImageIcon("src/Project2/img/12.jpg");
        Image image = img.getImage();
        img.setImage(img.getImage().getScaledInstance(WIDTH, HEIGHT, image.SCALE_DEFAULT));
        bgimage = new JLabel(img);
        bgimage.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        //标题
        Fonts Fonts = new Fonts();

        TitlePanel = new JPanel();
        TitlePanel.setBounds(0, 30, WIDTH, 70);
        TitlePanel.setOpaque(false);

        Title = new JLabel("Register");
        Title.setFont(Fonts.RGtitle);

        //初始化第三个
        MidPanel = new JPanel();
        MidPanel.setBounds(150, 100, 200, 250);
        MidPanel.setOpaque(false);
        MidPanel.setLayout(flowLayout);
        //第一行初始化
        account = new JLabel("    Account: ");
        accountText = new JTextField(15);
        account.setFont(Fonts.account);
        accountText.setBounds(x, y, 200, 100);
        //第二行
        password = new JLabel("Password: ");
        passwordText = new JTextField(15);
        password.setFont(Fonts.account);
        //第三行
        confirm = new JLabel("Comfirm Password:");
        confirmTxt = new JTextField(15);
        confirm.setFont(Fonts.account);
        //第四行
        reg = new JButton("        Register        ");

        reg.setPreferredSize(new Dimension(150, 50));

//        Title.setBounds(0, 0, 200, 200);
        //添加
        MidPanel.add(account);
        MidPanel.add(accountText);

        MidPanel.add(password);
        MidPanel.add(passwordText);

        MidPanel.add(confirm);
        MidPanel.add(confirmTxt);

        MidPanel.add(reg);

        TitlePanel.add(Title);

        MidPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        jPanel_1.add(MidPanel);
        jPanel_1.add(TitlePanel);
        jPanel_1.add(bgimage);

        this.add(jPanel_1);
        allEvent();
        setAllTag();

    }

    void allEvent() {
        listener1 = new Register();

        reg.addActionListener(listener1);

    }

    void setAllTag() {

        reg.setName("reg");
    }

}
