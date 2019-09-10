package Algorithms.lesson8;

import java.util.Optional;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    private class Node<K, V> implements HashTable.Entry<K, V>{

        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }
    }

    private int size;
    private Node<K, V>[] data;
    private int maxSize;


    @SuppressWarnings("unchecked")
    public HashTableImpl(int maxSize) {
        this.maxSize = maxSize;
        this.data = new Node[maxSize * 2];
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        if (isFull()) {
            //grow()/rehash()
            return false; //заглушка
        }

        int index = hashFunc(key);

        while (data[index] != null) {
            if (data[index].key.equals(key)) {
                data[index].value = value;
                return true;
            }
            index += getStep(key);
            index %= data.length; //if (index == data.length) index = 0;
        }

        data[index] = new Node<>(key, value);
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        return getEntry(key).map(entry -> entry.value).orElse(null);
//        Node entry = getEntry(key);
//        return entry != null ? entry.value : null;
    }

    //Optional обёртка
    private Optional<Node<K, V>> getEntry(K key) {
        int index = indexOf(key);
        if (index != -1) {
            return Optional.of(data[index]);
        }

        return Optional.empty();
    }

    private int indexOf(K key) {
        int index = hashFunc(key);
        while (data[index] != null) {
            Node current =  data[index];
            if (current.getKey().equals(key)) {
                return index;
            }
            index += getStep(key);
            index %= data.length;
        }

        return -1;
    }


    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public V remove(K key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }

        V result = data[index].getValue();
        data[index] = null;
        size--;
        return result;
    }

    @Override
    public void display() {
        System.out.println("--------------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]\n", i, data[i]);
        }
        System.out.println("--------------");
    }

    protected int getStep(K key) {
        return 1;
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
        return size == maxSize;
    }
}
