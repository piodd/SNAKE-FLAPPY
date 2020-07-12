package Flappy;



import Flappy.Factories.BirdFactory;
import Flappy.Factories.ObstacleFactory;
import Flappy.GameObject.Bird;
import Flappy.GameObject.Obstacle;
import Flappy.Net.NextGenerationMenager;
import Paint.PainterShape;

import java.awt.*;
import java.util.LinkedList;

public class GameFlappy {

    ColisionCalculator colisionCalculator;

    private NextGenerationMenager nextGenerationMenager;

    boolean playerJump = false;

    Camera camera;


    int WIDTH;
    int HEIGHT;
    int centerY;
    int gape;
    ObstacleFactory obstacleFactory;
    BirdFactory birdFactory;
    PainterShape painterShape;

    boolean isStart=true;
    boolean isAiGame=false;


    LinkedList<Obstacle> obstacleLinkedList = new LinkedList<>();

    LinkedList<Bird> birdList = new LinkedList<>();



    public GameFlappy(int WIDTH, int HEIGHT, int numberOFAi) {
        this.isAiGame=true;
        this.gape = 150;
        this.camera = new Camera(0);
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.centerY = HEIGHT / 2 - 100;
        this.obstacleFactory = new ObstacleFactory(camera, 700, HEIGHT);
        this.colisionCalculator = new ColisionCalculator(birdList, obstacleLinkedList, camera, gape);
        this.birdFactory = new BirdFactory(camera, centerY,colisionCalculator);
        startAi(numberOFAi);
        this.painterShape = new PainterShape(camera);
        this.nextGenerationMenager=new NextGenerationMenager(birdList);
    }

    public GameFlappy(int WIDTH, int HEIGHT) {
        this.gape = 150;
        this.camera = new Camera(0);
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.centerY = HEIGHT / 2 - 100;
        this.obstacleFactory = new ObstacleFactory(camera, 700, HEIGHT);
        this.birdFactory = new BirdFactory(camera, centerY);
        start();
        this.colisionCalculator = new ColisionCalculator(birdList, obstacleLinkedList, camera, gape);
        this.painterShape = new PainterShape(camera);
    }

    private void start() {

        for (int i = 0; i < 10; i++) {
            obstacleLinkedList.add(obstacleFactory.giveRandomObstacle());
        }
        birdList.add(birdFactory.giveNewBird());
    }

    public void gameLogic() {
     if(isAiGame){
        aiGameLogic();
     }else {
         humanGameLogic();
     }
    }

    public void draw(Graphics g) {
        int t=0;
        painterShape.paintRectangleDownTop(g, Color.RED, camera.cameraPosX, 0, 20, 150);
        for (Obstacle x : obstacleLinkedList
        ) {
            painterShape.obstacle(g, Color.WHITE, (int) x.getPositionX(), (int) x.getPositionY(), 20, 400, gape);
        }
        for (Bird bird : birdList
        ) {
            if(bird.isAlive()){
                t++;
            }
            painterShape.paintRectangleCenter(g, Color.BLUE, (int) bird.getPositionX(), (int) bird.getPositionY(), 20, 20);
        }
        System.out.println("jest ich "+t);
    }

    private void calculateObstaclePos() {
        for (int i = 0; i < obstacleLinkedList.size(); i++) {
            if (obstacleLinkedList.get(i).getPositionX() < camera.cameraPosX - 150) {
                obstacleFactory.giveNewRandomPos(obstacleLinkedList.get(i));
            }
        }

    }

    public void setPlayerJump(boolean playerJump) {
        this.playerJump = playerJump;
    }

    private void calculateBirdPosition() {
        for (Bird x : birdList
        ) {
                x.calculatePos();
        }
    }

    private boolean isOver() {

        for (int i = 0; i < birdList.size(); i++) {
            if (birdList.get(i).isAlive()) {
                return false;
            }
        }
        return true;
    }

    private void restart() {
        obstacleFactory.restart();
        for (int i = 0; i < obstacleLinkedList.size(); i++) {
            obstacleFactory.giveNewRandomPos(obstacleLinkedList.get(i));
        }
        for (int i = 0; i < birdList.size(); i++) {
            birdFactory.restartBird(birdList.get(i));
        }
        colisionCalculator.restart();

        camera.restart();
    }

    private void restartAi() {
        obstacleFactory.restart();
        nextGenerationMenager.makeNextGen();
        for (int i = 0; i < obstacleLinkedList.size(); i++) {
            obstacleFactory.giveNewRandomPos(obstacleLinkedList.get(i));
        }
        for (int i = 0; i < birdList.size(); i++) {
            birdFactory.restartBird(birdList.get(i));
        }
        colisionCalculator.restart();

        camera.restart();
    }

    private void humanGameLogic(){
        if (isOver()) {
            System.out.println("OVERRR");
            restart();
        }
        if (playerJump == true) {
            birdList.get(0).jump();
        }
        colisionCalculator.calculateColision();
        calculateBirdPosition();
        calculateObstaclePos();
        camera.cameraPosX = (int) birdList.get(0).getPositionX() - 50;
    }
int cameraCheck=0;
    private void aiGameLogic(){
        cameraCheck=0;
        if (isOver()) {
            System.out.println("OVERRR");
            restartAi();
        }
        for (Bird bird: birdList
             ) {
            bird.aiJump();
        }
        colisionCalculator.calculateColision();
        calculateBirdPosition();
        calculateObstaclePos();
        camera.cameraPosX = (int) birdList.get(0).getPositionX() - 50;
    }

    private void startAi(int x) {
        for (int i = 0; i < 10; i++) {
            obstacleLinkedList.add(obstacleFactory.giveRandomObstacle());
        }
        for(int i=0;i<x;i++){
            birdList.add(birdFactory.giveNewAiBird());
        }
    }




}
