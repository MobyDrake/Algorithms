package Algorithms.lesson4.test;

import Algorithms.lesson4.linkedList.LinkedList;
import Algorithms.lesson4.linkedList.SimpleLinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleLinkedListTest {
    private LinkedList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new SimpleLinkedList<>();
    }

    @Test
    public void insertFirst() {
        list.insertFirst(1);
        list.insertFirst(2);

        assertEquals(2, (int) list.removeFirst());
    }

    @Test
    public void removeFirst() {
        list.insertFirst(1);
        list.insertFirst(2);

        assertEquals(2, (int) list.removeFirst());
    }

    @Test
    public void remove() {
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);

        assertTrue(list.remove(2));
        assertFalse(list.remove(5));

        assertFalse(list.contains(2));
    }

    @Test
    public void contains() {
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);

        assertTrue(list.contains(3));
        assertFalse(list.contains(5));
    }
}