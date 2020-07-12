package Flappy.Factories;


import Flappy.Camera;
import Flappy.ColisionCalculator;
import Flappy.GameObject.Bird;
import Flappy.Net.Net;

public class BirdFactory {
    int WIDTH;
    int HEIGHT;
    int centerY;

    float speedX=10;
    float speedY;

    float gravity=0.2f;
    float jumpStr=1;
    float startPosX=20;

    Camera camera;
    ColisionCalculator colisionCalculator;

    public BirdFactory(Camera camera, int centerY) {
        this.camera = camera;
        this.centerY = centerY;
    }
    public BirdFactory(Camera camera, int centerY, ColisionCalculator colisionCalculator) {
        this.colisionCalculator=colisionCalculator;
        this.camera = camera;
        this.centerY = centerY;
    }

    public Bird giveNewBird(){
        return new Bird(startPosX,centerY,speedX,speedY,true,false,jumpStr,gravity,colisionCalculator,0);
    }

    public void restartBird(Bird bird){
        bird.setScore(0);
        bird.setPositionX(startPosX);
        bird.setPositionY(centerY);
        bird.setSpeedY(speedY);
        bird.setAlive(true);
    }

    public Bird giveNewAiBird(){
        return new Bird(startPosX, centerY, speedX,speedY,true,true,jumpStr,gravity,colisionCalculator,new Net(),0);
    }


}
