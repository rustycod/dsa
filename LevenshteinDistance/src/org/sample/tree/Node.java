package org.sample.tree;

public class Node<T extends Comparable<?>> {
    Node<T> left, right, sibling;
    T data;

    public Node(T data) {
        this.data = data;
    }
}