package bitManipulation;

public class P2oddEven {
    public static void check(int n) {
        int bitMask = 1;
        if ((n&bitMask) == 0) {
            System.out.println("number is even");
        }
        else {
            System.out.println("number is odd");
        }
    }
    public static void main(String[] args) {
        check(9);
    }
    
}
