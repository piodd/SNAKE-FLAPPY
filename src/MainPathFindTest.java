import Snake.PathFind;

public class MainPathFindTest {
    public static void main(String[] args) {
        PathFind pathFind=new PathFind();


        int[][] matrix=new int[5][5];

        for(int i=0;i<5;i++){
            for (int t=0;t<5;t++){
                matrix[i][t]=-4;
            }
        }
        matrix[1][3]=-1;
        matrix[2][3]=-1;
        matrix[3][3]=-1;
        matrix[4][3]=-1;
        matrix[1][0]=-1;
        matrix[2][0]=-1;
        matrix[3][0]=-1;
        matrix[4][0]=-1;
        pathFind.givePath(matrix,1,1,4,4,5,5);


    }
}
