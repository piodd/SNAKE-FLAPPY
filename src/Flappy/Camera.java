package Flappy;

public class Camera {
    public int cameraPosX;
    private int startPosX;

    private int speedX;
    public Camera(int cameraPosX) {
        this.cameraPosX = cameraPosX;
        this.startPosX=cameraPosX;
    }

    public Camera(int cameraPosX, int speedX) {
        this.cameraPosX = cameraPosX;
        this.speedX = speedX;
    }

    public void restart(){
        cameraPosX=startPosX;
    }

    public void calculatePos(){
        cameraPosX=cameraPosX+speedX;
    }
}
