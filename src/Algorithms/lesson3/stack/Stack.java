package Algorithms.lesson3.stack;

import Algorithms.ICollection;

public interface Stack<E> extends ICollection {

    void push(E value);

    E pop();

    E peek();
}
