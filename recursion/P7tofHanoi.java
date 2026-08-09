package recursion;

public class P7tofHanoi {
    public static void towerOfHanoi (int n, String S, String H, String D) {
        if (n==1) {
            System.out.println("disk "+n+ " transfer "+S+" to "+D);
            return;
        }
        towerOfHanoi(n-1, S, D, H);
        System.out.println("disk "+n+ " transfer "+S+" to "+D);
        towerOfHanoi(n-1, H, S, D);
    }
    public static void main(String[] args) {
        System.out.println("05052025");
        int n = 2;
        towerOfHanoi(n, "source", "helper", "destination");
    }
}
