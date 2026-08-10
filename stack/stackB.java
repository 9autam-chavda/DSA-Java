package stack;

import java.util.ArrayList;

public class stackB {


    // stack using arralist
    static class stack {
        ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.size() == 0;
        }

        public void push(int data) {
            list.add(data);
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            int data = list.get(list.size()-1);
            list.remove(list.size()-1);
            return data;
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size()-1);
        }
        
    }

    // stack using linkedlist
    static class Node {
        int data;
        Node next;
        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class stack1 {
        static Node Head = null;

        public boolean isEmpty() {
            return Head == null;
        }

        public void push(int data) {
            Node newNode = new Node(data);

            if(isEmpty()) {
                Head = newNode;
                return;
            }

            newNode.next = Head;
            Head = newNode;
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            int popData = Head.data;
            Head = Head.next;
            return popData;
        }

        public int peek () {
            if (isEmpty()) {
                return -1;
            }
            return Head.data;
        }
    }

    public static void main (String[] args) {
        stack1 s = new stack1();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}