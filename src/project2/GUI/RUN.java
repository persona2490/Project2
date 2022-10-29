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
    //调用这个实例来关闭初始窗口

    public static LoginGUI LogSurface;

    public static void main(String[] args) {
//        runLogGui();
        OperateGUI operateGUI = new OperateGUI();
    }

    static public void runLogGui() {
        LoginGUI loginGUI = new LoginGUI();
        LogSurface = loginGUI;
    }

}
