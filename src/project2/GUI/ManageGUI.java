/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
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
import project2.Event.GUI_Switching_Event;
import project2.Event.Modify_Info_Event;
import project2.design.Fonts;

/**
 * all each window The menu bar has two columns: system and user. The user bar
 * can view users and change passwords, and the system bar can log out and log
 * in. The top part is responsible for the operation function, the middle part
 * can display student information as a table, and the bottom part displays user
 * information
 *
 * @author Kevind
 */
public class ManageGUI extends JFrame {

    FlowLayout flowLayout;
    //Label
    JLabel bgimage, Name, Age, ID, Major, Readsection;
    //JTextField
    public static JTextField NameText, AgeText, IDText, MajorText, ReadsectionText;
    //Define Listener
    ActionListener listener_1, listener_2;
    //Define Panel
    JPanel jPanel_1;//bottom layer
    JPanel BottomPanel;
    JPanel UpperPanel;
    //window variable
    static final int WIDTH = 1100;
    static final int HEIGHT = 725;
    //CRUD button
    JButton create, delete, read, readAll, update, reset;
    public static ButtonGroup genderGroup;
    public static JRadioButton male, female;
    //define menu
    JMenuBar menubar;
    JMenu menu, menu1;
    JMenuItem SeeAllUser, PasswordChange;
    JMenuItem exit, LogOut;
    // show result
    public static JTextArea resultArea;
    //Font
    Fonts Fonts = new Fonts();

    //Figure of table
    String columns[] = {"NAME", "GENDER", "AGE", "MAJOR", "ID"};//coolum name
    JTable Jtable = null;
    JScrollPane jscrollpanel;
    static Vector line;
    static Object a[][];
    static int row;
    public static DefaultTableModel model;
    static TableColumnModel columnModel;

    public ManageGUI() {
        System.out.println("Current interface: OprateGUI");
        run();
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        validate();
    }

    void run() {
        flowLayout = new FlowLayout(FlowLayout.CENTER);

        Toolkit kit = Toolkit.getDefaultToolkit();//get object size
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        this.setBounds(x, y, WIDTH, HEIGHT);
        this.setTitle("Register");
        //Background picture
        ImageIcon img = new ImageIcon("src/Project2/img/1.jpg");
        Image image = img.getImage();
        img.setImage(img.getImage().getScaledInstance(WIDTH, HEIGHT, image.SCALE_DEFAULT));
        bgimage = new JLabel(img);
        bgimage.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        //Panel 1
        jPanel_1 = new JPanel();
        jPanel_1.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jPanel_1.setLayout(null);
        jPanel_1.setOpaque(false);
        //UpperPanel
        UpperPanel = new JPanel();
        UpperPanel.setBounds(0, 0, WIDTH - 12, 150);


        UpperPanel.setOpaque(false);
        UpperPanel.setLayout(flowLayout);
        UpperPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        //Buttom Panel
        BottomPanel = new JPanel();
        BottomPanel.setBounds(0, 150, WIDTH - 14, 200);
        BottomPanel.setBorder(BorderFactory.createTitledBorder("Student"));
        BottomPanel.setOpaque(true);
        BottomPanel.setLayout(flowLayout);
        //Gender
        genderGroup = new ButtonGroup();
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        //set menu bar
        menubar = new JMenuBar();
        menu = new JMenu("User");
        menu.setFont(Fonts.BarMenu);

        SeeAllUser = new JMenuItem("See all account");
        SeeAllUser.setFont(Fonts.BarItem);
        PasswordChange = new JMenuItem("Change password");
        PasswordChange.setFont(Fonts.BarItem);

        menu1 = new JMenu("System");
        menu1.setFont(Fonts.BarMenu);

        exit = new JMenuItem("Exit");
        exit.setFont(Fonts.BarItem);
        LogOut = new JMenuItem("Log out");
        LogOut.setFont(Fonts.BarItem);

        menu.add(SeeAllUser);
        menu.add(PasswordChange);

        menu1.add(exit);
        menu1.add(LogOut);

        menubar.add(menu);
        menubar.add(menu1);

        //name
        Name = new JLabel("NAME");
        NameText = new JTextField(15);
        Name.setFont(Fonts.Info_label);
        NameText.setBounds(0, 0, 200, 100);
        //Gender button
        male = new JRadioButton("Male");
        male.setFont(Fonts.Info_label);
        male.setOpaque(false);

        female = new JRadioButton("Female");
        female.setFont(Fonts.Info_label);
        female.setOpaque(false);
        //Age Label
        Age = new JLabel("AGE");
        AgeText = new JTextField(15);
        Age.setFont(Fonts.Info_label);
        //ID Label
        ID = new JLabel("ID");
        IDText = new JTextField(15);
        ID.setFont(Fonts.Info_label);
        //Major Label
        Major = new JLabel("MAJOR");
        MajorText = new JTextField(15);
        Major.setFont(Fonts.Info_label);

        Readsection = new JLabel("Searching with ID");
        ReadsectionText = new JTextField(15);
        Readsection.setFont(Fonts.Info_label);

        //CRUD button
        create = new JButton("Add");
        create.setPreferredSize(new Dimension(150, 50));
        create.setFont(Fonts.Button1);
        delete = new JButton("Delete");
        delete.setPreferredSize(new Dimension(150, 50));
        delete.setFont(Fonts.Button1);
        read = new JButton("Search");
        read.setPreferredSize(new Dimension(150, 50));
        read.setFont(Fonts.Button1);
        readAll = new JButton("ReadAll");
        readAll.setPreferredSize(new Dimension(150, 50));
        readAll.setFont(Fonts.Button1);
        update = new JButton("Update");
        update.setPreferredSize(new Dimension(150, 50));
        update.setFont(Fonts.Button1);
        reset = new JButton("Reset");
        reset.setPreferredSize(new Dimension(150, 50));
        reset.setFont(Fonts.Button1);

        // instantiate tabble
        table();
        resultArea = new JTextArea();
        resultArea.setBounds(0, 353, WIDTH - 30, 200);
//        resultArea.setBounds(0, 0, WIDTH - 30, 200);

        resultArea.setBorder(BorderFactory.createTitledBorder("Account information displays"));
        resultArea.setOpaque(false);
        resultArea.setFont(Fonts.accounttext);
        resultArea.setEditable(false);
        resultArea.setForeground(new Color(224, 57, 151));

//add information Bar
        genderGroup.add(male);
        genderGroup.add(female);
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
        UpperPanel.add(readAll);
        UpperPanel.add(update);
        UpperPanel.add(reset);

        BottomPanel.add(jscrollpanel);
        jPanel_1.add(UpperPanel, BorderLayout.NORTH);
        jPanel_1.add(BottomPanel, BorderLayout.NORTH);

        jPanel_1.add(bgimage);
        this.add(resultArea);
        this.setJMenuBar(menubar);
        this.add(jPanel_1);

        setAllTag();//assign name
        allEvent();//assign event to button

    }

    void table() {
        Jtable = getTable();
        jscrollpanel = new JScrollPane(Jtable);//Add a browse pane
        jscrollpanel.setPreferredSize(new Dimension(WIDTH - 28, 200));//Set the size of the pane
        Jtable.setPreferredSize(new Dimension(WIDTH - 50, 10000));//set the size of the table
        jscrollpanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//Display the sliding component in the window
    }

    JTable getTable() {
        if (Jtable == null) {
            Jtable = new JTable();
            int[] columnWidth = {150, 150, 150, 150, 150};//set column width
            model = new DefaultTableModel() {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };/*Column width and number of rows 
                and make the table uneditable        
             */
            model.setColumnIdentifiers(columns);
            Jtable.setModel(model);//Mode set to table
            columnModel = Jtable.getColumnModel();//Get control of the form
            Jtable.getTableHeader().setReorderingAllowed(false);//Make the table not resizable
            Jtable.getTableHeader().setResizingAllowed(false);
            int count = columnModel.getColumnCount();//Returns the number of columns and rows
            for (int i = 0; i < count; i++) {
                javax.swing.table.TableColumn column = columnModel.getColumn(i);//Returns the objects in the list
                column.setPreferredWidth(columnWidth[i]);
            }
            line = new Vector(5);
        }
        return Jtable;
    }
// set buttn name

    public void setAllTag() {
        NameText.setName("NameText");
        AgeText.setName("AgeText");
        IDText.setName("IDText");
        SeeAllUser.setName("SeeAllUser");
        PasswordChange.setName("PasswordChange");
        exit.setName("Exit");
        LogOut.setName("Log out");

        //button
        create.setName("create");
        delete.setName("delete");
        update.setName("update");
        read.setName("read");
        readAll.setName("readAll");
        reset.setName("reset");

    }
//event

    public void allEvent() {
        listener_1 = new Modify_Info_Event();
        listener_2 = new GUI_Switching_Event();
        SeeAllUser.addActionListener(listener_1);
        PasswordChange.addActionListener(listener_2);
        exit.addActionListener(listener_2);
        LogOut.addActionListener(listener_2);

        create.addActionListener(listener_1);
        update.addActionListener(listener_1);
        read.addActionListener(listener_1);
        delete.addActionListener(listener_1);
        readAll.addActionListener(listener_1);
        reset.addActionListener(listener_1);

    }
}
