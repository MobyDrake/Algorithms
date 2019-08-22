package Algorithms.lesson3.DZ.test;

import Algorithms.lesson3.stack.Brackets;
import org.junit.Test;

public class BracketsTest {

    @Test
    public void checkCurrect() {
        String text = "public static int getRandom() {        int a = 1;        int b = Integer.MAX_VALUE;        return a + (int) (Math.random() * b);    }";
        new Brackets(text).check();
    }

    @Test
    public void checkUnCurrect() {
        System.out.println("test: UnCurrect");
        String text = "    private static void addToStack(Stack{Integer> stack, int value) {        if (!stack.isFull(]) {            stack.push(value;        }    }";
        new Brackets(text).check();

    }
}
