package Snake;


import settingsClass.SnakeSettingsSaveClass;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class RenderAndKeySnake extends Applet implements Runnable, KeyListener {

    MoveType moveType=MoveType.RIGHT;

    final int WIDTH=1200;
    final int HEIGHT=1200;
    GameSnake gameSnake;
    Image Screen;
    Graphics ScreenG;

    SnakeSettingsSaveClass snakeSettingsSaveClass;

    boolean showPath=false;

    boolean gameRun=false;

    BufferedImage bufferedImage;

    Thread thread;

    boolean isAi;

    public RenderAndKeySnake(boolean isAi) throws HeadlessException {
        this.isAi = isAi;
    }
    public RenderAndKeySnake(boolean isAi, SnakeSettingsSaveClass snakeSettingsSaveClass) throws HeadlessException {
        this.snakeSettingsSaveClass=snakeSettingsSaveClass;
        this.showPath=snakeSettingsSaveClass.isShowPatch();
        this.isAi=snakeSettingsSaveClass.isAi();
        this.isAi = isAi;
    }

    public  void init(){
        gameSnake=new GameSnake(snakeSettingsSaveClass.getMapSizeX(),snakeSettingsSaveClass.getMapSizeY());
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
        gameRun=true;
        while (gameRun){
            ScreenG.setColor(Color.BLACK);
            ScreenG.fillRect(0, 0, WIDTH, HEIGHT);
            if(isAi){
                gameSnake.gameAiLogic();
            }else {
                gameSnake.gameLogic();
            }

            gameSnake.draw(ScreenG);
            if(isAi&&showPath){
                gameSnake.drawPatch(ScreenG);
            }
            repaint();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("game close");
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_A){
            gameSnake.nextMove=MoveType.LEFT;
        }
       else if(e.getKeyCode()==KeyEvent.VK_W){
            gameSnake.nextMove=MoveType.UP;
        }
       else if(e.getKeyCode()==KeyEvent.VK_D){
            gameSnake.nextMove=MoveType.RIGHT;
        }
       else if(e.getKeyCode()==KeyEvent.VK_S){
            gameSnake.nextMove=MoveType.DOWN;
        }

    }

    public void keyReleased(KeyEvent e) {

    }


    public void closeGame(){

        gameRun=false;
    }

}
