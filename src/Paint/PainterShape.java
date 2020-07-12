package Paint;


import Flappy.Camera;

import java.awt.*;

public class PainterShape {
    Camera camera;
    int height=900;

    public PainterShape() {

    }

    public PainterShape(Camera camera) {
        this.camera = camera;
    }

    public void paintRectangleTopDown(Graphics g, Color color, int posX, int posY, int w, int h) {
    //    g.setColor(color);
        g.setColor(Color.RED);
        g.fillRect(posX-w/2-camera.cameraPosX, height-(posY), w,h);
    }

    public void paintRectangleDownTop(Graphics g,Color color,int posX,int posY,int w,int h) {
     //   g.setColor(color);
        g.setColor(Color.GREEN);
        g.fillRect(posX-w/2-camera.cameraPosX, height-(posY+h), w,h);
    }

    public void paintRectangleCenter(Graphics g,Color color,int posX,int posY,int w,int h) {
       g.setColor(color);
        g.fillRect(posX-w/2-camera.cameraPosX, height-(posY+h/2), w,h);
    }

    public void obstacle(Graphics g,Color color,int posX,int posY,int w,int h,int gape) {
        paintRectangleDownTop(g,color,posX,posY+gape/2,w,h);
        paintRectangleTopDown(g,color,posX,posY-gape/2,w,h);
     // paintRectangleCenter(g,Color.GREEN,posX,posY,10,10);
    }


    public void paintSnakeHead(Graphics g,int posX,int posY,int w,int h){
        g.setColor(Color.BLUE);
        g.fillRect(posX*20, posY*20, w-1,h-1);
    }

    public void paintSnakeBody(Graphics g,int posX,int posY,int w,int h){
        g.setColor(Color.GREEN);
        g.fillRect(posX*20, posY*20, w-1,h-1);
    }

    public void paintSnakeEmptyBox(Graphics g,int posX,int posY,int w,int h){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(posX*20, posY*20, w-1,h-1);
    }

    public void paintSnakeFood(Graphics g,int posX,int posY,int w,int h){
        g.setColor(Color.RED);
        g.fillRect(posX*20, posY*20, w-1,h-1);
    }

    public void paintPath(Graphics g,int posX,int posY,int w,int h){
        g.setColor(Color.YELLOW);
        g.fillRect(posX*20, posY*20, w-1,h-1);
    }


}
