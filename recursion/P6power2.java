package recursion;

public class P6power2 {
    public static int calPower (int x, int n) {
        if (n==0) {
            return 1;
        }
        if (x==0) {
            return 0;
        }

        if (n%2==0) {
            return calPower(x, n/2) * calPower(x, n/2);
        }
        else {
            return calPower(x, n/2) * calPower(x, n/2) * x;
        }
    }
    public static void main(String[] args) {
        System.out.println("04052025");
        int x = 2;
        int n = 5;
        int power = calPower(x, n);
        System.out.println(power);
    }
}
