package com.bgs.Login.link;

public class Node {

    Object value;
    Node next;
    Node up;

    public Node(Object value, Node next, Node up) {
        this.value = value;
        this.next = next;
        this.up = up;
    }

    public Node() {
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getUp() {
        return up;
    }

    public void setUp(Node up) {
        this.up = up;
    }
}
