package LinkedList;

public class LinkedList {
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

    public void addFirst (int data) {
        // create a node
        Node newNode = new Node(data);
        size++;

        if(Head==null) {
            Head = Tail = newNode;
            return;
        }

        // give head value to  the objects next
        newNode.next = Head;

        //make newnode head
        Head = newNode;
    }

    public void addLast (int data) {
        Node newNode = new Node(data);
        size++;

        if (Head==null) {
            Head=Tail=newNode;
            return;
        }

        Tail.next = newNode;

        Tail = newNode;
    }

    public void add(int idx, int data) {
        if(idx==0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = Head;
        int i = 0;

        while (i < idx-1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next=newNode;
    }

     public void print() {
        Node temp = Head;
        while (temp!=null) {
            System.out.print(temp.data + "-> ");
            temp=temp.next; 
        }
        System.out.println("null");
        
    }

    public int removeFirst() {
        if(size==0) {
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }
        else if (size==1) {
            int val = Head.data;
            Head = Tail = null;
            size=0;
            return val;
        }
        int val = Head.data;
        Head = Head.next;
        size--;
        return val;
    }

    public int removeLast() {
        int val = Tail.data;
        if(size==0){
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            Head = Tail = null;
            size = 0;
            return val;
        }

        Node prevNode = Head;
        for(int i=0; i<size-2; i++) {
            prevNode = prevNode.next;
        }
        Tail = prevNode;
        Tail.next = null;
        size--;
        return val;
    }

    public void itrSearch (int key) {
        Node temp = Head;
        int i = 0;
        while (temp!=null) {
            if(temp.data==key) {
                System.out.println(key + " found at idx " + i);
                return;
            }
            temp=temp.next;
            i++;
        }
        System.out.println("key does not exist!");
    }

    public int helper(Node Head, int key) {
        if(Head==null) {
            return -1;
        }

        if(Head.data==key) {
            return 0;
        }

        int idx = helper(Head.next, key);
        if(idx==-1) {
            return-1;
        }
        return idx+1;
    }
    public int recSearch(int key) {
        return helper(Head, key);
    }

    public void reverseLL() {
        Node prev = null;
        Node curr = Tail = Head;
        Node next;

        while (curr!=null) {
            next=curr.next;
            curr.next = prev;
            curr = prev;
            prev = next;
        }

        Head = prev;
    }

    public Node findMid (Node Head) {
        Node fast = Head;
        Node slow = Head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next; //+2 step
            slow = slow.next; // +1 step
        }

        return slow; //it is a mid value
    }

    public static boolean checkCycle () {
        Node slow = Head;
        Node fast = Head;

        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast==slow) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle () {
        // #check cycle
        Node slow = Head;
        Node fast = Head;

        boolean cycle = false;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow) {
                cycle=true;
                break;
            }
        }

        if(cycle==false) {
            return;
        }

        // #remove cycle
        slow = Head;
        Node prev = null;
        while (slow!=fast) {
            prev= fast;
            fast = fast.next;
            slow = slow.next;
        }

        prev.next=null;

    }

    private Node getMid(Node Head) {
        Node slow = Head;
        Node fast = Head.next;

        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node Head1, Node Head2) {
        Node mergell = new Node(-1);
        Node temp = mergell;

        while (Head1!=null && Head2!=null) {
            if (Head1.data<=Head2.data) {
                temp.next = Head1;
                Head1 = Head1.next;
                temp = temp.next;
            }
            else if (Head1.data>=Head2.data) {
                temp.next = Head2;
                Head2 = Head2.next;
                temp = temp.next;    
            }
        }

        while (Head1!=null) {
            temp.next = Head1;
            Head1 = Head1.next;
            temp = temp.next; 
        }

        while (Head2!=null) {
            temp.next = Head2;
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
        LinkedList ll = new LinkedList();
        ll.addFirst(7);
        ll.addFirst(9);
        ll.addFirst(7);
        ll.addFirst(5);
        ll.addFirst(1);
       

        System.out.println("unsorted linkedlist");
        ll.print();
        Head=ll.mergeSort(Head);
        System.out.println("sorted linkedlist");
        ll.print();
    }
}
