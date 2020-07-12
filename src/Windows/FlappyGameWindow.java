package Windows;

import Flappy.RenderAndKey;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FlappyGameWindow extends JFrame {
WindowListener windowListener;
int choose;

    public FlappyGameWindow(int choose) throws HeadlessException {
        this.choose=choose;
        initComponents();
    }



    private void initComponents() {


        applet=new RenderAndKey(choose);

        jPanel1 = new javax.swing.JPanel();
        playFlappyButton = new javax.swing.JButton();
        playPongButton = new javax.swing.JButton();
        flappyAiButton = new javax.swing.JButton();
        pongAiButton = new javax.swing.JButton();
        flappySettingButton = new javax.swing.JButton();
        pongSettingsButton = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        makeWindowsLissiner();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);


        add(jPanel1);
        addWindowListener(windowListener);
        jPanel1.setSize(1200,900);
        setSize(1200,900);
        jPanel1.add(applet);
        applet.setVisible(true);
        applet.init();

    }// </editor-fold>

    private  void makeWindowsLissiner() {
       windowListener = new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                ((RenderAndKey)applet).closeGame();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        };
    }










    private javax.swing.JButton flappyAiButton;
    private javax.swing.JButton flappySettingButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton playFlappyButton;
    private javax.swing.JButton playPongButton;
    private javax.swing.JButton pongAiButton;
    private javax.swing.JButton pongSettingsButton;
    private Applet applet;


}
