package Flappy;


import Flappy.GameObject.Bird;
import Flappy.GameObject.Obstacle;

import java.util.LinkedList;

public class ColisionCalculator {
    LinkedList<Bird> birds;
    LinkedList<Obstacle> obstacles;
    Camera camera;

    float nextObstacleX;
    float nextObstacleY;
    int nextObstacleIndex;



    float range;


    public ColisionCalculator(LinkedList<Bird> birds, LinkedList<Obstacle> obstacles, Camera camera, int gape) {
        this.range = 100;
        this.birds = birds;
        this.obstacles = obstacles;
        this.camera = camera;
        this.nextObstacleX = gape;
        this.nextObstacleY=450;
        this.range=gape;

    }

    public void restart(){
        nextObstacleIndex = 0;
        nextObstacleX = obstacles.get(nextObstacleIndex).getPositionX();
        nextObstacleY = obstacles.get(nextObstacleIndex).getPositionY();
    }

    public void calculateColision() {
        newObstacle();
        if (Math.abs(nextObstacleX-50-camera.cameraPosX) < 10) {
            System.out.println("roznica"+(birds.get(0).getPositionX()-camera.cameraPosX));
            for (Bird bird : birds
            ) {
                if (colisionCheck(bird)) {
                    bird.setAlive(false);
                }
            }
        }

    }

    private boolean colisionCheck(Bird bird) {
        if ( Math.abs(bird.getPositionY() - nextObstacleY) > range/2 ) {
            return true;
        }
        return false;
    }

    private void newObstacle() {
        if (nextObstacleX < camera.cameraPosX - 30) {
            nextObstacleIndex = (nextObstacleIndex + 1) % (obstacles.size());
            nextObstacleX = obstacles.get(nextObstacleIndex).getPositionX();
            nextObstacleY = obstacles.get(nextObstacleIndex).getPositionY();
        }
    }
    public float getNextObstacleX() {
        return nextObstacleX;
    }

    public void setNextObstacleX(float nextObstacleX) {
        this.nextObstacleX = nextObstacleX;
    }

    public float getNextObstacleY() {
        return nextObstacleY;
    }

    public void setNextObstacleY(float nextObstacleY) {
        this.nextObstacleY = nextObstacleY;
    }


}
