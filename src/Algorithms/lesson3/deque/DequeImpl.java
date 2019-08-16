package Algorithms.lesson3.deque;


import Algorithms.lesson3.queue.QueueImpl;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E>  {


    public DequeImpl(int maxCapacity) {
        super(maxCapacity);
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()) return false;

        if (head == 0) {
            head = data.length;
        }

        data[--head] = value;
        size++;

        return true;
    }

    @Override
    public boolean insertRight(E value) {
        return super.insert(value);
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }

    @Override
    public E removeRight() {
        if (isEmpty()) return null;

        if (tail < 0) {
            tail = data.length - 1;
        }

        E value = data[--tail];
        size--;
        return value;
    }
}
