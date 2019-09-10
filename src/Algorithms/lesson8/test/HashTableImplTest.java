package Algorithms.lesson8.test;

import Algorithms.lesson8.HashTable;
import Algorithms.lesson8.HashTableImpl;
import Algorithms.lesson8.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableImplTest {

    private HashTable<Item, Integer> hashTable;

    private Item orange = new Item(1, "Orange", 150);
    private Item banana = new Item(71, "Banana", 100);
    private Item lemon = new Item(60, "Lemon", 250);
    private Item milk = new Item(52, "Milk", 120);

    private Item potato = new Item(21, "Potato", 67);

    private Item bug = new Item(255, "Bug", 555);

    @Before
    public void setUp() throws Exception {
        hashTable = new HashTableImpl<>(5);
//        hashTable = new DoubleHashTableImpl<>(10);

        hashTable.put(orange, orange.cost);
        hashTable.put(banana, banana.cost);
        hashTable.put(lemon, lemon.cost);
        hashTable.put(milk, milk.cost);
    }

    @Test
    public void put() {
        assertEquals(4, hashTable.size());

        hashTable.put(potato, potato.cost);

        assertEquals(5, hashTable.size());
        assertEquals((Integer) 67, hashTable.get(potato));

    }

    @Test
    public void get() {
        assertEquals((Integer) 250, hashTable.get(lemon));
        assertNull(hashTable.get(bug));
    }

    @Test
    public void contains() {
        assertTrue(hashTable.contains(banana));
        assertFalse(hashTable.contains(bug));
    }

    @Test
    public void remove() {
        assertEquals(4, hashTable.size());
        assertEquals((Integer) 100, hashTable.remove(banana));
        assertEquals(3, hashTable.size());
    }

    @After
    public void display() {
        hashTable.display();
    }
}