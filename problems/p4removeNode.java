package problems;
import LinkedList.LinkedList;

// in this we have to remove a node from a linked list
// that node is count from tail 
// we start counting of that node from tail

public class p4removeNode {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node Head;
    public static Node Tail;
    public static int size;
    public static Object prev;

    public static void removeNode (int n) {
        int sz=0;
        LinkedList.Node temp = LinkedList.Head;
        while (temp != null) {
            sz++;
            temp = temp.next;
        }

        if(n==sz) {
            LinkedList.Head = LinkedList.Head.next;
            return;
        }
        if(n>sz) {
            System.out.println("Node not exist");
            return;
        }
        int idx = sz-n;
        LinkedList.Node prev = LinkedList.Head; 
        while (1 < idx) {
            prev = prev.next;
            idx--;
        }

        prev.next = prev.next.next;

    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.addFirst(6);
        ll.addFirst(7);

        removeNode(3);
        
        ll.print();
    }
}
