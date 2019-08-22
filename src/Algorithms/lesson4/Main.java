package Algorithms.lesson4;

import Algorithms.lesson4.linkedList.LinkedList;
import Algorithms.lesson4.linkedList.SimpleLinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new SimpleLinkedList<>();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}
