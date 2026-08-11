package queue;

public class LLQueue {
    static class  Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
       static Node Head;
       static Node Tail;

        public boolean isEmpty () {
            return Head == null && Tail == null;
        }

        public void add(int data ) {
            Node newNode = new Node(data);

            if (Head==null) {
                Head = Tail = newNode;
            }
            Tail.next = newNode;
            Tail = newNode;
        }

        public int remove () {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }

            int data = Head.data;
            if(Head == Tail) {
                Head = Tail = null;
            }
            else{
                Head = Head.next;
            }

            return data;
        }

        public int peek () {
           if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
             
            return Head.data;
        }
    }

    public static void main(String[] args) {
        Queue Q = new Queue();

        Q.add(3);
        Q.add(5);
        Q.add(9);
        Q.add(3);

        while (!Q.isEmpty()) {
            System.out.println(Q.peek());
            Q.remove();
        }
    }

}
