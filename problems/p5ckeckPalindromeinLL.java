package problems;
import LinkedList.LinkedList;

public class p5ckeckPalindromeinLL {
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

    public Node findMid (Node Head) {
        Node fast = Head;
        Node slow = Head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next; //+2 step
            slow = slow.next; // +1 step
        }

        return slow; //it is a mid value
    }

    public boolean checkPallindrom1 ()  {
        if(LinkedList.Head == null && LinkedList.Head.next == null) { // check for if head has null or single element
            return true;
        }

        // in this step we will do the reverse linkedlist from middle
        Node mid = findMid(null);

        Node curr = mid;
        Node prev = null;
         while (curr!=null) {
            Node next=curr.next;
            curr.next = prev;
            curr = prev;
            prev = next;
        }

        Node left = Head;
        Node right = prev; 

        // now we will compare the left and right part of the linked list
        while (right != null) {
            if (left.data != right.data) {
                return false; 
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
    public static void main(String[] args) {
        p5ckeckPalindromeinLL checker = new p5ckeckPalindromeinLL();
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(2);

        ll.print();
        boolean check = checker.checkPallindrom1();
        System.out.println(check);
    }
}
