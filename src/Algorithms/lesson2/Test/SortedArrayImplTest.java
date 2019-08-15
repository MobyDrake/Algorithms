package lesson2.Test;

import lesson2.Array;
import lesson2.SortedArrayImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedArrayImplTest {

    private Array<Integer> array;

    @Before
    public void set() {
        array = new SortedArrayImpl<>();

        array.add(5);
        array.add(2);
        array.add(1);
        array.add(10);
        array.add(4);
    }

    @Test
    public void add() {
//        array.add(5);
//        array.add(2);
//        array.add(1);
//        array.add(10);
//        array.add(4);

        array.display();
    }

    @Test
    public void indexOf() {
        System.out.println("Index 5: " + array.indexOf(5));
        assertEquals(3, array.indexOf(5));
    }
}