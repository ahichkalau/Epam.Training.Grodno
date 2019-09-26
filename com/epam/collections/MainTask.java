package com.epam.collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainTask {
    public static void main(String[] args) {
        MainTask mainTask = new MainTask();
        mainTask.CircleInArrayList();
        mainTask.CircleInLinkedList();
    }
    public void CircleInArrayList(){
        long startTime = System.currentTimeMillis();
        ArrayList circleInArray = new ArrayList<Integer>();
        int peapleInCircle = 100000;
        ArrayList circleInArraySecond = new ArrayList<Integer>();
        for (int i = 1; i <= peapleInCircle; i++) {
            circleInArray.add(i);
        }

        for (int i = 0; i <= circleInArray.size(); i++) {
            circleInArraySecond.clear();
            for (int j = 1; j < circleInArray.size(); j = j + 2) {
                circleInArraySecond.add(circleInArray.get(j));
            }
            circleInArray.removeAll(circleInArraySecond);
            if (i == 2){
                i--;
            }
        }
        System.out.println(circleInArray);
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("ArrayList " + timeSpent);
    }

    public void CircleInLinkedList(){
        long startTime = System.currentTimeMillis();
        LinkedList circleInLinkedList = new LinkedList<Integer>();
        int peapleInCircle = 10000;
        LinkedList circleInLinkedListSecond = new LinkedList<Integer>();
        for (int i = 1; i <= peapleInCircle; i++) {
            circleInLinkedList.add(i);
        }

        for (int i = 0; i <= circleInLinkedList.size(); i++) {
            circleInLinkedListSecond.clear();
            for (int j = 1; j < circleInLinkedList.size(); j = j + 2) {
                circleInLinkedListSecond.add(circleInLinkedList.get(j));
            }
            circleInLinkedList.removeAll(circleInLinkedListSecond);
            if (i == 2){
                i--;
            }
        }
        System.out.println(circleInLinkedList);
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("LinkedList " + timeSpent);
    }
}
