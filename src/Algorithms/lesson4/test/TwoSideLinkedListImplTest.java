package Algorithms.lesson4.test;

import Algorithms.lesson4.linkedList.TwoSideLinkList;
import Algorithms.lesson4.linkedList.TwoSideLinkedListImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSideLinkedListImplTest {

    private TwoSideLinkList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new TwoSideLinkedListImpl<>();
    }

    @Test
    public void insertLast() {
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);

        assertEquals(1, (int) list.removeFirst());

    }

}