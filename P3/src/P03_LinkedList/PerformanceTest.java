package P03_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class implements a LinkedList for the ADS module @ ZHAW
 *
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 * @author Lawrence Markwalder <markwlaw@students.zhaw.ch>
 * @author Luca Egli <eglilu01@students.zhaw.ch>
 */
class PerformanceTest {
    private static final int LIST_LENGTH = 50000;
    private static final int INDEX = 1;

    public static void main(String[] args) {
        long startTime = 0;
        long endTime = 0;

        MyLinkedList<Integer> mylist = new MyLinkedList<>();
        ArrayList<Integer> arraylist = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
///*
        System.out.println("Testing MyLinkedList:");
        startTime = System.currentTimeMillis();
        addElementsToMyList(LIST_LENGTH,mylist);
        //removeElementsFromMyList(INDEX,mylist);
        endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
//*/
/*
        System.out.println("Testing ArrayList:");
        addElementsToArrayList(LIST_LENGTH,arraylist);
        startTime = System.currentTimeMillis();
        removeElementsFromArrayList(INDEX,arraylist);
        endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
*/
/*
        System.out.println("Testing LinkedList:");
        addElementsToLinkedList(LIST_LENGTH,linkedList);
        startTime = System.currentTimeMillis();
        removeElementsFromLinkedList(INDEX,linkedList);
        endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
  */
    }

    private static void addElementsToArrayList(int numberOfElements, List list) {
        for (int i = 0;i<numberOfElements;i++) {
            list.add(i);
        }
    }

    private static void addElementsToLinkedList(int numberOfElements, LinkedList list) {
        for (int i = 0;i<numberOfElements;i++) {
            list.addLast(i);
        }
    }
    private static void addElementsToMyList(int numberOfElements,MyLinkedList list) {
        for (int i = 0;i<numberOfElements;i++) {
            list.addLast(i);
        }
    }

    private static void getElementsFromArrayList(int indexOfElement, List list) {
        list.get(indexOfElement);
    }

    private static void getElementsFromLinkedList(int indexOfElement, LinkedList list) {
        list.get(indexOfElement);
    }
    private static void getElementsFromMyList(int indexOfElement,MyLinkedList list) {
        list.get(indexOfElement);
    }

    private static void removeElementsFromArrayList(int indexOfElement, List list) {
        list.remove(indexOfElement);
    }

    private static void removeElementsFromLinkedList(int indexOfElement, LinkedList list) {
        list.remove(indexOfElement);
    }
    private static void removeElementsFromMyList(int indexOfElement,MyLinkedList list) {
        list.remove(indexOfElement);
    }
}
