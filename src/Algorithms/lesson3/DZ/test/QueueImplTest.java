package Algorithms.lesson3.DZ.test;

import Algorithms.lesson3.queue.Queue;
import Algorithms.lesson3.queue.QueueImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueImplTest {

    private Queue<Integer> queue;

    @Before
    public void setUp() throws Exception {
        queue = new QueueImpl<>(5);
    }

    @Test
    public void insert() {
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);

        assertEquals(new Integer[3].length, queue.size());
    }

    @Test
    public void remove() {
        queue.insert(1);
        queue.insert(2);

        assertEquals(1, (int) queue.remove());
    }

    @Test
    public void peek() {
        queue.insert(1);
        queue.insert(2);

        assertEquals(1, (int) queue.peek());
    }
}