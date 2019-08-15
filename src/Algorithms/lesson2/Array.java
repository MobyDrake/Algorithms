package lesson2;

public interface Array<E> {

    void add(E value);

    default void addAll(E... values) {
        for(E value : values) {
            add(value);
        }
    }

    boolean remove(int index);
    boolean remove(E value);

    E get(int index);

    boolean contain(E value);
    int indexOf(E value);

    int size();
    boolean isEmpty();

    void display();

    void sortBubble();
    void sortSelect();
    void sortInsert();
}
