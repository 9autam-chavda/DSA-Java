package LinkedList;
import java.util.LinkedList;

public class mergeSort1 {
    
   static class Node {
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

    private Node getMid(Node Head) {
        Node fast = Head.next;
        Node slow = Head;

        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private Node merge(Node Head1, Node Head2) {
        Node mergell = new Node(-1);
        Node temp = mergell;

        while (Head1!=null && Head2!=null) {
            if (Head1.data<=Head2.data) {
                temp = Head1;
                Head1 = Head1.next;
                temp = temp.next;
            }
            else {
                temp = Head2;
                Head2 = Head2.next;
                temp = temp.next;
            }
        }
        while (Head1!=null) {
            temp = Head1;
            Head1 = Head1.next;
            temp = temp.next; 
        }

        while (Head2!=null) {
            temp = Head2;
            Head2 = Head2.next;
            temp = temp.next;
        }

        return mergell.next;
    }

    public Node mergeSort (Node Head) {
        if (Head == null || Head.next == null) {
            return Head;
        }

        Node Mid = getMid(Head);

        Node rightHead = Mid.next;
        Mid.next = null;

        Node newLeft = mergeSort(Head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft, newRight);
    }

    public static void main(String[] args) {
        mergeSort1 ms = new mergeSort1();
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(5);
        ll.addFirst(7);
        ll.addFirst(1);
        ll.addFirst(9);
        ll.addFirst(7);

        System.out.println("unsorted linkedlist");
        System.out.println(ll);
        Head = ms.mergeSort(Head);
        System.out.println("sorted linkedlist");
        System.out.println(ll);

        
    }
    
}
