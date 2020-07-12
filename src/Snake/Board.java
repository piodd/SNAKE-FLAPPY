package Snake;

import java.util.Random;

public class Board {

    SnakeGameObject[][] boardTab;
    Random random=new Random();

    int sizeX;
    int sizeY;


    public Board(int sizeX,int sizeY) {
        this.sizeX=sizeX;
        this.sizeY=sizeY;
        this.boardTab=new SnakeGameObject[sizeX][sizeY];
        this.headX=sizeX/2;
        this.headY=sizeY/2;
        this.tailX=headX-5;
        this.tailY=headY;
        restart();
    }



    int headX;
    int headY;

    int tailX;
    int tailY;


    public void restart(){
        makeBoardEmpty();
        makeFood();
    }

    public void makeBoardEmpty(){
        for(int i=0;i<sizeX;i++){
            for (int t=0;t<sizeY;t++){
                boardTab[i][t]=SnakeGameObject.EMPTY_BOX;
            }
        }
    }
    int foodX;
    int foodY;

    public void makeFood(){
        random.nextInt(sizeX*sizeY);
        int tempX=random.nextInt(sizeX);
        int tempY=random.nextInt(sizeY);
        while (boardTab[tempX][tempY]!=SnakeGameObject.EMPTY_BOX){
           // System.out.println(boardTab[tempX][tempY]);
            tempX=random.nextInt(sizeX);
            tempY=random.nextInt(sizeY);
        }
            boardTab[tempX][tempY]=SnakeGameObject.FOOD;
            foodX=tempX;
            foodY=tempY;

    }


}
