package Flappy.GameObject;

public class Obstacle extends GameObject {

    private float posX;
    private float posY;

    private int gape;

    private int size;


    public Obstacle(float posX, float posY, int gape, int size) {
        this.posX = posX;
        this.posY = posY;
        this.gape = gape;
        this.size = size;
    }

    @Override
    public float getPositionX() {
        return posX;
    }

    @Override
    public float getPositionY() {
        return posY;
    }

    @Override
    public void setPositionX(float positionX) {
        this.posX = positionX;
    }

    @Override
    public void setPositionY(float positionY) {
        this.posY = positionY;
    }
}
