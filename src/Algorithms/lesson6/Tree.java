package Algorithms.lesson6;

import Algorithms.ICollection;

public interface Tree<E extends Comparable<? super E>> extends ICollection, Iterable<E> {

    enum TraversMode {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }

    boolean add(E value);

    boolean find(E value);

    boolean remove(E value);

    void display();

    boolean isBalanced();

    void traverse(TraversMode mode);

    int deep();
}
