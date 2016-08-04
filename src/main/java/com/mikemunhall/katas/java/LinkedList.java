package com.mikemunhall.katas.java;

public class LinkedList {

    private Node head;
    private Integer count;

    public LinkedList() {
        head = new Node(null);
        count = 0;
    }

    public void add(Object data) {
        Node newNode = new Node(data);

        if (head.getData() == null) {
            head.setData(data);
        } else {
            Node current = head;
            while (current.hasNext()) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }

        count++;
    }

    public Node get(Integer index) {
        Node node = head;
        for(int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    public void remove(Integer index) {
        Node beforeNode = null;
        Node afterNode = null;
        Node currentNode = head;

        if (count <= index || index > count) {
            throw new IllegalArgumentException("index out of bounds");
        }

        if (index == 0 && count == 1) {
            head.setData(null);
        } else if (index == 0 && count == 2) {
            head = head.getNext();
        } else {
            for (int i = 0; i <= index + 1; i++) {
                if (i == index - 1) {
                    beforeNode = currentNode;
                }
                if (i == index + 1 && i < count - 1) {
                    afterNode = currentNode;
                }
                if (currentNode.hasNext()) {
                    currentNode = currentNode.getNext();
                }
            }

            beforeNode.setNext(afterNode);
        }

        count--;
    }

    public Integer size() {
        return count;
    }
}

class Node {

    private Object data;
    private Node next;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public Boolean hasNext() {
        return next != null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node node) {
        this.next = node;
    }

}
