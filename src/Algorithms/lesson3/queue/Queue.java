package Algorithms.lesson3.queue;

import Algorithms.ICollection;

public interface Queue<E> extends ICollection {

    boolean insert(E value);

    E remove();

    E peek();


}
