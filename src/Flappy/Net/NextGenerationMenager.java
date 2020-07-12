package Flappy.Net;


import Flappy.GameObject.Bird;

import java.util.LinkedList;

public class NextGenerationMenager {

    LinkedList<Bird> birdLinkedList;
    LinkedList<Net> netLinkedList=new LinkedList<>();


    public NextGenerationMenager(LinkedList<Bird> birdLinkedList) {
        this.birdLinkedList = birdLinkedList;
    }

    public void makeNextGen(){                  //zakladam 50
        birdLinkedList.sort(this::compar);
        System.out.println( "the best "+birdLinkedList.getFirst().getScore());

        System.out.println( "the worst "+birdLinkedList.getLast().getScore());

        if(birdLinkedList.getFirst().getScore()<1000){
            for (Bird bird :birdLinkedList
                    ) {
                bird.getNet().newRandomNet();
            }
        }else {
            for(int i=0;i<10;i++){
                netLinkedList.add(birdLinkedList.get(i).getNet());
            }

            for (int i=0;i<birdLinkedList.size();i++){
                if(i>10) {
                    birdLinkedList.get(i).getNet().setEdge(netLinkedList.get(0).nextGen());
                }
            }
            netLinkedList.clear();
        }

    }

    public int compar(Bird b1,Bird b2){
        if(b1.getScore()>b2.getScore()){
            return 1;
        }else if(b1.getScore()<b2.getScore()) {
            return -1;
        }else {
            return 0;
        }
    }



}
