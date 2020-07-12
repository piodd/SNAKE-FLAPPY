package Windows;


import Snake.RenderAndKeySnake;
import settingsClass.MyBoolean;
import settingsClass.SnakeSettingsSaveClass;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

    public class SnakeGameWindow extends JFrame {
        SnakeSettingsSaveClass snakeSettingsSaveClass;

        WindowListener windowListener;
        int choose;
        boolean isAi;
        int WIDTH=1020;
        int HEIGHT=1040;

//1 human
        //2 ai
        public SnakeGameWindow(int choose) throws HeadlessException {
            this.choose=choose;
            if(choose==1){
                this.isAi=false;
            }
            if(choose==2){
                this.isAi=true;
            }
            initComponents();
        }
        private boolean showPatch;
        public SnakeGameWindow(int choose, MyBoolean showPatch) throws HeadlessException {
            this.choose=choose;
            if(choose==1){
                this.isAi=false;
            }
            if(choose==2){
                this.isAi=true;
            }
            this.showPatch=showPatch.getBoolean();
            System.out.println(this.showPatch);
            initComponents();
        }

        public SnakeGameWindow(int choose, SnakeSettingsSaveClass snakeSettingsSaveClass) {
            this.choose=choose;
            if(choose==1){
                this.isAi=false;
            }
            if(choose==2){
                this.isAi=true;
            }
            this.snakeSettingsSaveClass=snakeSettingsSaveClass.giveCopy();
            initComponents();
        }


        private void initComponents() {

            applet=new RenderAndKeySnake(isAi,snakeSettingsSaveClass);

            jPanel1 = new javax.swing.JPanel();


            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            makeWindowsLissiner();

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);


            add(jPanel1);
            addWindowListener(windowListener);
            jPanel1.setSize(WIDTH,HEIGHT);
            setSize(WIDTH,HEIGHT);
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
                    ((RenderAndKeySnake)applet).closeGame();
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










        private javax.swing.JPanel jPanel1;

        private Applet applet;


    }

