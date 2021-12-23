//package com.company;
//
//
//import java.util.Scanner;
//
//class Stack<T> {
//    private class Node{
//        private int value;
//        private Node next;
//
//        public Node() {
//            this.next = null;
//            this.value = 0;
//        }
//        public Node(int value) {
//            this.next = null;
//            this.value = value;
//        }
//        public Node(int value, Node next) {
//            this.next = next;
//            this.value = value;
//        }
//
//    }
//
//    private Node head;
//    private Node tail;
//
//    public Stack() {
//        head = null;
//        tail = null;
//    }
//
//    void push(int value) {
//        Node newNode = new Node(value);
//
//        if (isempty()) {
//            this.head = newNode;
//            this.tail = this.head;
//        } else {
//            Node tmp = tail;
//            while (tmp.next != null) {
//                tmp = tmp.next;
//            }
//            tmp.next = newNode;
//        }
//    }
//
//    int peek() {
//        if (isempty()) {
//            return 0;
//        } else {
//            Node cur = this.head;
//            while (cur.next != null) {
//                cur = cur.next;
//            }
//            System.out.println(cur.value);
//            return cur.value;
//        }
//    }
//
//    int pop() {
//        Node prev;
//        Node cur;
//        if (isempty()) {
//            return 0;
//        }
//        else {
//            if (tail.next == null) {
//                Node tmp = tail;
//                head = null;
//                tail = null;
//                return tmp.value;
//            } else {
//                prev = tail;
//                cur = tail;
//
//                while (cur.next != null) {
//                    prev = cur;
//                    cur = cur.next;
//                }
//                prev.next = null;
//                return cur.value;
//            }
//        }
//    }
//
//    int answer() {
//        int answer = 0;
//
//        if (isempty()) {
//            return 0;
//        } else {
//            Node cur = this.head;
//            while (cur != null) {
//                answer += cur.value;
//                cur = cur.next;
//            }
//            return answer;
//        }
//
//
//    }
//
//    boolean isempty() {
//        if (this.tail == null) {
//            return true;
//        }
//        return false;
//    }
//}
//
//public class Main {
//
//    public static void main(String[] args) {
//	    Stack<Integer> s = new Stack<Integer>();
//        Scanner sc = new Scanner(System.in);
//        int K = sc.nextInt();
//
//        for (int i = 0; i < K; i++) {
//            int number = sc.nextInt();
//            if (number == 0) {
//                s.pop();
//            } else {
//                s.push(number);
//            }
//        }
//        System.out.println(s.answer());
//    }
//}
package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Stack {
    int [] stack;
    int stackSize;
    int top;

    public Stack(int size) {
        this.stackSize = size;
        this.stack = new int[size];
        this.top = 0;
    }

    boolean isEmpty() {
        if (this.stack[this.top] == 0) {
            return true;
        }
        return false;
    }

    boolean isFull() {
        if (this.stack[this.stack.length - 1] != 0) {
            return true;
        }

        return false;
    }

    void push(int value) {
        if (isFull()) {
            return;
        } else {
            if (isEmpty()) {
                this.stack[0] = value;
            } else {
                this.stack[this.top + 1] = value;
                this.top++;
            }
        }
    }

    int answer() {
        int answer = 0;
        for (int i: this.stack) {
            answer += i;
        }
        return answer;
    }

    void pop() {
        if (isEmpty()) {
            return;
        }
        this.stack[this.top] = 0;
        if (this.top >= 1) {
            this.top--;
        }

    }


}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        Stack s = new Stack(N);
        for (int i=0; i < N; i++){
            int number = Integer.parseInt(bf.readLine());

            if (number == 0) {
                s.pop();
            } else {
                s.push(number);
            }
        }
        System.out.println(s.answer());
        bf.close();
    }
}