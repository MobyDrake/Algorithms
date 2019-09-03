package Algorithms.lesson6;

import java.util.Iterator;
import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> root;
    private int size;

    @Override
    public boolean add(E value) {
        Node<E> node = new Node<>(value);

        NodeAndParent nodeAndParent = doFind(value);
        Node<E> previous = nodeAndParent.parent;

        if(nodeAndParent.isEmpty()) {
            this.root = node;
            return true;
        }
        else if (nodeAndParent.current != null) {
            return false;
        }
        else if (previous.shouldBeLeft(value)) {
            previous.setLeftChild(node);
        }
        else {
            previous.setRightChild(node);
        }

        size++;
        return true;
    }

    @Override
    public boolean find(E value) {
        return doFind(value).current != null;
    }

    private NodeAndParent doFind(E value) {
        if (isEmpty()) {
            return new NodeAndParent(null, null);
        }

        Node<E> parent = null;
        Node<E> current = this.root;

        do {
            if (current.getValue().equals(value)) {
                return new NodeAndParent(current, parent);
            }

            parent = current;

            if (current.shouldBeLeft(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        } while (current != null);

        return new NodeAndParent(null, parent);
    }

    @Override
    public boolean remove(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        Node<E> parent = nodeAndParent.parent;
        Node<E> removeNode = nodeAndParent.current;

        if (removeNode == null) {
            return false;
        }
        else if (removeNode.isLeaf()) {
            removeLeafNode(parent, removeNode);
        }
        else if (removeNode.hasOnlySingleChild()) {
            removeNodeSingleChild(parent, removeNode);
        }
        else {
            removeNode(parent, removeNode);
        }
        size--;
        return true;
    }

    //удаленеи узла с листьями\элемент с двумя потомками
    private void removeNode(Node<E> parent, Node<E> removeNode) {
        Node<E> successor = getSuccessor(removeNode);
        if (removeNode == root) {
            root = successor;
        }
        else if (parent.getLeftChild() == removeNode) {
            parent.setLeftChild(successor);
        }
        else {
            parent.setRightChild(successor);
        }

        successor.setLeftChild(removeNode.getLeftChild());
    }

    private Node<E> getSuccessor(Node<E> removeNode) {
        Node<E> successor = removeNode;
        Node<E> successorParent = null;
        Node<E> current = removeNode.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != removeNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removeNode.getRightChild());
        }

        return successor;
    }

    //удаление узла с одни потомком \ элемент с одним потомком
    private void removeNodeSingleChild(Node<E> parent, Node<E> removeNode) {
        Node<E> childNode = removeNode.getLeftChild() != null
                ? removeNode.getLeftChild()
                : removeNode.getRightChild();

        if (removeNode == root) {
            root = childNode;
        }
        else if (parent.getLeftChild() == removeNode){
              parent.setLeftChild(childNode);
        } else {
            parent.setRightChild(childNode);
        }
    }

    //удаление лист\элемент без потомков
    private void removeLeafNode(Node<E> parent, Node<E> removeNode) {
        if (removeNode == root) {
            root = null;
        }
        else if (parent.getLeftChild() == removeNode) {
            parent.setLeftChild(null);
        } else {
            parent.setRightChild(null);
        }
    }

    @Override
    public void display() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    @Override
    public boolean isBalanced() {
        return isBalancedP(root);
    }

    @Override
    public int deep() {
        return height(root);
    }

    private boolean isBalancedP(Node<E> node) {
        return (node == null) ||
                isBalancedP(node.getLeftChild()) &&
                        isBalancedP(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private int height(Node<E> node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    @Override
    public void traverse(TraversMode mode) {
        switch (mode) {
            case IN_ORDER: inOrder(root);
            break;
            case PRE_ORDER: preOrder(root);
            break;
            case POST_ORDER: postOrder(root);
            break;
            default: throw new IllegalArgumentException("Unknown traver mode: " + mode);
        }
    }

    private void inOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild());
        System.out.print(current.getValue() + " ");
        inOrder(current.getRightChild());
    }

    private void preOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        System.out.print(current.getValue() + " ");
        inOrder(current.getLeftChild());
        inOrder(current.getRightChild());
    }

    private void postOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild());
        inOrder(current.getRightChild());
        System.out.print(current.getValue() + " ");

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Iterator<E> iterator() {

        return null;

//        return new Iterator<E>() {
//            Node<E> current = root;
//
//            @Override
//            public boolean hasNext() {
//                return current != null;
//            }
//
//            @Override
//            public E next() {
//                E value = current.getValue();
//
//                return value;
//            }
//        };
    }

    private class NodeAndParent {
        Node<E> current;
        Node<E> parent;

        public NodeAndParent(Node<E> current, Node<E> parent) {
            this.current = current;
            this.parent = parent;
        }

        public boolean isEmpty() {
            return current == null && parent == null;
        }
    }


}
