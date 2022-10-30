/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2.GUI;

/**
 *
 * @author Kevin
 */
import java.awt.Color;
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

import project2.Event.GUI_Switching_Event;

import project2.design.Fonts;

/**
 *To end the interface, click exit to end the system
 * @author Kevin
 */
public class EndPage extends JFrame {

    FlowLayout flowlayout;//define a layout
    final int WIDTH = 700;//Set the width of the frame
    final int HEIGHT = 500;//Set the height of the frame
    //2 label, a textfiled  and a button
    JLabel password;
    JLabel bgimage;//background

    JButton Exit;
    //define a listener event   
    ActionListener lintener_1;

    JPanel BGJPanel, buttonJPanel;
    //Call font design
    Fonts Fonts;

    public EndPage() {
        System.out.println("Current interface: End page");
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
        this.setLayout(flowlayout);
        flowlayout = new FlowLayout(FlowLayout.LEADING);

        //Font Configuration
        Fonts = new Fonts();

        BGJPanel = new JPanel();
        BGJPanel.setBounds(0, 0, WIDTH, HEIGHT);
        BGJPanel.setLayout(null);
        BGJPanel.setOpaque(false);
        //buttonPanel
        buttonJPanel = new JPanel();
        buttonJPanel.setBounds(100, 370, 100, 50);
        buttonJPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonJPanel.setOpaque(false);

        //BackGround picture
        ImageIcon img = new ImageIcon("src/Project2/img/back.jpg");
        Image image = img.getImage();
        img.setImage(img.getImage().getScaledInstance(WIDTH, HEIGHT, image.SCALE_DEFAULT));
        bgimage = new JLabel(img);
        bgimage.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        Color c = new Color(0, 0, 255);//Set the button background to transparent
        Exit = new JButton("Exit");
        Exit.setBounds(100, 370, 100, 60);
        Exit.setOpaque(false);
        Exit.setBackground(c);
        Exit.setFont(Fonts.Button);

        Exit.setName("Exit");
        lintener_1 = new GUI_Switching_Event();
        Exit.addActionListener(lintener_1);

        buttonJPanel.add(Exit);
        BGJPanel.add(buttonJPanel);
//        BGJPanel.add(Exit);
        BGJPanel.add(bgimage);
        this.add(BGJPanel);
//        this.add(password);
//        this.add(passwordtext);
//        this.add(Exit);

    }
}
