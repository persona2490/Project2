/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2.GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import project2.design.Fonts;
import static project2.GUI.LoginGUI.HEIGHT;
import static project2.GUI.LoginGUI.WIDTH;

/**
 *
 * @author Kevin
 */
public class OperationGUI extends JFrame {

    //定义布局
    FlowLayout flowlayout;//定义一个布局
    //定义窗口的高度和宽度
    //窗口变量  
    final int WIDTH = 1400;//设置顶层框架的宽度
    final int HEIGHT = 725;//设置顶层框架的高度
    //定义标签
    JLabel bgimage;//顶层的图片
    //定义菜单莱
    JMenuBar menubar;
    JMenu menu, menu1;
    JMenuItem itemA, itemB, itemC, itemD;
    JMenuItem item1, item2;
    //JPanel
    JPanel JPanel1;
    JPanel JPanel2;
    //JLabel
    JLabel name;
    JLabel ID;
    JLabel gender;
    JLabel age;
    //JTxt
    public static JTextField ageField;
    public static JTextField nameField;
    public static JTextField IDField;
    public static JTextField CourseField;
    //GroupButton
    ButtonGroup buttonGroup;
    JRadioButton male, female;

    public OperationGUI() {
        run();
        validate();
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void run() {
        this.setLayout(null);
        //Configure font
        Fonts Fonts = new Fonts();

        Toolkit kit = Toolkit.getDefaultToolkit();//获取对象大小
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        this.setBounds(x, y, WIDTH, HEIGHT);
        this.setTitle("Ooperator");
        //设置背景图片
        ImageIcon img = new ImageIcon("src/Project2/img/1120.jfif");
        Image image = img.getImage();
        img.setImage(img.getImage().getScaledInstance(WIDTH, HEIGHT, image.SCALE_DEFAULT));
        bgimage = new JLabel(img);
        bgimage.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        //Panel1
        JPanel1 = new JPanel();
        JPanel1.setLayout(flowlayout);
        JPanel1.setBounds(0, 80, WIDTH - 10, 150);
        JPanel1.setBorder(BorderFactory.createTitledBorder("基本信息处理"));
        JPanel1.setOpaque(false);

        JPanel2 = new JPanel();
        JPanel2.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        JPanel2.setLayout(null);
        JPanel2.setOpaque(false);
        

        //设置菜单栏
        menubar = new JMenuBar();
        menu = new JMenu("管理");
        itemA = new JMenuItem("查看在线的账号");
        itemB = new JMenuItem("查看所有账号");
        itemC = new JMenuItem("更改员工账号信息");
        itemD = new JMenuItem("更改当前账户密码");
        menu1 = new JMenu("Account");
        item1 = new JMenuItem("Exit");
        item1.setFont(Fonts.Baritem);
        item2 = new JMenuItem("注销");

        menu.add(itemA);
        menu.add(itemB);
        menu.add(itemC);
        menu.add(itemD);

        menu1.add(item1);
        menu1.add(item2);

        menubar.add(menu);
        menubar.add(menu1);

        //Label
        name = new JLabel("Name: ");
        age = new JLabel("Age: ");

        //txt
        nameField = new JTextField(15);
        //gender
        buttonGroup = new ButtonGroup();
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        buttonGroup.add(male);
        buttonGroup.add(female);

        JPanel1.add(name);
        JPanel1.add(nameField);
        JPanel1.add(age);
        JPanel1.add(male);
        JPanel1.add(female);

        JPanel2.add(JPanel1);
        JPanel2.add(bgimage);

        this.add(menubar);
        this.add(JPanel2);
        this.setJMenuBar(menubar);

    }

}
