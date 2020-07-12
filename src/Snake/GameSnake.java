package Snake;

import Paint.PainterShape;

import java.awt.*;
import java.util.LinkedList;

public class GameSnake {


    PainterShape painterShape;
    Snake snake;

    PathFind pathFind = new PathFind();


    Board gameBoard;
    MoveType nextMove = MoveType.RIGHT;
    MoveType currentMove = MoveType.RIGHT;

    private boolean showPath=false;

    int headX;
    int headY;

    public GameSnake() {
        painterShape = new PainterShape();
        gameBoard = new Board(50, 50);
        snake = new Snake(gameBoard);
    }


    public GameSnake(int mapSizeX, int mapSizeY) {
        painterShape = new PainterShape();
        gameBoard = new Board(mapSizeX, mapSizeY);
        snake = new Snake(gameBoard);
    }

    public void gameLogic() {
        if (isPosible()) {
            currentMove = nextMove;
        }
        calculateSnakePosition();
    }

    public void gameAiLogic() {
        if(snake.restart==true){
            this.patch.clear();
            snake.restart=false;
        }
        if (patch.size() == 0) {
            calculatePatch();
        }
        nextAiMove();
    //    calculateSnakePosition();

    }

    private LinkedList<Point> patch = new LinkedList<>();

    public void calculatePatch() {
        int matrix[][] = new int[gameBoard.sizeX][gameBoard.sizeY];
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;

        for (int i = 0; i < gameBoard.sizeX; i++) {
            for (int t = 0; t < gameBoard.sizeY; t++) {
                if (gameBoard.boardTab[i][t] == SnakeGameObject.EMPTY_BOX) {
                    matrix[i][t] = -4;
                } else if (gameBoard.boardTab[i][t] == SnakeGameObject.SNAKE_BODY) {
                    matrix[i][t] = -1;
                } else if (gameBoard.boardTab[i][t] == SnakeGameObject.SNAKE_HEAD) {
                    headX = i;
                    headY = t;
                    matrix[i][t] = -1;
                } else if (gameBoard.boardTab[i][t] == SnakeGameObject.FOOD) {
                 //   matrix[i][t]=-3;
                }


            }
        }

        endX=gameBoard.foodY;
        startX=snake.getHeadX();
        startY=snake.getHeadY();
        System.out.println("start X"+startX+gameBoard.headX);
        endX=gameBoard.foodX;
        endY=gameBoard.foodY;
        this.patch = pathFind.givePath(matrix, startX, startY, endX, endY, gameBoard.sizeX, gameBoard.sizeY);

    }

    private void nextAiMove() {
        System.out.println("rozmiar listy"+patch.size());
        currentMove=MoveType.RIGHT;
        headX=snake.getHeadX();
        headY=snake.getHeadY();
        Point temp = patch.removeLast();
        if(gameBoard.boardTab[temp.x][temp.y]==SnakeGameObject.FOOD){
            System.out.println("jest tu jedzene ");
        }
        if (temp.x == (headX + 1) % gameBoard.sizeX) {
       //     headX=(headX+1)%gameBoard.sizeX;
            currentMove = MoveType.RIGHT;
        } else if (temp.x == (headX - 1 + gameBoard.sizeX) % gameBoard.sizeX) {
        //    headX=(headX-1+gameBoard.sizeX)%gameBoard.sizeX;
            currentMove = MoveType.LEFT;
        } else if (temp.y == (headY + 1) % gameBoard.sizeY) {
        //    headY=(headY+1)%gameBoard.sizeY;                      //bo Y sa odwrotnie
            currentMove = MoveType.DOWN;
        } else if (temp.y == (headY - 1 + gameBoard.sizeY) % gameBoard.sizeY) {
       //     headY=(headY-1+gameBoard.sizeY)%gameBoard.sizeY;
            currentMove = MoveType.UP;
        }else if(true){
            System.out.println("nic nie wybrał LOL ");
        }
        snake.makeMove(currentMove);


    }


    private void calculateSnakePosition() {
        snake.makeMove(currentMove);
    }


    private boolean isPosible() {
        if (nextMove == MoveType.LEFT && currentMove == MoveType.RIGHT) {
            return false;
        }
        if (nextMove == MoveType.RIGHT && currentMove == MoveType.LEFT) {
            return false;
        }
        if (nextMove == MoveType.UP && currentMove == MoveType.DOWN) {
            return false;
        }
        if (nextMove == MoveType.DOWN && currentMove == MoveType.UP) {
            return false;
        }
        return true;
    }

    public void draw(Graphics g) {
        for (int i = 0; i < gameBoard.sizeX; i++) {
            for (int t = 0; t < gameBoard.sizeY; t++) {
                drawElement(g, gameBoard.boardTab[i][t], i, t);
            }
        }


    }

    private void drawElement(Graphics g, SnakeGameObject snakeGameObject, int x, int y) {
        if (snakeGameObject == SnakeGameObject.SNAKE_BODY) {
            painterShape.paintSnakeBody(g, x, y, 20, 20);
        } else if (snakeGameObject == SnakeGameObject.SNAKE_HEAD) {
            painterShape.paintSnakeHead(g, x, y, 20, 20);
        } else if (snakeGameObject == SnakeGameObject.FOOD) {
            painterShape.paintSnakeFood(g, x, y, 20, 20);
        } else if (snakeGameObject == SnakeGameObject.EMPTY_BOX) {
            painterShape.paintSnakeEmptyBox(g, x, y, 20, 20);
        }
    }


    public void drawPatch(Graphics g) {
            for (Point point:patch
            ) {
                painterShape.paintPath(g,point.x,point.y,20,20);
            }
        if(patch.size()>0){
            if(gameBoard.boardTab[patch.getFirst().x][patch.getFirst().y]==SnakeGameObject.FOOD){
                painterShape.paintSnakeFood(g,patch.getFirst().x,patch.getFirst().y,20,20);
            }
        }
    }
}
