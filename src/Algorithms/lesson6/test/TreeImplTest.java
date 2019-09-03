package Algorithms.lesson6.test;

import Algorithms.lesson6.Tree;
import Algorithms.lesson6.TreeImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeImplTest {

    private Tree<Integer> tree;

    @Before
    public void setUp() throws Exception {
        tree = new TreeImpl<>();

        tree.add(60);
        tree.add(50);
        tree.add(66);
        tree.add(70);
        tree.add(67);
        tree.add(81);
        tree.add(40);
        tree.add(31);
        tree.add(45);
        tree.add(55);
        tree.add(57);
    }

    @Test
    public void add() {

        assertTrue(tree.add(555));
        assertTrue(tree.find(555));

        assertTrue(tree.add(1));
        assertTrue(tree.find(1));

        assertFalse(tree.add(555));
        assertTrue(tree.find(555));
    }

    @Test
    public void find() {
//        System.out.println("Root is 60: " + tree.find(60));
//        System.out.println("Find 70: " + tree.find(70));
//        System.out.println("Find 31: " + tree.find(31));
//        System.out.println("Find 555: " + tree.find(555));
        assertTrue(tree.find(60));
        assertTrue(tree.find(70));
        assertTrue(tree.find(31));
        assertFalse(tree.find(555));

    }

    @Test
    public void traverse() {
        tree.traverse(Tree.TraversMode.IN_ORDER);
        System.out.println("\n-------------------");
        tree.traverse(Tree.TraversMode.PRE_ORDER);
        System.out.println("\n-------------------");
        tree.traverse(Tree.TraversMode.POST_ORDER);
    }

    @Test
    public void display() {
        tree.display();
        System.out.println(tree.isBalanced());
    }

    @Test
    public void remove() {
        Tree<Integer> tree1 = new TreeImpl<>();

        tree1.add(60);
        tree1.add(25);
        tree1.add(66);
        tree1.add(15);
        tree1.add(5);
        tree1.add(20);
        tree1.add(45);
        tree1.add(30);
        tree1.add(55);
        tree1.add(32);

        tree1.display();

        tree1.remove(60);

        tree1.display();

    }
}