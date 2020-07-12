package Flappy;

import Windows.MenuWindow;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Scanner;

public class RenderAndKey extends Applet implements Runnable, KeyListener {

    MenuWindow menuWindow;

    final int WIDTH=1200;
    final int HEIGHT=900;
    GameFlappy gameFlappy;
    Image Screen;
    Graphics ScreenG;

    boolean gameRun=false;
    int choose=-1;

    BufferedImage bufferedImage;
    Graphics graphics;

    Scanner scanner=new Scanner(System.in);
Thread thread;

    public RenderAndKey(int i) {
        choose=i;
    }

    public boolean isGameRun() {
        return gameRun;
    }

    public void setGameRun(boolean gameRun) {
        this.gameRun = gameRun;
    }

    public int getChoose() {
        return choose;
    }

    public void setChoose(int choose) {
        this.choose = choose;
    }

    public  void init(){
        while (choose==-1){
            System.out.println("czekam");
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gameRun=true;
        if(choose==1){
            gameFlappy =new GameFlappy(WIDTH,HEIGHT);
        }else {
           gameFlappy =new GameFlappy(WIDTH,HEIGHT,50);
        }
        Screen=createImage(WIDTH,HEIGHT);

        bufferedImage=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_BYTE_INDEXED);
        ScreenG=bufferedImage.getGraphics();

        this.resize(WIDTH,HEIGHT);

        this.addKeyListener(this);
        thread=new Thread(this);
        thread.start();
    }

    public void  paint(Graphics g){
           g.drawImage(bufferedImage,0,0,this);
    }

    public void update(Graphics g){
        paint(g);
    }

    public void run() {
            while (gameRun){
                ScreenG.setColor(Color.BLACK);
                ScreenG.fillRect(0, 0, WIDTH, HEIGHT);
                gameFlappy.gameLogic();
                gameFlappy.draw(ScreenG);

                repaint();
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){
            gameFlappy.setPlayerJump(true);
        }
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
            gameRun=false;
        }

    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){
            gameFlappy.setPlayerJump(false);
        }
    }


    public void closeGame(){
        gameRun=false;
    }

}
