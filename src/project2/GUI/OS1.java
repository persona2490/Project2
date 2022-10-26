/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import project2.design.Fonts;

/**
 *
 * @author Kevind 调用注册窗口
 */
public class OS1 extends JFrame {

    FlowLayout flowLayout;
    //Label
    JLabel bgimage, Name, Age, ID, Major, Readsection;
    //输入文本框
    public static JTextField NameText, AgeText, IDText, MajorText, ReadsectionText;
//定义Listener
    ActionListener listener1;
//定义Panel
    JPanel jPanel_1;//底层
    JPanel ButtomPanel;
    JPanel UpperPanel;
    //窗口变量
    static final int WIDTH = 1100;
    final int HEIGHT = 725;
    //CRUD button
    JButton create, delete, read, update, reset;
    JRadioButton male, female;
    //定义菜单
    JMenuBar menubar;
    JMenu menu, menu1;
    JMenuItem itemA, itemB, itemC, itemD;
    JMenuItem item1, item2;
    //显示结果 
    JTextArea resultArea;

    //Figure of table
    String columns[] = {"NAME", "GENDER", "AGE", "MAJOR", "ID"};//coolum name
    JTable Jtable = null;
    JScrollPane jscrollpanel;
    static Vector line;
    static Object a[][];
    static int row;
    public static DefaultTableModel model;
    static TableColumnModel columnModel;

    public OS1() {
        run();
        validate();
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    void run() {
        flowLayout = new FlowLayout(FlowLayout.CENTER);
        //Font
        Fonts Fonts = new Fonts();

        Toolkit kit = Toolkit.getDefaultToolkit();//获取对象大小
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        this.setBounds(x, y, WIDTH, HEIGHT);
        this.setTitle("Register");
        //背景图片
        ImageIcon img = new ImageIcon("src/Project2/img/1.jfif");
        Image image = img.getImage();
        img.setImage(img.getImage().getScaledInstance(WIDTH, HEIGHT, image.SCALE_DEFAULT));
        bgimage = new JLabel(img);
        bgimage.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        //Panel 1
        jPanel_1 = new JPanel();
        jPanel_1.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jPanel_1.setLayout(null);
        jPanel_1.setOpaque(false);
        //Up
        UpperPanel = new JPanel();
        UpperPanel.setBounds(0, 0, WIDTH - 12, 100);
        UpperPanel.setOpaque(false);
        UpperPanel.setLayout(flowLayout);
        UpperPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        //Gender
//        buttonGroup = new ButtonGroup();
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
//        buttonGroup.add(male);
//        buttonGroup.add(female);
        //设置菜单栏
        menubar = new JMenuBar();
        menu = new JMenu("Management");
        itemA = new JMenuItem("查看在线的账号");
        itemB = new JMenuItem("See all account");
        itemC = new JMenuItem("更改员工账号信息");
        itemD = new JMenuItem("Change password");
        menu1 = new JMenu("Account");
        item1 = new JMenuItem("Exit");
        item2 = new JMenuItem("Log out");

        menu.add(itemA);
        menu.add(itemB);
        menu.add(itemC);
        menu.add(itemD);

        menu1.add(item1);
        menu1.add(item2);

        menubar.add(menu);
        menubar.add(menu1);

//        sw = new JLabel("Register");
//        sw.setFont(Fonts.title);
        //第一行初始化
        Name = new JLabel("NAME");
        NameText = new JTextField(15);
        Name.setFont(Fonts.account);
        NameText.setBounds(0, 0, 200, 100);
        //Gender
//        buttonGroup = new ButtonGroup();
        male = new JRadioButton("Male");
        male.setFont(Fonts.account);
        male.setOpaque(false);

        female = new JRadioButton("Female");
        female.setFont(Fonts.account);
        female.setOpaque(false);

//        buttonGroup.add(male);
//        buttonGroup.add(female);
        Age = new JLabel("AGE");
        AgeText = new JTextField(15);
        Age.setFont(Fonts.account);

        ID = new JLabel("ID");
        IDText = new JTextField(15);
        ID.setFont(Fonts.account);

        Major = new JLabel("MAJOR");
        MajorText = new JTextField(15);
        Major.setFont(Fonts.account);

        Readsection = new JLabel("Reading with ID");
        ReadsectionText = new JTextField(15);
        Readsection.setFont(Fonts.account);

        //第5行
        create = new JButton("Add");
        create.setPreferredSize(new Dimension(150, 50));
        delete = new JButton("Delete");
        delete.setPreferredSize(new Dimension(150, 50));
        read = new JButton("Read");
        read.setPreferredSize(new Dimension(150, 50));
        update = new JButton("Update");
        update.setPreferredSize(new Dimension(150, 50));
        reset = new JButton("Reset");
        reset.setPreferredSize(new Dimension(150, 50));

        //Buttom Panel
        ButtomPanel = new JPanel();
        ButtomPanel.setBounds(0, 100, WIDTH - 14, 300);
        ButtomPanel.setBorder(BorderFactory.createTitledBorder("Account information displays"));
        ButtomPanel.setOpaque(false);
        ButtomPanel.setLayout(flowLayout);
        table();
        resultArea = new JTextArea();
        resultArea.setBounds(15, 400, WIDTH - 30, 200);
        resultArea.setBorder(BorderFactory.createTitledBorder("Information stauts displays"));
        resultArea.setOpaque(false);

//add information
        UpperPanel.add(Name);
        UpperPanel.add(NameText);
        UpperPanel.add(male);
        UpperPanel.add(female);
        UpperPanel.add(Age);
        UpperPanel.add(AgeText);
        UpperPanel.add(Major);
        UpperPanel.add(MajorText);
        UpperPanel.add(ID);
        UpperPanel.add(IDText);
        UpperPanel.add(Readsection);
        UpperPanel.add(ReadsectionText);
//add Button
        UpperPanel.add(create);
        UpperPanel.add(delete);
        UpperPanel.add(read);
        UpperPanel.add(update);

        ButtomPanel.add(jscrollpanel);
        jPanel_1.add(UpperPanel, BorderLayout.NORTH);
        jPanel_1.add(ButtomPanel);

        jPanel_1.add(bgimage);
        this.add(resultArea);
        this.setJMenuBar(menubar);
        this.add(jPanel_1);
//        allEvent();
//        setAllTag();

    }

    void table() {
        Jtable = getTable();
        jscrollpanel = new JScrollPane(Jtable);//添加一个浏览窗格
        jscrollpanel.setPreferredSize(new Dimension(WIDTH - 80, 200));//给窗格设置大小
        Jtable.setPreferredSize(new Dimension(WIDTH - 80, 10000));//给表格设置大小
        jscrollpanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//将滑动组件显示在窗口中
    }

    JTable getTable() {
        if (Jtable == null) {
            Jtable = new JTable();//创建 
            int[] columnWidth = {150, 150, 150, 150, 150};//设置列宽
            model = new DefaultTableModel() {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };//列宽 和行数  并且让表格不可编辑
            model.setColumnIdentifiers(columns);
            Jtable.setModel(model);//设置为表格的模式
            columnModel = Jtable.getColumnModel();//获取到表格的控制
            Jtable.getTableHeader().setReorderingAllowed(false);//让表格不可拖动
            Jtable.getTableHeader().setResizingAllowed(false);//让表格不可拖动
            int count = columnModel.getColumnCount();//返回列数和行数
            for (int i = 0; i < count; i++) {
                javax.swing.table.TableColumn column = columnModel.getColumn(i);//返回列表中的对象
                column.setPreferredWidth(columnWidth[i]);
            }
            line = new Vector(5);
        }
        return Jtable;
    }
//    void allEvent() {
//        listener1 = new Accountevent();
//        NameText.addActionListener(listener1);
//        AgeText.addActionListener(listener1);
//        IDText.addActionListener(listener1);
//        add.addActionListener(listener1);
//    }
//
//    void setAllTag() {
//        NameText.setName("NameText");
//        AgeText.setName("AgeText");
//        IDText.setName("IDText");
//        add.setName("add");
//    }
}
