package bitManipulation;

public class P3operation {
    public static void checkIthbit(int n, int i) {
        int bitMask = 1<<i;
        if((n&bitMask)==1) {
            System.out.println("bit at index "+i+" is 1");
        }
        else {
            System.out.println("bit at index "+i+" is 0");
        }
    }

    public static int setIthbit(int n, int i) {
        int bitMask = 1<<i;
        return n|bitMask ;
    }

    public static int clearIthbit(int n, int i) {
        int bitMask = ~(1<<i);
        return n&bitMask ;
    }

    public static int updateIthbit (int n, int i, int updtbit) {
        n = clearIthbit(n, updtbit);
        int bitmask = updtbit<<i;
        return n|bitmask;
    }

    public static int clearLastIbit (int n, int i) {
        int bitMask = (~0)<<i;
        return n&bitMask;
    }

    public static int clearRangeOfbit (int n, int i, int j) {
        int a = ((~0)<<(j+1));
        int b = (1<<i)-1;
        int bitMask = a|b;
        return n&bitMask;
    }
    public static void main(String[] args) {
        checkIthbit(9, 2);
        System.out.println(setIthbit(9, 2));
        System.out.println(clearIthbit(9, 3));
        System.out.println(updateIthbit(1, 3, 1));
        System.out.println(clearIthbit(15, 3));
        System.out.println(clearRangeOfbit(10, 2, 4));
    }
}
