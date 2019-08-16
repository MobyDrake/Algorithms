package Algorithms.lesson3.queue;

public class QueueImpl<E> implements Queue<E> {

    private static final int DEFAULT_HEAD = 0;
    private final int DEFAULT_TAIL = -1;

    protected final E[] data;
    protected int size;

    protected int head;
    protected int tail;


    @SuppressWarnings("unchecked")
    public QueueImpl(int maxCapacity) {
        this.data = (E[]) new Object[maxCapacity];
        this.head = DEFAULT_HEAD;
        this.tail = DEFAULT_TAIL;
    }

    @Override
    public boolean insert(E value) {
        if (isFull()) return false;

        if (tail == lastIndex()) {
            tail = DEFAULT_TAIL;
        }
        data[++tail] = value;
        size++;
        return true;
    }


    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }

        if (head == data.length) {
            head = DEFAULT_HEAD;
        }

        E value = data[head++];
        size--;
        return value;
    }

    @Override
    public E peek() {
        return isEmpty() ? null : data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    private int lastIndex() {
        return data.length - 1;
    }
}
