package com.company;


class Stack<T> {
    private class Node{
        private int value;
        private Node next;

        public Node() {
            this.next = null;
            this.value = 0;
        }
        public Node(int value) {
            this.next = null;
            this.value = value;
        }
        public Node(int value, Node next) {
            this.next = next;
            this.value = value;
        }

    }

    private Node head;
    private Node tail;

    public Stack() {
        head = null;
        tail = null;
    }

    void push(int value) {
        Node newNode = new Node(value);

        if (isempty()) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            Node tmp = tail;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = newNode;
        }
    }

    int peek() {
        if (isempty()) {
            return 0;
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            System.out.println(cur.value);
            return cur.value;
        }
    }

    int pop() {
        if (isempty()) {
            return 0;
        } else {
            Node cur = this.head;
            while (cur.next.next != null) {
                cur = cur.next;
            }
            Node tmp = cur.next;
            cur.next = null;
            return tmp.value;
        }
    }

    boolean isempty() {
        if (this.tail == null) {
            return true;
        }
        return false;
    }
}

public class Main {

    public static void main(String[] args) {
	    Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.peek();
        System.out.println(s.pop());
        s.peek();
    }
}
