package Flappy.Net;

import java.util.Random;

public class Net {
    Random random;


    double edge[][][];      //warstwa , po lewej , po prawej   a---b---c
    double node[][];        //kolumna ,wiersz

    public Net() {
        this.random=new Random();
        this.edge = new double[3][7][7];
        this.node = new double[4][7];
    }

    public Net(double[][][] edge, double[][] node) {
        this.edge = edge;
        this.node = node;
    }

    public void newRandomNet(){
    for(int i=0;i<3;i++){
        for (int t=0;t<7;t++){
            for (int k=0;k<7;k++){
                edge[i][t][k]=random.nextDouble()-0.5d;
            }
        }
    }
    }

    public double giveDecision(double[] input){
        for (int i=0;i<7;i++){
            node[0][i]=input[i];
        }
        return calculateEndNode();
    }

    private double calculateEndNode(){
        for(int i=0;i<7;i++){
            node[1][i]=sumForOneNode(1,i);
        }
        for(int i=0;i<7;i++){
            node[2][i]=sumForOneNode(2,i);
        }
        for(int i=0;i<7;i++){
            node[3][i]=sumForOneNode(3,i);
        }
    //    System.out.println(sumForOneNode(3,0));
        return sumForOneNode(3,0);
    }

    private double sumForOneNode(int x,int y){
        double sum=0.0d;
        for(int i=0;i<7;i++){
            sum=sum+node[x-1][i]*edge[x-1][i][y];
        }
        return sum;
    }

    public double[][][] nextGen(){
        double edgeNew[][][]=new double[3][7][7];
        double nodeNew[][]=new double[4][7];
        for(int i=0;i<3;i++){
            for (int t=0;t<7;t++){
                for (int k=0;k<7;k++){
                    edgeNew[i][t][k]=edge[i][t][k]+(random.nextDouble()-0.5d)*0.05;
                    if(edgeNew[i][t][k]>1){
                        edgeNew[i][t][k]=1;
                    }
                    if(edgeNew[i][t][k]<-1){
                        edgeNew[i][t][k]=-1;
                    }
                }
            }
        }
        return edgeNew;
    }

    public double[][][] getEdge() {
        return edge;
    }

    public void setEdge(double[][][] edge) {
        this.edge = edge;
    }
}
