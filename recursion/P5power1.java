package recursion;

public class P5power1 {

    public static int calPower(int x, int n) {
        if (n==0) {
            return 1;
        }
        if (x==0) {
            return 0;
        }

        int power = calPower(x, n-1);
        int pow = power * x;
        return pow;
        
    }
    public static void main(String[] args) {
        System.out.println("04052025");
        int x=2;
        int n=5;
        int totalp = calPower(x, n);
        System.out.println(totalp);

    }
}
