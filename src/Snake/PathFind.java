package Snake;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathFind {

    //-4 allowed
    //0 start
    //-3 end point
    //-1 not allowed



    List<Point> toCheck=new ArrayList<>();

    int[][] matrix;
    int sizeX;
    int sizeY;
    int endX;
    int endY;

    public LinkedList<Point> givePath(int[][] matrix ,int startX,int startY,int endX,int endY,int sizeX,int sizeY){
        toCheck.clear();
        this.sizeX=sizeX;
        this.sizeY=sizeY;

        this.endX=endX;
        this.endY=endY;

        this.matrix=matrix;
        matrix[startX][startY]=0;
        matrix[endX][endY]=-3;

        Point temp;

        toCheck.add(new Point(startX,startY));

        while (toCheck.size()!=0){

           temp=toCheck.remove(0);
           makeCheck(temp);
        }

        for(int i=0;i<sizeX;i++){
            for (int t=0;t<sizeY;t++){
                System.out.print("|"+matrix[i][t]+"|");
            }
            System.out.println();
        }
      LinkedList<Point> moveList=  giveMoveList();
        for (Point point:moveList
             ) {
            System.out.println("x:"+point.x+"y"+point.y);
        }

        System.out.println("move index last X:= "+moveList.getLast().x+"Y:="+moveList.getLast().y);
        System.out.println("move index First X:= "+moveList.getFirst().x+"Y:="+moveList.getFirst().y);
        moveList.removeLast();//usuwamy miejsce gdzie snake juz jest
        return moveList;
    }


    private void makeCheck(Point point){
        int currentMove=matrix[point.x][point.y];


        if(currentMove<matrix[(point.x+1)%sizeX][point.y]-1||matrix[(point.x+1)%sizeX][point.y]==-4){
            matrix[(point.x+1)%sizeX][point.y]=currentMove+1;
            toCheck.add(new Point((point.x+1)%sizeX,point.y));
        }

        if(currentMove<matrix[(point.x-1+sizeX)%sizeX][point.y]-1||matrix[(point.x-1+sizeX)%sizeX][point.y]==-4){
            matrix[(point.x-1+sizeX)%sizeX][point.y]=currentMove+1;
            toCheck.add(new Point((point.x-1+sizeX)%sizeX,point.y));
        }

        if(currentMove<matrix[point.x][(point.y+1)%sizeY]-1||matrix[point.x][(point.y+1)%sizeY]==-4){
            matrix[point.x][(point.y+1)%sizeY]=currentMove+1;
            toCheck.add(new Point(point.x,(point.y+1)%sizeY));
        }

        if(currentMove<matrix[point.x][(point.y-1+sizeY)%sizeY]-1||matrix[point.x][(point.y-1+sizeY)%sizeY]==-4){
            matrix[point.x][(point.y-1+sizeY)%sizeY]=currentMove+1;
            toCheck.add(new Point(point.x,(point.y-1+sizeY)%sizeY));
        }



    }



private LinkedList<Point> giveMoveList(){

        LinkedList<Point> moveList=new LinkedList<>();

        moveList.add(new Point(endX,endY));

        boolean isDone=false;
        int min;
        Point temp;
        while (!isDone){
            min=100000;
            temp=moveList.getLast();

            if(matrix[(temp.x+1)%sizeX][temp.y]<min&&matrix[(temp.x+1)%sizeX][temp.y]>=0){
             min=matrix[(temp.x+1)%sizeX][temp.y];
            }

            if(matrix[(temp.x-1+sizeX)%sizeX][temp.y]<min&&matrix[(temp.x-1+sizeX)%sizeX][temp.y]>=0){
                min=matrix[(temp.x-1+sizeX)%sizeX][temp.y];
            }

            if(matrix[temp.x][(temp.y+1)%sizeY]<min&&matrix[temp.x][(temp.y+1)%sizeY]>=0){
                min=matrix[temp.x][(temp.y+1)%sizeY];
            }

            if(matrix[temp.x][(temp.y-1+sizeY)%sizeY]<min&&matrix[temp.x][(temp.y-1+sizeY)%sizeY]>=0){
                min=matrix[temp.x][(temp.y-1+sizeY)%sizeY];
            }

            if(matrix[(temp.x+1)%sizeX][temp.y]==min){
            moveList.add(new Point((temp.x+1)%sizeX,temp.y));
            }else  if(matrix[(temp.x-1+sizeX)%sizeX][temp.y]==min){
               moveList.add(new Point((temp.x-1+sizeX)%sizeX,temp.y));
            }else   if(matrix[temp.x][(temp.y+1)%sizeY]==min){
               moveList.add(new Point(temp.x,(temp.y+1)%sizeY));
            }else   if(matrix[temp.x][(temp.y-1+sizeY)%sizeY]==min){
               moveList.add(new Point(temp.x,(temp.y-1+sizeY)%sizeY));
            }
            if(min==0){
                isDone=true;
            }
            if(min==100000){
                moveList.add(new Point(0,0));
                isDone=true;
            }


        }
return moveList;

}


}
