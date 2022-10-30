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
    public static Font Info_label;
    public static Font accounttext;
    public static Font login;
    public static Font BarMenu;
    public static Font Button;
    public static Font Button1;
    public static Font BarItem;

    public Fonts() {
        title = new Font("Serif", Font.HANGING_BASELINE, 25);
        RGtitle = new Font("DialogInput", Font.BOLD | Font.ITALIC, 30);
        Info_label = new Font("Serif", Font.BOLD, 16);
        accounttext = new Font("Serif", Font.PLAIN, 16);
        login = new Font("Dialog", Font.BOLD, 12);

        BarMenu = new Font("Dialog", Font.LAYOUT_LEFT_TO_RIGHT, 18);
        BarItem = new Font("Serif", Font.TRUETYPE_FONT, 14);
        Button = new Font("Monospace", Font.HANGING_BASELINE, 18);
        Button1 = new Font("Serif", Font.ROMAN_BASELINE, 18);

    }

}
