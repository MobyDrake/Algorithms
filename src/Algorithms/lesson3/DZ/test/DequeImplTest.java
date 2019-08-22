package Algorithms.lesson3.DZ.test;

import Algorithms.lesson3.deque.Deque;
import Algorithms.lesson3.deque.DequeImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DequeImplTest {

    private Deque<Integer> deque;

    @Before
    public void setUp() throws Exception {
        deque = new DequeImpl<>(6);

        deque.insertRight(3);
        deque.insertRight(4);
    }

    @Test
    public void insertLeft() {

        deque.insertLeft(2);
        deque.insertLeft(1);


        System.out.println("Expected: 1234");
        System.out.println("Actual: " + display(deque));

    }

    @Test
    public void insertRight() {
        deque.insertRight(5);
        deque.insertRight(6);

        System.out.println("Expected: 3456");
        System.out.println("Actual: " + display(deque));

    }

    @Test
    public void removeLeft() {
        deque.removeLeft();

        assertEquals(4, getElement(deque));

    }

    @Test
    public void removeRight() {
        deque.removeRight();

        assertEquals(3, getElement(deque));

    }

    private int getElement(Deque<Integer> deque) {
        return deque.removeLeft();
    }

    private String display(Deque<Integer> deque) {
        StringBuilder str = new StringBuilder();
        while(!deque.isEmpty()) {
            str.append(deque.removeLeft());
        }

        return String.valueOf(str);
    }
}