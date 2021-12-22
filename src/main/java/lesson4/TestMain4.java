package lesson4;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class TestMain4 {

    public static void main(String[] args) {
        testSimpleLinkedListImplIterator();
        SimpleDeque<Integer> deque = new SimpleDeque<>();
        deque.insertRight(3);
        deque.insertRight(4);
        deque.insertRight(15);
        System.out.println(deque);

        deque.removeLeft();
        System.out.println(deque);

        deque.insertRight(5);
        deque.insertRight(8);
        System.out.println(deque);

        deque.insertLeft(14);
        deque.insert(100, 5);
        deque.insert(101, 0);
        System.out.println(deque);


        System.out.println("first=" + deque.first + ", last=" + deque.last);
        for (Integer i : deque)
            System.out.print(i + " ");
        System.out.println();
        deque.insertLeft(14);
        System.out.println(deque);
    }

    private static void testLinkedList() {

        TwoSideLinkedList<Integer> linkedList = new TwoSideLinkedListImpl<>();

        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);
        linkedList.insertLast(9);
        linkedList.insertLast(10);
        linkedList.insertLast(11);

        linkedList.display();

        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));
//
        linkedList.removeFirst();
        linkedList.remove(4);
//
        linkedList.display();

    }

    private static void testSimpleLinkedListImplIterator() {
        //ДОЛЖНО РАБОТАТЬ!

        SimpleLinkedListImpl<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst(2);
        linkedList.insertFirst(5);
        linkedList.insertFirst(3);
        linkedList.insertFirst(1);
        linkedList.insertFirst(8);
        linkedList.insertFirst(4);
        linkedList.insertFirst(10);
        for (Integer value : linkedList) {
            System.out.println("value: " + value);
        }
    }


    private static void testIterator() {
        List<Integer> linkedList = new LinkedList<>();
        Collections.addAll(linkedList, 1, 2, 3, 4, 5, 6, 7, 8, 9);

/*        for (Integer integer : linkedList) {
            System.out.println(integer);
        }*/

        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            //first: reset
            Integer integer = iterator.next();
            System.out.println(integer);
        }

    }
}
