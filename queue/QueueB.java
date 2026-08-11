package queue;

public class QueueB {

    /* LINEAR QUEUE */
    /* 
     * static class Queue {
       static int arr[];
        static int size;
        static int rear;
        Queue (int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public boolean isEmpty () {
            return rear == -1;
        }

        public void add(int data ) {
            if (rear==size-1) {
                System.out.println("queue is full");
                return;
            }
            rear= rear+1;
            arr[rear] = data;
        }

        public int remove () {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }

            int front = arr[0];
            for (int i=0; i<rear; i++) {
                arr[i] = arr[i+1];
            }
            rear--;
            return front;
        }

        public int peek () {
           if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
             
            return arr[0];
        }
    }
     */
    
    /* CIRCULER QUEUE */
    static class circulerQ {
        static int[] arr;
        static int size;
        static int front;
        static int rear;

        circulerQ(int n) {
            arr = new int[n];
            size = n;
            front = -1;
            rear = -1;
        }

        public boolean isEmpty () {
            return front==-1 && rear==-1;
        }
        
        public boolean isFull () {
            return (rear+1) % size == front;
        }

        public void add(int data) {
            if (isFull()) {
                System.out.println("circuler queue is full");
                return;
            }
            if (front==-1) {
                front = 0;
            }

            rear = (rear+1) % size;
            arr[rear] = data;
        }

        public int remove () {
            if (isEmpty()) {
                System.out.println("circuler queue is empty");
                return -1;
            }

            int result = arr[front];
            if (rear == front) {
                rear = front = -1;
            }
            else {
                front = (front+1)%size;
            }

            return result;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("circuler queue is empty");
                return -1;
            }

            return arr[front];
        }
    }

    public static void main(String[] args) {
        /*
         * Queue Q = new Queue(9);

        Q.add(3);
        Q.add(5);
        Q.add(9);
        Q.add(3);

        while (!Q.isEmpty()) {
            System.out.println(Q.peek());
            Q.remove();
        }

         */
        
        circulerQ CQ = new circulerQ(9);
        CQ.add(9);
        CQ.add(8);
        CQ.add(3);
        CQ.add(7);

        while (!CQ.isEmpty()) {
            System.out.println(CQ.peek());
            CQ.remove();
        }
    }
}
