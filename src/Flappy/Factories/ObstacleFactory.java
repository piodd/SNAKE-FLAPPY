package Flappy.Factories;



import Flappy.Camera;
import Flappy.GameObject.Obstacle;

import java.util.Random;

public class ObstacleFactory {
    Camera camera;
    Random random = new Random();
    int gape=150;
    int height;
    int size=300;


    int lastXPos = 0;

    public ObstacleFactory(Camera camera, int gape, int HEIGHT) {
        this.gape = gape;
        this.height = HEIGHT;
        this.camera = camera;
    }

    public Obstacle giveRandomObstacle() {
        lastXPos = lastXPos + gape;
        return new Obstacle(lastXPos, randomY(),gape,size);
    }
    public Obstacle giveRandomStatic(){
        lastXPos = lastXPos + gape;
        return new Obstacle(lastXPos, height / 2,gape,size);
    }

    public void giveNewPosForObstacle(Obstacle obstacle) {
        lastXPos = lastXPos + gape;
        obstacle.setPositionX(lastXPos);
        obstacle.setPositionY(height / 2);
    }

    public void giveNewRandomPos(Obstacle obstacle){
        lastXPos = lastXPos + gape;
        obstacle.setPositionX(lastXPos);
        obstacle.setPositionY(randomY());
    }

    public void restart(){
        lastXPos=0;
    }

    private int randomY(){
        return height/2+random.nextInt(height/3)-height/6;
    }


}
