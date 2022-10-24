/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2.design;

import java.awt.Font;

/**
 *
 * @author Kevin
 */
public class Fonts {

    public static Font title;
    public static Font RGtitle;
    public static Font account;
    public static Font accounttext;
    public static Font login;

    public Fonts() {
        title = new Font("Serif", Font.BOLD, 25);
        RGtitle = new Font("DialogInput", Font.BOLD|Font.ITALIC, 30);
        account = new Font("Serif", Font.BOLD, 16);
        accounttext = new Font("Serif", Font.PLAIN, 16);
        login = new Font("Dialog", Font.BOLD, 12);
    }

}
