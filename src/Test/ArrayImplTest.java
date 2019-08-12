package Test;

import lesson2.Array;
import lesson2.ArrayImpl;
import org.junit.Before;
import org.junit.Test;


public class ArrayImplTest {

    private Array<Integer> array;

    @Before
    public void set() {
        array = new ArrayImpl<>();

        for (int i = 0; i < 10000; i++) {
            array.add(getRandom());
        }
    }

    private int getRandom() {
        int a = 1;
        int b = Integer.MAX_VALUE;

        return a + (int) (Math.random() * b);
    }

    @Test
    public void sortBubble() {
        System.out.println("start Bubble");
        long start = System.currentTimeMillis();
        array.sortBubble();
        System.out.println(System.currentTimeMillis() - start);
    }


    @Test
    public void sortSelect() {
        System.out.println("start Select");
        long start = System.currentTimeMillis();
        array.sortSelect();
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void sortInsert() {
        System.out.println("start Insert");
        long start = System.currentTimeMillis();
        array.sortInsert();
        System.out.println(System.currentTimeMillis() - start);
    }
}