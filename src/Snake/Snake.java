package Snake;

import java.util.ArrayList;

public class Snake {
    int growthCounter;

    int tailX;
    int tailY;

    boolean restart;

    public ArrayList<Point> getPointList() {
        return pointList;
    }

    private ArrayList<Point> pointList;
    Board board;


    public Snake(Board board) {
        this.board=board;
        pointList = new ArrayList<>();
        board.makeBoardEmpty();
        restart();
        board.makeFood();
    }

    private void restart(){
        pointList.clear();
        pointList.add(new Point(6,1));    //to ma indeks 0
        pointList.add(new Point(5,1));
        pointList.add(new Point(4,1));
        pointList.add(new Point(3,1));       //to ma indeks 3
        pointList.add(new Point(2,1));
        pointList.add(new Point(1,1));
        board.headX=pointList.get(0).x;
        board.headY=pointList.get(0).y;
        firstPaint();
        restart=true;
    }
    private void firstPaint(){
        for(int i=0;i<pointList.size()-1;i++){
            board.boardTab[pointList.get(i).x][pointList.get(i).y]=SnakeGameObject.SNAKE_BODY;
        }
    }

    public void makeMove(MoveType moveType) {
 //      System.out.println("głowa 0"+"X"+pointList.get(0).x+"Y"+pointList.get(0).y);
  //      System.out.println("ogon"+"X"+pointList.get(pointList.size()-1).x+"Y"+pointList.get(pointList.size()-1).y);

        tailX=pointList.get(pointList.size()-1).x;
        tailY=pointList.get(pointList.size()-1).y;
        board.boardTab[pointList.get(pointList.size()-1).x][pointList.get(pointList.size()-1).y]=SnakeGameObject.EMPTY_BOX;


        for(int i=pointList.size()-2;i>=0;i--){
       //     System.out.println(i);
            pointList.get(i+1).x=pointList.get(i).x;
            pointList.get(i+1).y=pointList.get(i).y;
        }

        System.out.println(pointList.size());
        if (moveType == MoveType.RIGHT) {

            pointList.get(0).x= (pointList.get(0).x+1+board.sizeX)%board.sizeX;
        } else if (moveType == MoveType.LEFT) {
            pointList.get(0).x= (pointList.get(0).x-1+board.sizeX)%board.sizeX;
        } else if (moveType == MoveType.UP) {
            pointList.get(0).y=(pointList.get(0).y-1+board.sizeY)%board.sizeY;
        } else if (moveType == MoveType.DOWN) {
            pointList.get(0).y=(pointList.get(0).y+1+board.sizeY)%board.sizeY;
        }


        if(board.boardTab[pointList.get(0).x%board.sizeX][pointList.get(0).y%board.sizeY]==SnakeGameObject.FOOD){
           // System.out.println("zjadlem" );
            board.makeFood();
            growthCounter++;
        }
        if(board.boardTab[pointList.get(0).x%board.sizeX][pointList.get(0).y%board.sizeY]==SnakeGameObject.SNAKE_BODY){
            board.makeBoardEmpty();
            restart();
            board.makeFood();
        }


        if(growthCounter!=0){
            pointList.add(new Point(tailX,tailY));
            board.boardTab[tailX][tailY]=SnakeGameObject.SNAKE_BODY;
            growthCounter--;
        }

        board.boardTab[pointList.get(1).x%board.sizeX][pointList.get(1).y%board.sizeY]=SnakeGameObject.SNAKE_BODY;
        board.boardTab[pointList.get(0).x%board.sizeX][pointList.get(0).y%board.sizeY]=SnakeGameObject.SNAKE_HEAD;


    }

    public int getHeadX(){
        return pointList.get(0).x;
    }
    public int getHeadY(){
        return pointList.get(0).y;
    }


}
