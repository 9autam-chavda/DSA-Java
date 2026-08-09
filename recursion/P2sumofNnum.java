package recursion;
import java.util.Scanner;

public class P2sumofNnum {
    public static void sum(int n, int sum) {
        if (n == 0 ) {
            System.out.println(sum);
            return;
        }
        sum += n;
        sum(n-1, sum); 
    }
    public static void main(String[] args) {
        System.out.println("04052025");
        int sum=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("enter num for sum : ");
        int n = sc.nextInt();
        sum(n, sum);
        sc.close();
    }
}