/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2.GUI;

/**
 *
 * @author Kevin
 */
public class RUN {
 public static LoginGUI LogSurface;//call this instance to close the initial window
    public static void main(String[] args) {
        runLogGui();
    }

    static public void runLogGui() {
        LoginGUI loginGUI = new LoginGUI();
        LogSurface = loginGUI;
    }

}
