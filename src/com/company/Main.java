package com.company;


import java.util.Scanner;

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
        Node prev;
        Node cur;
        if (isempty()) {
            return 0;
        }
        else {
            if (tail.next == null) {
                Node tmp = tail;
                head = null;
                tail = null;
                return tmp.value;
            } else {
                prev = tail;
                cur = tail;

                while (cur.next != null) {
                    prev = cur;
                    cur = cur.next;
                }
                prev.next = null;
                return cur.value;
            }
        }
    }

    int answer() {
        int answer = 0;

        if (isempty()) {
            return 0;
        } else {
            Node cur = this.head;
            while (cur != null) {
                answer += cur.value;
                cur = cur.next;
            }
            return answer;
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
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        for (int i = 0; i < K; i++) {
            int number = sc.nextInt();
            if (number == 0) {
                s.pop();
            } else {
                s.push(number);
            }
        }
        System.out.println(s.answer());
    }
}
