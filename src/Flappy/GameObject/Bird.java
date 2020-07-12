package Flappy.GameObject;

import Flappy.ColisionCalculator;
import Flappy.Net.Net;

public class Bird extends GameObject{


    private float PositionX;
    private float PositionY;

    private float SpeedX;
    private float SpeedY;

    private boolean isAlive;
    private boolean isAi;

    private double[] input;

    private float jumpStr;

    private float gravity;

    ColisionCalculator colisionCalculator;
    Net net;



    private float score;
//Ai
    public Bird(float positionX, float positionY, float speedX, float speedY, boolean isAlive, boolean isAi, float jumpStr, float gravity, ColisionCalculator colisionCalculator, Net net, float score) {
        PositionX = positionX;
        PositionY = positionY;
        SpeedX = speedX;
        SpeedY = speedY;
        this.input=new double[7];
        this.isAlive = isAlive;
        this.isAi = isAi;
        this.jumpStr = jumpStr;
        this.gravity = gravity;
        this.colisionCalculator = colisionCalculator;
        this.net = net;
        this.score = score;
    }
//human player
    public Bird(float positionX, float positionY, float speedX, float speedY, boolean isAlive, boolean isAi, float jumpStr, float gravity, ColisionCalculator colisionCalculator, float score) {
        PositionX = positionX;
        PositionY = positionY;
        SpeedX = speedX;
        SpeedY = speedY;
        this.isAlive = isAlive;
        this.isAi = isAi;
        this.jumpStr = jumpStr;
        this.gravity = gravity;
        this.colisionCalculator = colisionCalculator;
        this.score = score;
    }



    public void calculatePos() {
        if(!isAlive){
           SpeedY=0;
            PositionY=0;
        }
       SpeedY = SpeedY -gravity;
        PositionX = PositionX + SpeedX;
       PositionY = PositionY + SpeedY;
    }

    public void aiJump(){
        if(isAlive){
            if(net.giveDecision(giveInput())>20){
                jump();
            }
        }
    }

    public void jump() {
        if(isAlive){
           SpeedY = SpeedY + jumpStr;
        }
    }

    private double[] giveInput(){
        input[0]=PositionX-colisionCalculator.getNextObstacleX();
        input[1]=PositionY-colisionCalculator.getNextObstacleY();
        input[2]=SpeedY*100;
        input[3]=SpeedX;
        input[4]=0;
        input[5]=0;
        input[6]=0;
        //     System.out.println(input[0]+"input 2 "+input[2]);
        return input;
    }








    public Net getNet() {
        return net;
    }

    public void setNet(Net net) {
        this.net = net;
    }

    public float getPositionX() {
        return PositionX;
    }

    public void setPositionX(float positionX) {
        this.PositionX = positionX;
    }

    public float getPositionY() {
        return PositionY;
    }

    public void setPositionY(float positionY) {
        this.PositionY = positionY;
    }

    public float getSpeedX() {
        return SpeedX;
    }

    public void setSpeedX(float speedX) {
        this.SpeedX = speedX;
    }

    public float getSpeedY() {
        return SpeedY;
    }

    public void setSpeedY(float speedY) {
        this.SpeedY = speedY;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isAi() {
        return isAi;
    }

    public void setAi(boolean ai) {
        isAi = ai;
    }

    public float getJumpStr() {
        return jumpStr;
    }

    public void setJumpStr(float jumpStr) {
        this.jumpStr = jumpStr;
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
