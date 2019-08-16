package Algorithms.lesson3.DZ.test;

import Algorithms.lesson3.stack.Stack;
import Algorithms.lesson3.stack.StackImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackImplTest {

    private Stack<Integer> stack;

    @Before
    public void setUp() {
        stack = new StackImpl<>(3);
    }

    @Test
    public void push() {
        stack.push(1);
        stack.push(2);
        stack.push(3);


        assertEquals(new Integer[3].length, stack.size());
    }

    @Test
    public void peek() {
        stack.push(5);
        assertEquals(5, (int) stack.peek());
    }

    @Test
    public void pop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while (!stack.isEmpty()) {
            stack.pop();
        }

        assertEquals(new Integer[0].length, stack.size());
        //assertTrue(stack.isEmpty());
    }


}